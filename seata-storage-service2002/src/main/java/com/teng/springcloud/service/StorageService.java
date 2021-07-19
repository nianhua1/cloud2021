package com.teng.springcloud.service;

/**
 * @author
 * @create 2021-07-18 21:45
 */
public interface StorageService {
    /**
     * 扣减库存
     */

    public void decrease(Long productId, Integer count);
}
