package com.teng.springcloud.service.impl;

import com.teng.springcloud.dao.OrderDao;
import com.teng.springcloud.domain.Order;
import com.teng.springcloud.service.AccountService;
import com.teng.springcloud.service.OrderService;
import com.teng.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @create 2021-07-18 20:37
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void createOrder(Order order) {

        /**
         * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
         * 简单说：
         * 下订单->减库存->减余额->改状态
         */

        log.info("======>>开始新建订单");
        orderDao.createOrder(order);

        log.info("======>>订单微服务开始调用库存，做库存Count扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("======>>订单微服务开始调用库存，做库存Count扣减结束");

        log.info("======>>订单微服务开始调用账号，做余额money扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("======>>订单微服务开始调用账号，做余额money扣减结束");

        log.info("======>>修改订单状态");
        orderDao.updateOrderState(order.getUserId(),0);
        log.info("======>>修改订单状态结束");

        log.info("======>>新建订单结束");

    }
}
