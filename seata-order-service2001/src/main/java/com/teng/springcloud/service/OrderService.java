package com.teng.springcloud.service;

import com.teng.springcloud.domain.Order;

/**
 * @author
 * @create 2021-07-18 20:35
 */
public interface OrderService {
    /**
     * 创建订单
     */
    public void createOrder(Order order);

}
