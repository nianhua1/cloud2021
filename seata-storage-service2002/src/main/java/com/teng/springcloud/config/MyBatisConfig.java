package com.teng.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @create 2021-07-18 21:52
 */
@Configuration
@MapperScan({"com.teng.springcloud.dao"})
public class MyBatisConfig {

}
