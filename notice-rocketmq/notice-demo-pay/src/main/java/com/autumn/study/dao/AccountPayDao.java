/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.dao
 * 文件名: AccountPayDao
 * 日期: 2020/7/9 21:50
 * 说明:
 */
package com.autumn.study.dao;

import com.autumn.study.entity.AccountPay;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
public interface AccountPayDao extends CrudRepository<AccountPay,String> {

}