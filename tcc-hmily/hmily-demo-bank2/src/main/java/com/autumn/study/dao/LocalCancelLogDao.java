package com.autumn.study.dao;

import com.autumn.study.entity.LocalCancelLog;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Anbang713
 * @create 2020/7/5
 */
public interface LocalCancelLogDao  extends CrudRepository<LocalCancelLog, String> {

    boolean existsByTxNo(String txNo);
}
