

DROP TABLE IF EXISTS `tab_user`;

CREATE TABLE `tab_user` (
  `id` bigint(32) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_user` bigint(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT NULL COMMENT '是否删除 1删除 0未删除',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- INSERT INTO `tab_user` (`id`, `user_name`, `sex`, `age`,`create_time`, `update_time`, `deleted`, `version`)
-- VALUES
-- 	(1,'爸爸','男',29,'2019-10-08 20:11:43','2019-10-08 20:11:43',0,0);





