/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study
 * 文件名: SeataDemoBank2Application
 * 日期: 2020/7/5 14:39
 * 说明:
 */
package com.autumn.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author Anbang713
 * @create 2020/7/5
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MqDemoBank2Application {

    public static void main(String[] args) {
        SpringApplication.run(MqDemoBank2Application.class,args);
    }
}