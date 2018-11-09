package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * 乐视EUI ROM
 * Created by Zhuliya on 2018/10/23
 */
public class EuiChecker extends Checker {

    public static final String EUI_VERSION_NAME = "ro.letv.release.version"; // "5.9.023S"

    @Override
    public Rom getRom() {
        return Rom.EUI;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = romProperties.getProperty(EUI_VERSION_NAME);

        if (!TextUtils.isEmpty(versionName)) {

            parseVersionCode(versionName);
            getRom().setVersionName(versionName);

            return true;
        }

        return false;
    }
}
