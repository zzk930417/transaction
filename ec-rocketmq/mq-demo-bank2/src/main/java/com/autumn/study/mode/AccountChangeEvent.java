/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.mode
 * 文件名: AccountChangeEvent
 * 日期: 2020/7/6 21:47
 * 说明:
 */
package com.autumn.study.mode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author Anbang713
 * @create 2020/7/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountChangeEvent implements Serializable {
    /**
     * 账号
     */
    private String accountNo;
    /**
     * 变动金额
     */
    private double amount;
    /**
     * 事务号
     */
    private String txNo;

}