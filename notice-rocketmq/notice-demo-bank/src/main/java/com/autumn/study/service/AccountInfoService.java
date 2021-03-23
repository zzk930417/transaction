/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service
 * 文件名: AccountInfoService
 * 日期: 2020/7/9 22:03
 * 说明:
 */
package com.autumn.study.service;

import com.autumn.study.entity.AccountPay;
import com.autumn.study.model.AccountChangeEvent;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
public interface AccountInfoService {

    //更新账户金额
    void updateAccountBalance(AccountChangeEvent accountChange);

    //查询充值结果（远程调用）
    AccountPay queryPayResult(String tx_no);
}