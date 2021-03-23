/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.controller
 * 文件名: Bank1Controller
 * 日期: 2020/7/5 15:01
 * 说明:
 */
package com.autumn.study.controller;

import com.autumn.study.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Anbang713
 * @create 2020/7/5
 */
@RestController
public class Bank1Controller {

    @Autowired
    AccountInfoService accountInfoService;

    @GetMapping("/transfer")
    public String transfer(Double amount){
        accountInfoService.updateAccountBalance("1", amount);
        return "bank1："+amount;
    }
}