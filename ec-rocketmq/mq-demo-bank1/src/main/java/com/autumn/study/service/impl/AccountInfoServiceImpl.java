/**
 * 版权所有 (C), 2019-2020, XXX有限公司
 * 项目名：com.autumn.study.service.impl
 * 文件名: AccountInfoServiceImpl
 * 日期: 2020/7/5 15:02
 * 说明:
 */
package com.autumn.study.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.autumn.study.dao.AccountInfoDao;
import com.autumn.study.dao.DeDuplicationDao;
import com.autumn.study.entity.DeDuplication;
import com.autumn.study.model.AccountChangeEvent;
import com.autumn.study.service.AccountInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Anbang713
 * @create 2020/7/5
 */
@Service
@Slf4j
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    private AccountInfoDao accountInfoDao;
    @Autowired
    private DeDuplicationDao deDuplicationDao;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    //向mq发送转账消息
    @Override
    public void sendUpdateAccountBalance(AccountChangeEvent accountChangeEvent) {
        //将accountChangeEvent转成json
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("accountChange",accountChangeEvent);
        String jsonString = jsonObject.toJSONString();
        //生成message类型
        Message<String> message = MessageBuilder.withPayload(jsonString).build();
        //发送一条事务消息
        rocketMQTemplate.sendMessageInTransaction("producer_group_txmsg_bank1","topic_txmsg", message,null);
    }

    //更新账户，扣减金额
    @Override
    @Transactional
    public void doUpdateAccountBalance(AccountChangeEvent accountChangeEvent) {
        //幂等判断
        if(deDuplicationDao.existsByTxNo(accountChangeEvent.getTxNo())){
            return ;
        }
        //扣减金额
        accountInfoDao.updateAccountBalance(accountChangeEvent.getAccountNo(),accountChangeEvent.getAmount() * -1);
        //添加事务日志
        DeDuplication deDuplication = new DeDuplication();
        deDuplication.setTxNo(accountChangeEvent.getTxNo());
        deDuplication.setCreateTime(new Date());
        deDuplicationDao.save(deDuplication);
        if(accountChangeEvent.getAmount() == 3){
            throw new RuntimeException("人为制造异常");
        }
    }
}