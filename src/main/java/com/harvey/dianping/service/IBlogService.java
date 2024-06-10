package com.harvey.dianping.service;

import com.harvey.dianping.dto.Result;
import com.harvey.dianping.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IBlogService extends IService<Blog> {
    
    Result queryHotBlog(Integer current);
    
    Result queryBlogById(Long id);
    
    Result likeBlog(Long id);
    
    Result queryBlogLikedList(Long id);
    
    Result saveBlog(Blog blog);
    
    Result queryBlogOfFollow(Long maxTime, Integer offset);
    
}
