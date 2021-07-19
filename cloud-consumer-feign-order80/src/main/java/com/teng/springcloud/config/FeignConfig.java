package com.teng.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @create 2021-07-03 14:47
 */
//@Configuration
public class FeignConfig {
    //@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
