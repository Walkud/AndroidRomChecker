package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 小米MIUI ROM
 * Created by Zhuliya on 2018/10/22
 */
public class MiuiChecker extends Checker {

    public static final String MIUI_VERSION_NAME = "ro.build.version.incremental"; // "7.6.15"
    public static final String MIUI_VERSION = "ro.miui.ui.version.name"; // "V8"

    /**
     * 获取Rom信息
     *
     * @return
     */
    @Override
    public Rom getRom() {
        return Rom.MIUI;
    }

    /**
     * 检查系统属性
     *
     * @param romProperties
     * @return
     */
    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String version = romProperties.getProperty(MIUI_VERSION);

        if (!TextUtils.isEmpty(version)) {

            String versionName = romProperties.getProperty(MIUI_VERSION_NAME);

            parseVersionCode(versionName);
            getRom().setVersionName(versionName);

            return true;
        }

        return false;
    }


}
