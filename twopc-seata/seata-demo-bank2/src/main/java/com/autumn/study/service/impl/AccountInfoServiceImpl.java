/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service.impl
 * 文件名: AccountInfoServiceImpl
 * 日期: 2020/7/5 15:06
 * 说明:
 */
package com.autumn.study.service.impl;

import com.autumn.study.dao.AccountInfoDao;
import com.autumn.study.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void updateAccountBalance(String accountNo, Double amount) {
        //李四增加金额
        accountInfoDao.updateAccountBalance(accountNo,amount);
        if(amount == 3) {
            //人为制造异常
            throw new RuntimeException("bank2 make exception..");
        }
    }
}