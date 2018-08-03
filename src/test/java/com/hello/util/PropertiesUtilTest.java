package com.hello.util;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Properties;

/**
 * @Title: PropertiesUtilTest
 * @Auther: MichaelJ
 * @Date: 2018/8/2
 */
public class PropertiesUtilTest {

    private static final Logger logger = Logger.getLogger(PropertiesUtil.class);

    @Test
    public void getPropertiesTest() {
        Properties properties = PropertiesUtil.getProperties("redis.properties");
        logger.info(properties.getProperty("redis.host"));
        logger.debug(properties.getProperty("redis.port"));
    }
}
