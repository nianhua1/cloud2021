package com.teng.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.teng.springcloud.entities.CommonResult;

/**
 * @author
 * @create 2021-07-18 11:55
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(444,"自定义的限流处理信息......CustomerBlockHandler---1");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(444,"自定义的限流处理信息......CustomerBlockHandler---2");
    }
}
