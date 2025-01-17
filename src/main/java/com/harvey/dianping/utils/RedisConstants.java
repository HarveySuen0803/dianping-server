package com.harvey.dianping.utils;

public class RedisConstants {
    public static final String LOGIN_CODE_KEY = "login:code:";
    public static final Long LOGIN_CODE_TTL = 2L;
    public static final String LOGIN_USER_KEY = "login:token:";
    public static final Long LOGIN_USER_TTL = 36000L;

    public static final Long CACHE_NULL_TTL = 2L;

    public static final String CACHE_SHOP_KEY = "cache:shop:";
    public static final Long CACHE_SHOP_TTL = 30L;
    public static final String CACHE_SHOP_TYPE_LIST_KEY = "cache:shop_type_list:";
    public static final Long CACHE_SHOP_TYPE_LIST_TTL = 30L;
    public static final String CACHE_CUSTOMER_KEY = "cache:customer:";
    public static final Long CACHE_CUSTOMER_TTL = 30L;
    
    public static final String LOCK_VOUCHER_KEY = "lock:voucher";
    public static final Long LOCK_VOUCHER_TTL = 10L;
    
    public static final String LOCK_ORDER_KEY = "lock:order:";
    
    public static final String LOCK_SHOP_KEY = "lock:shop:";
    public static final Long LOCK_SHOP_TTL = 10L;

    public static final String SECKILL_STOCK_KEY = "seckill:stock:";
    public static final String BLOG_LIKED_KEY = "blog:liked:";
    public static final String FEED_KEY = "feed:";
    public static final String SHOP_GEO_KEY = "shop:geo:";
    public static final String USER_SIGN_KEY = "user:sign:";
    public static final String FOLLOWS_KEY = "follows:";
}
