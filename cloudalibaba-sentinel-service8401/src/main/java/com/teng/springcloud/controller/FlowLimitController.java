package com.teng.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @create 2021-07-17 15:20
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
//        try {
//            Thread.sleep(800);
//        } catch (InterruptedException e) {
//
//        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//
//        }
        log.info(Thread.currentThread().getName()+"\t"+"testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        //暂停几秒钟线程
        /**
         * 测试服务降级RT
         */
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//        log.info("testD 测试RT");
        /**
         * 测试服务降级异常比例
         */
        log.info("测试异常比例  testD");
        int a = 10/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("测试异常数  testE");
        int a = 10/0;
        return "------testE";
    }

    @GetMapping("/testHostKey")
    @SentinelResource(value = "testHostKey",blockHandler = "handler_hostKey")
    public String testHostKey(@RequestParam(value = "p1",required = false)String p1,
                              @RequestParam(value = "p2",required = false)String p2){
        int i = 10/0;
        return "-------testHostKey-----";
    }

    public String handler_hostKey(String p1, String p2, BlockException e){
        return "----------handler_hostKey---------,o(╥﹏╥)o";
    }


}
