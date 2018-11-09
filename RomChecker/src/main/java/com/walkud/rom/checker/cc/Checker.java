package com.walkud.rom.checker.cc;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Rom识别抽象类
 * <p>
 * Created by Zhuliya on 2018/10/22
 */
public abstract class Checker {

    /**
     * 获取Rom信息
     *
     * @return
     */
    public abstract Rom getRom();

    /**
     * 检查系统属性
     *
     * @return
     */
    public abstract boolean checkBuildProp(RomProperties romProperties);

    /**
     * 检查手机制造商
     *
     * @return
     */
    public boolean checkManufacturer() {
        return getRom().getManufacturer().equalsIgnoreCase(getRom().getMa());
    }

    /**
     * 解析版本Code
     *
     * @param versionName 版本名称 （例如："7.6.15"）
     */
    protected void parseVersionCode(String versionName) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(versionName);
        if (matcher.find()) {
            try {
                String versionStr = matcher.group(1);
                getRom().setVersionCode(Integer.parseInt(versionStr.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
