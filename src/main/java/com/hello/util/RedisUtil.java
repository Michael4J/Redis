package com.hello.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Properties;

/**
 * @Title: RedisUtil
 * @Auther: MichaelJ
 * @Date: 2018/8/2
 */
public class RedisUtil {

    // 连接池
    private static JedisPool jedisPool = null;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            Properties properties = PropertiesUtil.getProperties("redis.properties");
            config.setMaxTotal(Integer.valueOf(properties.getProperty("redis.maxTotal")));
            config.setMaxIdle(Integer.valueOf(properties.getProperty("redis.maxIdle")));
            config.setMaxWaitMillis(Long.valueOf(properties.getProperty("redis.maxWait")));
            config.setTestOnBorrow(true);   // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
            String host = properties.getProperty("redis.host");
            int port = Integer.valueOf(properties.getProperty("redis.port"));
            int timeout = Integer.valueOf(properties.getProperty("redis.timeout"));
            String password = properties.getProperty("redis.password");
            jedisPool = new JedisPool(config, host, port, timeout, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取jedis实例
     * @return
     */
    public static Jedis getJedis() {

        if (null != jedisPool) {
            return jedisPool.getResource();
        }
        return null;
    }


}
