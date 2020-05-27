

#### 分表读写分离

`场景` 在实际开发中，如果表的数据过大我们需要把一一张表水平拆分成多张表，同时设置数据库的从库实现读写分离，这里就是通过ShardingSphere实现`分表读写分离`功能。

1. 创建主数据库 test
2. 配置主从数据库,使得两个主数据库test两个从数据库中
2. 在数据库test中用user.sql语句创建 tab_user0、tab_user1;
3. run application
4. 使用postman post请求提交以下user。 由于id是随机生成的可以看到偶数id在test数据库tab_user0中，奇数id在test数据库tab_user1中，同时从数据库中也同步数据。
```url
https://localhost:28893/users
{
    "age":19,
    "userName":"min",
    "sex":"男"
}
```

5. 使用get请求某个user测试。可以看到负载均衡从某个从库中读出的数据。
```url
https://localhost:28892/users/{id}
```

`注意` ShardingSphere并不支持`CASE WHEN`、`HAVING`、`UNION (ALL)`，`有限支持子查询`。这个官网有详细说明。