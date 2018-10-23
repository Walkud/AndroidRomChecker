package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * OPPO ColorOs ROM
 * Created by Zhuliya on 2018/10/22
 */
public class ColorOsChecker extends Checker {

    public static final String COLOROS_ROM_VERSION = "ro.build.version.opporom"; // "V5.0"
    public static final String COLOROS_ROM_VERSION_NAME = "ro.build.version.ota"; // "PACM00_11.A.19_0190_201806231212"

    @Override
    public Rom getRom() {
        return Rom.ColorOS;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String version = romProperties.getProperty(COLOROS_ROM_VERSION);

        if (!TextUtils.isEmpty(version)) {
            String versionName = romProperties.getProperty(COLOROS_ROM_VERSION_NAME);
            Rom.ColorOS.setVersion(version);
            Rom.ColorOS.setVersionName(versionName);
            return true;
        }

        return false;
    }
}
