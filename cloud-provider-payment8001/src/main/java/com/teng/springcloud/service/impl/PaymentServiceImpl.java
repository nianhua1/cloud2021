package com.teng.springcloud.service.impl;

import com.teng.springcloud.dao.PaymentDao;
import com.teng.springcloud.entities.Payment;
import com.teng.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @create 2021-06-29 21:12
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
       return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
