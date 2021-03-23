/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.dao
 * 文件名: AccountInfoDao
 * 日期: 2020/7/9 22:01
 * 说明:
 */
package com.autumn.study.dao;

import com.autumn.study.entity.AccountInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Anbang713
 * @create 2020/7/9
 */
public interface AccountInfoDao extends Repository<AccountInfo, String> {

    @Modifying
    @Query("update AccountInfo set accountBalance = accountBalance + :amount where accountNo = :accountNo")
    int updateAccountBalance(@Param("accountNo") String accountNo, @Param("amount") Double amount);
}