/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.spring
 * 文件名: Bank2Client
 * 日期: 2020/7/5 15:03
 * 说明:
 */
package com.autumn.study.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Anbang713
 * @create 2020/7/5
 */
@FeignClient(value="seata-demo-bank2",fallback=Bank2ClientFallback.class)
public interface Bank2Client {
    //远程调用李四的微服务
    @GetMapping("/bank2/transfer")
    String transfer(@RequestParam("amount") Double amount);
}
