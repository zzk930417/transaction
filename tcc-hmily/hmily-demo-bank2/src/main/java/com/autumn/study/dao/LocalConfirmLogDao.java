package com.autumn.study.dao;

import com.autumn.study.entity.LocalConfirmLog;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Anbang713
 * @create 2020/7/5
 */
public interface LocalConfirmLogDao  extends CrudRepository<LocalConfirmLog, String> {

    boolean existsByTxNo(String txNo);
}
