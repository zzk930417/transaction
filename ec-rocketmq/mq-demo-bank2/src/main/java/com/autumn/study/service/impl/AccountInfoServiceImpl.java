/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service.impl
 * 文件名: AccountInfoServiceImpl
 * 日期: 2020/7/5 15:06
 * 说明:
 */
package com.autumn.study.service.impl;

import com.autumn.study.dao.AccountInfoDao;
import com.autumn.study.dao.DeDuplicationDao;
import com.autumn.study.entity.DeDuplication;
import com.autumn.study.mode.AccountChangeEvent;
import com.autumn.study.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
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
    AccountInfoDao accountInfoDao;
    @Autowired
    DeDuplicationDao deDuplicationDao;

    //更新账户，增加金额
    @Override
    @Transactional
    public void addAccountInfoBalance(AccountChangeEvent accountChangeEvent) {
        log.info("bank2更新本地账号，账号：{},金额：{}",accountChangeEvent.getAccountNo(),accountChangeEvent.getAmount());
        if(deDuplicationDao.existsByTxNo(accountChangeEvent.getTxNo())){
            return ;
        }
        //增加金额
        accountInfoDao.updateAccountBalance(accountChangeEvent.getAccountNo(),accountChangeEvent.getAmount());
        //添加事务记录，用于幂等
        DeDuplication deDuplication = new DeDuplication();
        deDuplication.setTxNo(accountChangeEvent.getTxNo());
        deDuplication.setCreateTime(new Date());
        deDuplicationDao.save(deDuplication);
        if(accountChangeEvent.getAmount() == 2){
            throw new RuntimeException("人为制造异常");
        }
    }
}