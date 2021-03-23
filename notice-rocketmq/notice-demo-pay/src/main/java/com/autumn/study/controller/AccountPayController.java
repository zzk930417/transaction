/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.controller
 * 文件名: AccountPayController
 * 日期: 2020/7/9 21:55
 * 说明:
 */
package com.autumn.study.controller;

import com.autumn.study.entity.AccountPay;
import com.autumn.study.service.AccountPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
@RestController
public class AccountPayController {

    @Autowired
    private AccountPayService accountPayService;

    //充值
    @PostMapping(value = "/paydo")
    public AccountPay pay(@RequestBody AccountPay accountPay){
        //生成事务编号
        String txNo = UUID.randomUUID().toString();
        accountPay.setId(txNo);
        accountPay.setResult("success");
        return accountPayService.save(accountPay);
    }

    //查询充值结果
    @GetMapping(value = "/payresult/{txNo}")
    public AccountPay payresult(@PathVariable("txNo") String txNo){
        return accountPayService.findById(txNo);
    }
}