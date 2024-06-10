package com.harvey.dianping.utils;

import lombok.Data;

import java.time.LocalDateTime;

// Feat: The class used for logical expiration
@Data
public class RedisData {
    private LocalDateTime expireTime;
    private Object data;
}
