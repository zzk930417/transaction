/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study
 * 文件名: RegistryServerApplication
 * 日期: 2020/7/5 14:01
 * 说明:
 */
package com.autumn.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author Anbang713
 * @create 2020/7/5
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryServerApplication.class, args);
    }
}