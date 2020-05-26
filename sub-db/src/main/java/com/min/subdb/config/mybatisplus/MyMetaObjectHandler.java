package com.min.subdb.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author min
 * 需加上Component交由Spring管理
 * 注意这种方式只会在使用Mybatis-plus封装好的方法时才会有 效，使用自己定义的service并不会生效，这是个坑
 */
@Slf4j
@Component
@Primary
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");

        /**
         * 起始版本 3.3.0(推荐使用) 注意：BaseEntity使用LocalDateTime这里也要使用LocalDateTime类型,数据类型要保持一致。
         */
//        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
//        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());


//        /**
//         * 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)
//         */
//        this.fillStrategy(metaObject, "createTime", LocalDateTime.now());
//        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
//
//        /* 上面选其一使用,下面的已过时(注意 strictInsertFill 有多个方法,详细查看源码) */
//        this.setFieldValByName("operator", "Jerry", metaObject);
//        this.setInsertFieldValByName("operator", "Jerry", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        log.info("-------------------------------------");
        /**
         * 起始版本 3.3.0(推荐使用) 注意：BaseEntity使用LocalDateTime这里也要使用LocalDateTime类型,数据类型要保持一致。
         */
//        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        System.out.println((new Date()).getTime());
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());

//        /**
//         * 也可以使用(3.3.0 该方法有bug请升级到之后的版本如`3.3.1.8-SNAPSHOT`)
//         */
//        this.fillStrategy(metaObject, "updateTime", new Date());
//
//        /* 上面选其一使用,下面的已过时(注意 strictUpdateFill 有多个方法,详细查看源码) */
//        this.setFieldValByName("operator", "Tom", metaObject);
//        this.setUpdateFieldValByName("operator", "Tom", metaObject);
    }
}