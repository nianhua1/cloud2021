package com.teng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author
 * @create 2021-07-02 22:26
 */
public interface MyLoadBalancer {
    ServiceInstance instances(List<ServiceInstance> instances);
}
