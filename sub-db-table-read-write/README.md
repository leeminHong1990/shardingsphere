

#### 分库分表读写分离

`场景` 在实际开发中，如果表的数据过大我们需要把一个库拆成多个库同时一张表水平拆分成多张表，同时设置每个数据库的从库实现读写分离，这里就是通过ShardingSphere实现`分库分表读写分离`功能。

1. 创建主数据库 test和test88;
2. 配置主从数据库,使得两个主数据库test和test88分别能够同步到两个从数据库中
2. 分别在数据库test和test88中用user.sql语句创建 tab_user0、tab_user1;
3. run application
4. 使用postman post请求提交以下age为奇数user。 由于id是随机生成的可以看到偶数id且age为奇数在test数据库tab_user1中奇数，奇数id且age为奇数在test88数据库tab_user1中，同时从数据库中也同步数据。
```url
https://localhost:28892/users
{
    "age":19,
    "userName":"min",
    "sex":"男"
}
```
5. 修改 post请求的age为偶数提交user。 可以看到偶数id且age为偶数在test数据库tab_user0中奇数，奇数id且age为偶数在test88数据库tab_user0中，同时从数据库中也同步数据。
```url
https://localhost:28892/users
{
    "age":19,
    "userName":"min",
    "sex":"男"
}
```

6. 使用get请求某个user。可以看到从从库中读出的数据。
```url
https://localhost:28892/users/{id}
```

`注意` ShardingSphere并不支持`CASE WHEN`、`HAVING`、`UNION (ALL)`，`有限支持子查询`。这个官网有详细说明。