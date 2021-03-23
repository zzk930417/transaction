/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.spring
 * 文件名: PayClient
 * 日期: 2020/7/9 22:05
 * 说明:
 */
package com.autumn.study.spring;

import com.autumn.study.entity.AccountPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
@FeignClient(value = "notice-demo-pay",fallback = PayFallback.class)
public interface PayClient {

    //远程调用充值系统的接口查询充值结果
    @GetMapping(value = "/pay/payresult/{txNo}")
    AccountPay payresult(@PathVariable("txNo") String txNo);
}