
##### read-write 读写分离

1. 设置主从数据库
2. 在application.yml中修改数据库配置
3. 使用master_user.sql创建数据库语句创建表
4. 使用controller测试读写分离

--- 
> 使用mybatis-plus 配置了 每张表默认的默认创建时间、修改时间、版本、软删除