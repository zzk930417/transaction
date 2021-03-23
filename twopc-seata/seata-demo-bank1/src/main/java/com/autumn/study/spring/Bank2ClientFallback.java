/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.spring
 * 文件名: Bank2ClientFallback
 * 日期: 2020/7/5 15:04
 * 说明:
 */
package com.autumn.study.spring;

import org.springframework.stereotype.Component;

/**
 *
 * @author Anbang713
 * @create 2020/7/5
 */
@Component
public class Bank2ClientFallback implements Bank2Client {

    @Override
    public String transfer(Double amount) {
        return "fallback";
    }
}