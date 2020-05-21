package com.min.readwrite.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.min.readwrite.config.component.MyMetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author min
 */
@Slf4j
@Configuration
public class AppConfig {

    @Autowired
    MyMetaObjectHandler myMetaObjectHandler;

    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(myMetaObjectHandler);
        return globalConfig;
    }
}
