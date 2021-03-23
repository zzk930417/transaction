/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service.impl
 * 文件名: AccountInfoServiceImpl
 * 日期: 2020/7/5 15:06
 * 说明:
 */
package com.autumn.study.service.impl;

import com.autumn.study.dao.AccountInfoDao;
import com.autumn.study.dao.LocalCancelLogDao;
import com.autumn.study.dao.LocalConfirmLogDao;
import com.autumn.study.dao.LocalTryLogDao;
import com.autumn.study.entity.LocalConfirmLog;
import com.autumn.study.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.core.concurrent.threadlocal.HmilyTransactionContextLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *
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

    @Override
    @Hmily(confirmMethod="confirmMethod", cancelMethod="cancelMethod")
    public void updateAccountBalance(String accountNo, Double amount) {
        //获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 try begin 开始执行...xid:{}",transId);
    }

    @Transactional
    public void confirmMethod(String accountNo, Double amount){
        //获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 confirm begin 开始执行...xid:{}",transId);
        if(localConfirmLogDao.existsByTxNo(transId)){
            log.info("bank2 confirm 已经执行，无需重复执行...xid:{}",transId);
            return ;
        }
        //增加金额
        accountInfoDao.updateAccountBalance(accountNo,amount);
        //增加一条confirm日志，用于幂等
        LocalConfirmLog localConfirmLog = new LocalConfirmLog();
        localConfirmLog.setTxNo(transId);
        localConfirmLog.setCreateTime(new Date());
        localConfirmLogDao.save(localConfirmLog);
        log.info("bank2 confirm end 结束执行...xid:{}",transId);
    }

    public void cancelMethod(String accountNo, Double amount){
        //获取全局事务id
        String transId = HmilyTransactionContextLocal.getInstance().get().getTransId();
        log.info("bank2 cancel begin 开始执行...xid:{}",transId);

    }
}