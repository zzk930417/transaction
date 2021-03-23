/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.entity
 * 文件名: AccountPay
 * 日期: 2020/7/9 21:58
 * 说明:
 */
package com.autumn.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Anbang713
 * @create 2020/7/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_pay")
public class AccountPay implements Serializable {


    /**
     * 事务号
     */
    @Id
    private String id;

    /**
     * 账号
     */
    private String accountNo;
    /**
     * 变动金额
     */
    private double payAmount;
    /**
     * 充值结果
     */
    private String result;

}
