package com.harvey.dianping.service;

import com.harvey.dianping.dto.Result;
import com.harvey.dianping.entity.VoucherOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IVoucherOrderService extends IService<VoucherOrder> {
    Result seckillVoucher(Long voucherId);
    
    Result createVoucherOrder(Long voucherId);
    
    void createVoucherOrder(VoucherOrder voucherOrder);
}
