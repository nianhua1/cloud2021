package com.teng.springcloud.service;

import com.teng.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @create 2021-06-29 21:11
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
