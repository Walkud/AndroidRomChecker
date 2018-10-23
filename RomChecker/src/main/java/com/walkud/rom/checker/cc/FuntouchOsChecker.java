package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * vivo FuntouchOS ROM
 * Created by Zhuliya on 2018/10/22
 */
public class FuntouchOsChecker extends Checker {

    public static final String FUNTOUCHOS_OS_VERSION = "ro.vivo.os.version"; // "3.1"
    public static final String FUNTOUCHOS_DISPLAY_ID = "ro.vivo.os.build.display.id"; // "FuntouchOS_3.1"

    @Override
    public Rom getRom() {
        return Rom.FuntouchOS;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String version = romProperties.getProperty(FUNTOUCHOS_OS_VERSION);
        if (!TextUtils.isEmpty(version)) {
            String versionName = romProperties.getProperty(FUNTOUCHOS_DISPLAY_ID);
            Rom.FuntouchOS.setVersion(version);
            Rom.FuntouchOS.setVersionName(versionName);
            return true;
        }

        return false;
    }
}
