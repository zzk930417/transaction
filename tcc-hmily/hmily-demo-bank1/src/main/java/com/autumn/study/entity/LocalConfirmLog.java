/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.entity
 * 文件名: LocalConfirmLog
 * 日期: 2020/7/5 21:04
 * 说明:
 */
package com.autumn.study.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Anbang713
 * @create 2020/7/5
 */
@Data
@Entity
@Table(name = "local_confirm_log")
public class LocalConfirmLog  implements Serializable {

    @Id
    private String txNo;
    private Date createTime;
}