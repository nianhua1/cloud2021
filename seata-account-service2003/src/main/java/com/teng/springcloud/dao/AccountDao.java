package com.teng.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author
 * @create 2021-07-18 21:58
 */
@Mapper
public interface AccountDao {
    /**
     * 扣减余额
     */
    public void decrease(@Param("userId")Long userId,@Param("money") BigDecimal money);
}
