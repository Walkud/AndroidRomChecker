package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * 华为EMUI ROM
 * Created by Zhuliya on 2018/10/23
 */
public class EmuiChecker extends Checker {

    private static final String EMUI_VERSION = "ro.build.version.emui"; // "EmotionUI_4.0.2"
    private static final String EMUI_API_LEVEL = "ro.build.hw_emui_api_level"; //9

    @Override
    public Rom getRom() {
        return Rom.EMUI;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = romProperties.getProperty(EMUI_VERSION);
        if (!TextUtils.isEmpty(versionName)) {
            String version = romProperties.getProperty(EMUI_API_LEVEL);
            Rom.EMUI.setVersionName(versionName);
            Rom.EMUI.setVersion(version);
            return true;
        }

        return false;
    }
}
