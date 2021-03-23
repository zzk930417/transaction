/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service.impl
 * 文件名: AccountInfoServiceImpl
 * 日期: 2020/7/9 22:04
 * 说明:
 */
package com.autumn.study.service.impl;

import com.autumn.study.dao.AccountInfoDao;
import com.autumn.study.dao.DeDuplicationDao;
import com.autumn.study.entity.AccountPay;
import com.autumn.study.entity.DeDuplication;
import com.autumn.study.model.AccountChangeEvent;
import com.autumn.study.service.AccountInfoService;
import com.autumn.study.spring.PayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    private AccountInfoDao accountInfoDao;
    @Autowired
    private PayClient payClient;
    @Autowired
    private DeDuplicationDao deDuplicationDao;

    //更新账户金额
    @Override
    @Transactional
    public void updateAccountBalance(AccountChangeEvent accountChange) {
        //幂等校验
        if(deDuplicationDao.existsByTxNo(accountChange.getTxNo())){
            return ;
        }
        int i = accountInfoDao.updateAccountBalance(accountChange.getAccountNo(), accountChange.getAmount());
        //插入事务记录，用于幂等控制
        DeDuplication deDuplication = new DeDuplication();
        deDuplication.setTxNo(accountChange.getTxNo());
        deDuplication.setCreateTime(new Date());
        deDuplicationDao.save(deDuplication);
    }

    //远程调用查询充值结果
    @Override
    public AccountPay queryPayResult(String tx_no) {
        //远程调用
        AccountPay payresult = payClient.payresult(tx_no);
        if("success".equals(payresult.getResult())){
            //更新账户金额
            AccountChangeEvent accountChangeEvent = new AccountChangeEvent();
            accountChangeEvent.setAccountNo(payresult.getAccountNo());//账号
            accountChangeEvent.setAmount(payresult.getPayAmount());//金额
            accountChangeEvent.setTxNo(payresult.getId());//充值事务号
            updateAccountBalance(accountChangeEvent);
        }
        return payresult;
    }
}