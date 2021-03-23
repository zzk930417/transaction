/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service.impl
 * 文件名: AccountInfoServiceImpl
 * 日期: 2020/7/5 15:02
 * 说明:
 */
package com.autumn.study.service.impl;

import com.autumn.study.dao.AccountInfoDao;
import com.autumn.study.dao.LocalCancelLogDao;
import com.autumn.study.dao.LocalConfirmLogDao;
import com.autumn.study.dao.LocalTryLogDao;
import com.autumn.study.entity.LocalCancelLog;
import com.autumn.study.entity.LocalTryLog;
import com.autumn.study.service.AccountInfoService;
import com.autumn.study.spring.Bank2Client;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Anbang713
 * @create 2020/7/5
 */
@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    private AccountInfoDao accountInfoDao;
    @Autowired
    private LocalTryLogDao localTryLogDao;
    @Autowired
    private LocalConfirmLogDao localConfirmLogDao;
    @Autowired
    private LocalCancelLogDao localCancelLogDao;
    @Autowired
    private Bank2Client bank2Client;

    @Transactional
    @Override
    //只要标记@Hmily就是try方法，在注解中指定confirm、cancel两个方法的名字
    @Hmily(confirmMethod="commit",cancelMethod="rollback")
    public void updateAccountBalance(String accountNo, Double amount) {
        //获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank1 try begin 开始执行...xid:{}",transId);
        //幂等判断 判断local_try_log表中是否有try日志记录，如果有则不再执行
        if(localTryLogDao.existsByTxNo(transId)){
            log.info("bank1 try 已经执行，无需重复执行,xid:{}",transId);
            return ;
        }

        //try悬挂处理，如果cancel、confirm有一个已经执行了，try不再执行
        if(localConfirmLogDao.existsByTxNo(transId) || localCancelLogDao.existsByTxNo(transId)){
            log.info("bank1 try悬挂处理  cancel或confirm已经执行，不允许执行try,xid:{}",transId);
            return ;
        }

        //扣减金额
        if(accountInfoDao.subtractAccountBalance(accountNo, amount)<=0){
            //扣减失败
            throw new RuntimeException("bank1 try 扣减金额失败,xid:{}"+transId);
        }
        //插入try执行记录,用于幂等判断
        LocalTryLog localTryLog = new LocalTryLog();
        localTryLog.setTxNo(transId);
        localTryLog.setCreateTime(new Date());
        localTryLogDao.save(localTryLog);

        //远程调用李四，转账
        if(!bank2Client.transfer(amount)){
            throw new RuntimeException("bank1 远程调用李四微服务失败,xid:{}"+transId);
        }
        if(amount == 2){
            throw new RuntimeException("人为制造异常,xid:{}"+transId);
        }
        log.info("bank1 try end 结束执行...xid:{}",transId);
    }

    @Transactional
    public void commit(String accountNo, Double amount){
        //获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank1 confirm begin 开始执行...xid:{},accountNo:{},amount:{}",transId,accountNo,amount);
    }



    @Transactional
    public void rollback(String accountNo, Double amount){
        //获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank1 cancel begin 开始执行...xid:{}",transId);
        //	cancel幂等校验
        if(localCancelLogDao.existsByTxNo(transId)){
            log.info("bank1 cancel 已经执行，无需重复执行,xid:{}",transId);
            return ;
        }
        //cancel空回滚处理，如果try没有执行，cancel不允许执行
        if(localTryLogDao.existsByTxNo(transId)==false){
            log.info("bank1 空回滚处理，try没有执行，不允许cancel执行,xid:{}",transId);
            return ;
        }
        //	增加可用余额
        accountInfoDao.addAccountBalance(accountNo,amount);
        //插入一条cancel的执行记录
        LocalCancelLog localCancelLog = new LocalCancelLog();
        localCancelLog.setTxNo(transId);
        localCancelLog.setCreateTime(new Date());
        localCancelLogDao.save(localCancelLog);
        log.info("bank1 cancel end 结束执行...xid:{}",transId);
    }

}