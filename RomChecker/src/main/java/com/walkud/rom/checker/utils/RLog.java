package com.walkud.rom.checker.utils;

import android.util.Log;

/**
 * 日志类
 * Created by Zhuliya on 2018/10/22
 */
public class RLog {

    public static final String TAG = "ZbjRomChecker";

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void e(String msg, Throwable throwable) {
        Log.e(TAG, msg, throwable);
    }
}
