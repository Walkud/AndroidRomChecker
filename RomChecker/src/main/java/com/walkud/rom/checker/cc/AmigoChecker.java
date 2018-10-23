package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 金立Amigo ROM
 * Created by Zhuliya on 2018/10/23
 */
public class AmigoChecker extends Checker {

    public static final String AMIGO_DISPLAY_ID = "ro.build.display.id";

    @Override
    public Rom getRom() {
        return Rom.AmigoOS;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = romProperties.getProperty(AMIGO_DISPLAY_ID);
        if (!TextUtils.isEmpty(versionName)) {
            Rom.AmigoOS.setVersionName(versionName);
            try {
                Matcher matcher = Pattern.compile("amigo([\\d.]+)[a-zA-Z]*").matcher(versionName); //"amigo3.5.1"
                if (matcher.find()) {
                    String version = matcher.group(1);
                    Rom.AmigoOS.setVersion(version);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
