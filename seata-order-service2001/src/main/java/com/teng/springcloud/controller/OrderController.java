package com.teng.springcloud.controller;

import com.teng.springcloud.domain.CommonResult;
import com.teng.springcloud.domain.Order;
import com.teng.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author
 * @create 2021-07-18 21:00
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"订单创建成功");
    }

    @GetMapping("/test/create")
    public CommonResult test(){
        return new CommonResult(200,"测试成功！");
    }
}
