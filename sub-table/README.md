

#### 同一数据库分表

`场景` 在实际开发中，如果表的数据过大我们需要把一张表拆分成多张表，这里就是通过ShardingSphere实现`分表`功能。

1. 创建数据库 test2;
2. 分别在数据库中用user.sql语句创建 tab_user0、tab_user1;
3. run application
4. 使用postman post请求提交user。 由于id是随机生成的可以看到根据id奇偶分表。
```url
https://localhost:28889/users
{
    "age":19,
    "userName":"min",
    "sex":"男"
}
```

`注意` ShardingSphere并不支持`CASE WHEN`、`HAVING`、`UNION (ALL)`，`有限支持子查询`。这个官网有详细说明。