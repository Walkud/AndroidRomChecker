package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * 努比亚 nubiaUI ROM
 * Created by Zhuliya on 2018/10/23
 */
public class NubiaChecker extends Checker {

    public static final String NUBIA_ROM_CODE = "ro.build.nubia.rom.code";

    @Override
    public Rom getRom() {
        return Rom.NubiaUI;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = romProperties.getProperty(NUBIA_ROM_CODE);

        if (!TextUtils.isEmpty(versionName)) {

            parseVersionCode(versionName);
            getRom().setVersionName(versionName);

            return true;
        }

        return false;
    }
}
