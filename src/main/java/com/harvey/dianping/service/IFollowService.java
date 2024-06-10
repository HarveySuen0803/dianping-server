package com.harvey.dianping.service;

import com.harvey.dianping.dto.Result;
import com.harvey.dianping.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IFollowService extends IService<Follow> {
    
    Result follow(Long followUserId, boolean isFollow);
    
    Result isFollow(Long followUserId);
    
    Result followCommon(Long userId1);
    
}
