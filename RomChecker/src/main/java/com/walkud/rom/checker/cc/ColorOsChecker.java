package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * OPPO ColorOs ROM
 * Created by Zhuliya on 2018/10/22
 */
public class ColorOsChecker extends Checker {

    public static final String COLOROS_ROM_VERSION_NAME = "ro.build.version.opporom"; // "V5.0"

    @Override
    public Rom getRom() {
        return Rom.ColorOS;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = romProperties.getProperty(COLOROS_ROM_VERSION_NAME);

        if (!TextUtils.isEmpty(versionName)) {

            parseVersionCode(versionName);
            getRom().setVersionName(versionName);

            return true;
        }

        return false;
    }
}
