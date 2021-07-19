package com.teng.springcloud.dao;

import com.teng.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @create 2021-07-18 20:27
 */
@Mapper
public interface OrderDao {
    public void createOrder(Order order);

    public void updateOrderState(@Param("userId") Long userId,@Param("status") Integer status);
}
