package com.hello.util;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件工具类
 * @Title: PropertiesUtil
 * @Auther: MichaelJ
 * @Date: 2018/8/2
 */
public class PropertiesUtil {

    private static final Logger logger = Logger.getLogger(PropertiesUtil.class);

    /**
     * 读取配置文件
     * @param fileNamePath 配置文件
     * @return
     */
    public static Properties getProperties(String fileNamePath) {

        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileNamePath);
            properties.load(in);
            return properties;
        } catch (FileNotFoundException e) {
            logger.error(fileNamePath + " 文件未找到！");
            return null;
        } catch (IOException e) {
            logger.error("IO错误！");
            return null;
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取配置文件属性值
     * @param fileNamePath 配置文件
     * @param key 属性key
     * @return
     */
    public static String getProperty (String fileNamePath, String key) {

        Properties properties = getProperties(fileNamePath);
        if (null != properties) {
            return properties.getProperty(key);
        }
        return null;

    }

    /**
     * 获取配置文件属性值
     * @param fileNamePath 配置文件
     * @param key 属性key
     * @param defaultValue 默认返回值
     * @return
     */
    public static String getProperty (String fileNamePath, String key, String defaultValue) {

        Properties properties = getProperties(fileNamePath);
        if (null != properties) {
            return properties.getProperty(key, defaultValue);
        }
        return null;

    }
}
