package com.walkud.rom.checker.cc;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

import java.lang.reflect.Method;

public class HarmonyOsChecker extends Checker {
    
    @Override
    public Rom getRom() {
        return Rom.HarmonyOS;
    }
    
    @Override
    public boolean checkBuildProp(RomProperties romProperties) {
        String versionName = getHarmonyVersion();
        
        if (isHarmonyOS()) {
            parseVersionCode(versionName);
            getRom().setVersionName(versionName);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * 校验是否是鸿蒙系统
     *
     * @return true-鸿蒙系统
     */
    public static boolean isHarmonyOS() {
        try {
            Class clz = Class.forName("com.huawei.system.BuildEx");
            Method method = clz.getMethod("getOsBrand");
            return "harmony".equals(method.invoke(clz));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * 获取鸿蒙 ROM 的版本
     * @return 版本
     */
    public static String getHarmonyVersion() {
        try {
            Class clz = Class.forName("ohos.system.version.SystemVersion");
            Method method = clz.getMethod("getVersion");
            return (String) method.invoke(clz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unknown";
    }
    
}
