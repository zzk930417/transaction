package com.autumn.study.service;

import com.autumn.study.entity.AccountPay;

/**
 * @author Anbang713
 * @create 2020/7/9
 */
public interface AccountPayService {
    //充值
    AccountPay save(AccountPay accountPay);
    //查询充值结果
    AccountPay findById(String txNo);
}
