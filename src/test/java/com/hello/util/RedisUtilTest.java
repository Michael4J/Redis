package com.hello.util;

import org.apache.log4j.Logger;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Title: RedisUtilTest
 * @Auther: MichaelJ
 * @Date: 2018/8/2
 */
public class RedisUtilTest {

    private static final Logger logger = Logger.getLogger(RedisUtilTest.class);

    @Test
    public void getJedisTest() {

        Jedis jedis = RedisUtil.getJedis();
        logger.info(jedis.ping());
    }

}
