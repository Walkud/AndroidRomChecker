package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * LG lge ROM
 * Created by Zhuliya on 2018/11/12
 */
public class LgeChecker extends Checker {

    private static final String LGE_VERSION_NAME = "sys.lge.lgmdm_version";//6.0.2

    @Override
    public Rom getRom() {
        return Rom.LG;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {

        String versionName = romProperties.getProperty(LGE_VERSION_NAME);

        if (!TextUtils.isEmpty(versionName)) {

            parseVersionCode(versionName);
            getRom().setVersionName(versionName);

            return true;
        }

        return false;
    }
}
