package com.teng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author
 * @create 2021-07-02 22:27
 */
@Component
public class MyLB implements MyLoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }

    public final int getAndIncrement(){
        int current;
        int next;

        do{
            current = this.atomicInteger.get();
            next = current>=Integer.MAX_VALUE?0:current+1;

        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next = " + next);
        return next;
    }
}
