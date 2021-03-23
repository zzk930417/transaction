/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.spring
 * 文件名: PayFallback
 * 日期: 2020/7/9 22:05
 * 说明:
 */
package com.autumn.study.spring;

import com.autumn.study.entity.AccountPay;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
@Component
public class PayFallback implements PayClient {
    @Override
    public AccountPay payresult(String txNo) {
        AccountPay accountPay = new AccountPay();
        accountPay.setResult("fail");
        return accountPay;
    }
}