package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * vivo FuntouchOS ROM
 * Created by Zhuliya on 2018/10/22
 */
public class FuntouchOsChecker extends Checker {

    public static final String FUNTOUCHOS_VERSION_NAME = "ro.vivo.os.build.display.id"; // "FuntouchOS_3.1"

    @Override
    public Rom getRom() {
        return Rom.FuntouchOS;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = romProperties.getProperty(FUNTOUCHOS_VERSION_NAME);
        if (!TextUtils.isEmpty(versionName)) {

            parseVersionCode(versionName);
            getRom().setVersionName(versionName);

            return true;
        }

        return false;
    }
}
