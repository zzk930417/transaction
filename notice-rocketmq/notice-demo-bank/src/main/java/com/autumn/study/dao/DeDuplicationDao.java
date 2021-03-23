package com.autumn.study.dao;

import com.autumn.study.entity.DeDuplication;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Anbang713
 * @create 2020/7/9
 */
public interface DeDuplicationDao extends CrudRepository<DeDuplication,String> {
    boolean existsByTxNo(String txNo);
}
