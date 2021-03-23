/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.dao
 * 文件名: LocalTryLogDao
 * 日期: 2020/7/5 21:06
 * 说明:
 */
package com.autumn.study.dao;

import com.autumn.study.entity.LocalTryLog;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anbang713
 * @create 2020/7/5
 */
public interface LocalTryLogDao extends CrudRepository<LocalTryLog, String> {

    boolean existsByTxNo(String txNo);
}