package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * 锤子 Smartisan ROM
 * Created by Zhuliya on 2018/10/22
 */
public class SmartisanChecker extends Checker {

    public static final String SMARTISAN_OS_VERSION_NAME = "ro.smartisan.version"; // "4.2.5-201805240052-user-col"

    @Override
    public Rom getRom() {
        return Rom.SmartisanOS;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = romProperties.getProperty(SMARTISAN_OS_VERSION_NAME);

        if (!TextUtils.isEmpty(versionName)) {

            parseVersionCode(versionName);
            getRom().setVersionName(versionName);

            return true;
        }

        return false;
    }
}
