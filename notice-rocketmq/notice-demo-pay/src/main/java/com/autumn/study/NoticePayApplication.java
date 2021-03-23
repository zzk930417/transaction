/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study
 * 文件名: NoticePayApplication
 * 日期: 2020/7/9 21:49
 * 说明:
 */
package com.autumn.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NoticePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticePayApplication.class,args);
    }
}