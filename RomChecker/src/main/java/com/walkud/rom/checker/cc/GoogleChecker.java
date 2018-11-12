package com.walkud.rom.checker.cc;

import android.os.Build;
import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * Google ROM
 * 由于手机有限，暂时使用该方式判断
 * Created by Zhuliya on 2018/11/12
 */
public class GoogleChecker extends Checker {

    private static final String GOOGLE_THEME_ID = "ro.com.google.ime.theme_id";//5
    private static final String GOOGLE_VERSION_NAME = "ro.build.version.release";//7.1.1

    @Override
    public Rom getRom() {
        return Rom.Google;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String themeId = romProperties.getProperty(GOOGLE_THEME_ID);

        if (!TextUtils.isEmpty(themeId)) {
            String versionName = romProperties.getProperty(GOOGLE_VERSION_NAME);

            getRom().setVersionCode(Build.VERSION.SDK_INT);
            getRom().setVersionName(versionName);

        }
        return false;
    }
}
