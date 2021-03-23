/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service
 * 文件名: AccountInfoService
 * 日期: 2020/7/5 15:02
 * 说明:
 */
package com.autumn.study.service;

import com.autumn.study.model.AccountChangeEvent;

/**
 *
 * @author Anbang713
 * @create 2020/7/5
 */
public interface AccountInfoService {

    void sendUpdateAccountBalance(AccountChangeEvent accountChangeEvent);

    void doUpdateAccountBalance(AccountChangeEvent accountChangeEvent);
}