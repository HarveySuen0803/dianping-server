package com.harvey.dianping.service.impl;

import com.harvey.dianping.entity.UserInfo;
import com.harvey.dianping.mapper.UserInfoMapper;
import com.harvey.dianping.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-24
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
