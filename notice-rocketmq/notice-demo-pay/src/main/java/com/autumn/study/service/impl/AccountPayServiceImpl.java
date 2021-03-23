/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service.impl
 * 文件名: AccountPayServiceImpl
 * 日期: 2020/7/9 21:53
 * 说明:
 */
package com.autumn.study.service.impl;

import com.autumn.study.dao.AccountPayDao;
import com.autumn.study.entity.AccountPay;
import com.autumn.study.service.AccountPayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
@Service
@Slf4j
public class AccountPayServiceImpl implements AccountPayService {

    @Autowired
    private AccountPayDao accountPayDao;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    //插入充值记录
    @Override
    public AccountPay save(AccountPay accountPay) {
        accountPay = accountPayDao.save(accountPay);
        //发送通知,使用普通消息发送通知
        accountPay.setResult("success");
        rocketMQTemplate.convertAndSend("topic_notifymsg",accountPay);
        return accountPay;
    }

    //查询充值记录，接收通知方调用此方法来查询充值结果
    @Override
    public AccountPay findById(String txNo) {
        Optional<AccountPay> optional =  accountPayDao.findById(txNo);
        return optional.isPresent()?optional.get():null;
    }
}