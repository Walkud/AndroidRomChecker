package com.walkud.rom.checker.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Android 系统属性读取工具类
 * Created by Zhuliya on 2018/10/22
 */
public class SystemPropertyUtil {

    /**
     * 使用命令方式读取系统属性
     *
     * @param propName
     * @return
     */
    public static String getSystemProperty(String propName) {
        String line;
        BufferedReader input = null;
        try {
            Process p = Runtime.getRuntime().exec("getprop " + propName);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            RLog.e("Unable to read sysprop " + propName, ex);
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    RLog.e("Exception while closing InputStream", e);
                }
            }
        }
        return line;
    }

    /**
     * 读取系统属性，装载至Properties
     *
     * @return
     */
    public static Properties getProperty() {
        Properties properties = new Properties();
        try {
            Process p = Runtime.getRuntime().exec("getprop");
            properties.load(p.getInputStream());
        } catch (Exception e) {
            // Some devices may result in "IllegalArgumentException Invalid Unicode sequence: illegal character"
            e.printStackTrace();
        }
        return properties;
    }
}
