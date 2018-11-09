package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * HTC Sense Rom
 * Created by Zhuliya on 2018/11/9
 */
public class SenseChecker extends Checker {

    private static final String KEY_SENSE_BUILD_VERSION = "ro.build.sense.version";//6.0

    @Override
    public Rom getRom() {
        return Rom.Sense;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String buildVersion = romProperties.getProperty(KEY_SENSE_BUILD_VERSION);

        if (!TextUtils.isEmpty(buildVersion)) {

            parseVersionCode(buildVersion);
            getRom().setVersionName(buildVersion);

            return true;
        }

        return false;
    }
}
