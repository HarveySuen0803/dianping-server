package com.harvey.dianping;

import com.harvey.dianping.entity.Shop;
import com.harvey.dianping.utils.RedisIdWorker;
import com.harvey.dianping.service.impl.CustomerServiceImpl;
import com.harvey.dianping.service.impl.ShopServiceImpl;
import com.harvey.dianping.utils.CacheUtils;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.harvey.dianping.utils.RedisConstants.SHOP_GEO_KEY;

@SpringBootTest
class DianPingApplicationTest {
    @Autowired
    ShopServiceImpl shopService;
    @Autowired
    CacheUtils cacheUtils;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    RedisIdWorker redisIdWorker;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    
    private ExecutorService es = Executors.newFixedThreadPool(500);
    
    @Test
    void test() {
    }
    
    @Autowired
    RedissonClient redissonClient;
    
    // Feat: Import the geographic coordinates of shops by Redis
    @Test
    void importGeo() throws InterruptedException {
        Map<Long, List<Shop>> shopMap = shopService.list().stream().collect(Collectors.groupingBy(Shop::getTypeId));
        for (Map.Entry<Long, List<Shop>> entry : shopMap.entrySet()) {
            Long typeId = entry.getKey();
            String key = SHOP_GEO_KEY + typeId;
            List<Shop> shopList = entry.getValue();
            
            // for (Shop shop : shopList) {
            //     stringRedisTemplate.opsForGeo().add(key, new Point(shop.getX(), shop.getY()), shop.getId().toString());
            // }
            
            // Map<String, Point> showPointMap = new HashMap<>();
            // for (Shop shop : shopList) {
            //     showPointMap.put(shop.getId().toString(), new Point(shop.getX(), shop.getY()));
            // }
            // stringRedisTemplate.opsForGeo().add(key, showPointMap);
            
            List<RedisGeoCommands.GeoLocation<String>> locationList = new ArrayList<>(shopList.size());
            for (Shop shop : shopList) {
                locationList.add(new RedisGeoCommands.GeoLocation<>(shop.getId().toString(), new Point(shop.getX(), shop.getY())));
            }
            stringRedisTemplate.opsForGeo().add(key, locationList);
        }
    }
    
    @Test
    public void show() {
        int num = 16265;
        System.out.println(Integer.toBinaryString(num));
    }
}
