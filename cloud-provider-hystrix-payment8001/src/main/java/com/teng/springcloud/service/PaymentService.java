package com.teng.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author
 * @create 2021-07-03 15:21
 */
public interface PaymentService {
    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(@PathVariable("id") Integer id);

}
