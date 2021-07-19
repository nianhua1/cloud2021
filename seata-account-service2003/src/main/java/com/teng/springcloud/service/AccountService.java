package com.teng.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author
 * @create 2021-07-18 22:02
 */
public interface AccountService {
    //扣减余额
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    public void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
