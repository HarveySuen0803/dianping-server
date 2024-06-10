package com.harvey.dianping.service;

import com.harvey.dianping.dto.Result;
import com.harvey.dianping.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IShopService extends IService<Shop> {
    Result queryById(Long id);
    
    Result update(Shop shop);
    
    Result queryShopByType(Integer typeId, Integer curNo, Double x, Double y);
    
}
