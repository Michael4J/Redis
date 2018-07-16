package com.hello;

import redis.clients.jedis.Jedis;

/**
 * RedisConn redis连接
 */
public class RedisConn {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.43.128", 6379);
        jedis.set("key", "hello");
        System.out.println(jedis.get("key"));
        jedis.del("key");
        System.out.println(jedis.get("key"));
    }
}
