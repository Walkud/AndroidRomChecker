package com.walkud.rom.checker;

import android.os.Build;

/**
 * Rom枚举
 * Created by Zhuliya on 2018/10/22
 */
public enum Rom {

    //已适配
    MIUI("xiaomi"), // 小米
    Flyme("meizu"), // 魅族
    EMUI("huawei"), // 华为
    ColorOS("oppo"), // OPPO
    FuntouchOS("vivo"), // vivo
    SmartisanOS("smartisan"), // 锤子
    AmigoOS("amigo"), // 金立
    EUI("letv"), // 乐视
    Sense("htc"), // HTC
    LG("lge"), // LG
    Google("google"), // 原生

    //未适配
    _360OS(""), // 奇酷360
    NubiaUI(""), // 努比亚
    H2OS(""), // 一加
    YunOS(""), // 阿里巴巴
    YuLong("yulong"), // 酷派
    SamSung("samsung"), // 三星
    Sony("sony"), // 索尼
    Lenovo("lenovo"), // 联想
    ZTE("zte"),//中兴

    Other(""); // CyanogenMod, Lewa OS, 百度云OS, Tencent OS, 深度OS, IUNI OS, Tapas OS, Mokee

    private String ma;//Rom制造商
    private int versionCode;//版本Code
    private String versionName;//版本名称
    private String manufacturer = Build.MANUFACTURER;//当前手机制造商

    Rom(String ma) {
        this.ma = ma;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Override
    public String toString() {
        return "ROM{" +
                "name='" + this.name() + '\'' +
                ",versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ",ma=" + ma + '\'' +
                ",manufacturer=" + manufacturer + '\'' +
                '}';
    }
}
