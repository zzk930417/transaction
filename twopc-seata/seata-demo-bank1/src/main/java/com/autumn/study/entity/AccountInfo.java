/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.entity
 * 文件名: AccountInfo
 * 日期: 2020/7/5 14:35
 * 说明:
 */
package com.autumn.study.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Anbang713
 * @create 2020/7/5
 */
@Data
@Entity
@Table(name = "account_info")
public class AccountInfo implements Serializable {

    @Id
    private Long id;
    private String accountName;
    private String accountNo;
    private Double accountBalance;
}