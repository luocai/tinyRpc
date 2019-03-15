# tinyRpc
*** 
# 特性
* 使用netty进行通信
* 借助zookeeper实现服务注册和发现
* 与spring整合，部分bean由spring管理，使用Spring配置服务，加载Bean，扫描注解
* 服务器端异步（channel收到消息交给线程池处理）
* 客户端异步（客户端请求异步处理的支持，不需要同步等待：发送一个异步请求，返回Future，通过Future的callback机制获取结果）
* 支持多种序列化协议（protostuff，hessian，kryo，fastjson 可通过配置指定序列化协议）
* 实现了基于权值的随机负载均衡策略（参考了dubbo的设计，当提供服务的节点有多个的时候，可以通过负载均衡策略选择节点）
# TODO
* 心跳检测，断线重连
* 支持更多的负载均衡策略
