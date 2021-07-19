package com.teng.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @create 2021-07-18 21:38
 */
@Mapper
public interface StorageDao {
    //扣库存
    public void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
