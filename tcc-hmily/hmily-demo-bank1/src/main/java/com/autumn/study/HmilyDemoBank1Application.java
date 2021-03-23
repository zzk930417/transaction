/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study
 * 文件名: SeataDemoBank1Application
 * 日期: 2020/7/5 14:33
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
 * @create 2020/7/5
 */
@SpringBootApplication(scanBasePackages = {"com.autumn.study", "org.dromara.hmily"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.autumn.study.spring"})
public class HmilyDemoBank1Application {

    public static void main(String[] args) {
        SpringApplication.run(HmilyDemoBank1Application.class,args);
    }
}