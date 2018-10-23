package com.walkud.rom.checker.cc;

import android.text.TextUtils;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 魅族Flyme ROM
 * Created by Zhuliya on 2018/10/23
 */
public class FlymeChecker extends Checker {

    private static final String FLYME_PUBLISHED = "ro.flyme.published"; // "true"
    private static final String FLYME_SETUP_WIZARD = "ro.meizu.setupwizard.flyme"; // "true"
    private static final String FLYME_BUILD_DISPLAY_ID = "ro.build.display.id";//Flyme 6.0.1.0A

    @Override
    public Rom getRom() {
        return Rom.Flyme;
    }

    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String published = romProperties.getProperty(FLYME_PUBLISHED);
        String flymeSetupWizard = romProperties.getProperty(FLYME_SETUP_WIZARD);
        if (!TextUtils.isEmpty(published) || !TextUtils.isEmpty(flymeSetupWizard)) {
            String versionName = romProperties.getProperty(FLYME_BUILD_DISPLAY_ID);
            Rom.Flyme.setVersionName(versionName);
            try {
                //截取版本
                Matcher matcher = Pattern.compile("Flyme [^\\d]*([\\d.]+)[^\\d]*").matcher(versionName);
                if (matcher.find()) {
                    String version = matcher.group(1);
                    Rom.Flyme.setVersion(version);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
