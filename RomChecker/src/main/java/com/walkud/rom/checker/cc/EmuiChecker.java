package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * 华为EMUI ROM
 * Created by Zhuliya on 2018/10/23
 */
public class EmuiChecker extends Checker {

    private static final String EMUI_VERSION_NAME = "ro.build.version.emui"; // "EmotionUI_4.0.2"

    @Override
    public Rom getRom() {
        return Rom.EMUI;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = romProperties.getProperty(EMUI_VERSION_NAME);

        if (!TextUtils.isEmpty(versionName)) {

            parseVersionCode(versionName);
            getRom().setVersionName(versionName);

            return true;
        }

        return false;
    }
}
