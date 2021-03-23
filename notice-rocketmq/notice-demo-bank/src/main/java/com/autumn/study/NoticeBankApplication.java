/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study
 * 文件名: NoticeBankApplication
 * 日期: 2020/7/9 21:48
 * 说明:
 */
package com.autumn.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.autumn.study.spring"})
public class NoticeBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeBankApplication.class,args);
    }
}