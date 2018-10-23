package com.walkud.rom.checker.utils;

import android.text.TextUtils;

import java.util.Properties;

/**
 * 系统属性读取相关类
 * Created by Zhuliya on 2018/10/22
 */
public class RomProperties {

    private Properties properties;

    public RomProperties() {
        //加载Android系统属性
        this.properties = SystemPropertyUtil.getProperty();
    }

    /**
     * 获取属性
     *
     * @param key 关键字
     * @param def 默认值
     * @return 属性值
     */
    public String getProperty(String key, String def) {
        String value = properties.getProperty("[" + key + "]", def);

        if (TextUtils.isEmpty(value)) {
            //再读取一次属性
            return SystemPropertyUtil.getSystemProperty(key);
        }

        return value.replace("[", "").replace("]", "");
    }

    /**
     * 获取属性
     *
     * @param key 关键字
     * @return 属性值
     */
    public String getProperty(String key) {
        return getProperty(key, null);
    }
}
