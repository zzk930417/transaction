# 分布式事务专题演示工程

# 1. 项目介绍
本项目是[《学习分布式事务，这里没有废话》](https://mp.weixin.qq.com/s/pzK_Vd7QwEu7oIRPWKrNrw)系列专题的案例实战，分布式事务主要是解决：
* 跨JVM进程产生的事务问题
* 跨数据库实例产生的事务问题
* 多服务访问同一个数据库实例产生的事务问题

当前主流的解决方案有2PC、TCC、可靠消息最终一致性、最大努力通知四个解决方案。针对四个解决方案，大家在学习理论的同时，也可根据案例实战源码更加深刻的各个解决分布式事务的手段。

# 2. 代码结构

```
distributed-transaction-study
├── ec-rocketmq -- 基于rocketmq实现可靠消息最终一致性
├── notice-rocketmq -- 基于rocketmq实现最大努力通知
├── tcc-hmily -- 基于hmily组件实现tcc
├── twopc-seata -- 基于seata组件实现2pc
```

# 3. 其它说明

如果你觉得作者写得还不错，还请star一下给点精神支持。同时你还可以关注个人微信公众号获取更多精彩文章。

![人公众](./个人公众号.png)

