package com.harvey.dianping.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.harvey.dianping.dto.Result;
import com.harvey.dianping.dto.UserDTO;
import com.harvey.dianping.service.IBlogService;
import com.harvey.dianping.service.IUserService;
import com.harvey.dianping.utils.SystemConstants;
import com.harvey.dianping.entity.Blog;
import com.harvey.dianping.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private IBlogService blogService;
    @Resource
    private IUserService userService;

    @PostMapping
    public Result saveBlog(@RequestBody Blog blog) {
        return blogService.saveBlog(blog);
    }

    @PutMapping("/like/{id}")
    public Result likeBlog(@PathVariable("id") Long id) {
        return blogService.likeBlog(id);
    }

    @GetMapping("/of/me")
    public Result queryMyBlog(@RequestParam(value = "current", defaultValue = "1") Integer current) {
        // 获取登录用户
        UserDTO user = UserHolder.getUser();
        // 根据用户查询
        Page<Blog> page = blogService.query()
                .eq("user_id", user.getId()).page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
        // 获取当前页数据
        List<Blog> records = page.getRecords();
        return Result.ok(records);
    }

    @GetMapping("/hot")
    public Result queryHotBlog(@RequestParam(value = "current", defaultValue = "1") Integer current) {
        return blogService.queryHotBlog(current);
    }
    
    @GetMapping("/{id}")
    public Result queryBlogById(@PathVariable("id") Long id) {
        return blogService.queryBlogById(id);
    }
    
    @GetMapping("/likes/{id}")
    public Result queryBlogLikedList(@PathVariable("id") Long id) {
        return blogService.queryBlogLikedList(id);
    }
    
    @GetMapping("/of/user")
    public Result queryBlogByUserId(
        @RequestParam(value = "current", defaultValue = "1") Integer current,
        @RequestParam("id") Long id) {
        // 根据用户查询
        Page<Blog> page = blogService.query()
                                     .eq("user_id", id).page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
        // 获取当前页数据
        List<Blog> records = page.getRecords();
        return Result.ok(records);
    }
    
    @GetMapping("/of/follow")
    public Result queryBlogOfFollow(@RequestParam("max") Long maxTime, @RequestParam(value = "offset", defaultValue = "0") Integer offset) {
        log.debug("Query blog of follow: {}, {}", maxTime, offset);
        return blogService.queryBlogOfFollow(maxTime, offset);
    }
}