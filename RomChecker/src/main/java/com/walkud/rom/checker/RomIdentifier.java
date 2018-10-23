package com.walkud.rom.checker;

import com.walkud.rom.checker.cc.AmigoChecker;
import com.walkud.rom.checker.cc.Checker;
import com.walkud.rom.checker.cc.ColorOsChecker;
import com.walkud.rom.checker.cc.EmuiChecker;
import com.walkud.rom.checker.cc.EuiChecker;
import com.walkud.rom.checker.cc.FlymeChecker;
import com.walkud.rom.checker.cc.FuntouchOsChecker;
import com.walkud.rom.checker.cc.MiuiChecker;
import com.walkud.rom.checker.cc.SmartisanChecker;
import com.walkud.rom.checker.utils.RomProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Rom 识别入口类
 * <p>
 * 识别逻辑：
 * 第一步：检查所有Checker系统属性是否与当前手机匹配，匹配则返回对应Rom，否则执行第二步。
 * 第二步：检查所有Checker手机制造商是否与当前手机匹配，匹配则返回对应Rom
 * <p>
 * <p>
 * Created by Zhuliya on 2018/10/22
 */
public final class RomIdentifier {

    private static volatile Rom rom;//已识别的Rom

    private RomIdentifier() {
    }

    /**
     * 获取默认识别器
     *
     * @return
     */
    public static List<Checker> getChecker() {
        return Arrays.asList(
                new MiuiChecker(),
                new EmuiChecker(),
                new ColorOsChecker(),
                new FuntouchOsChecker(),
                new SmartisanChecker(),
                new FlymeChecker(),
                new AmigoChecker(),
                new EuiChecker()
        );
    }

    /**
     * 获取当前手机Rom
     * 使用默认识别器
     *
     * @return
     */
    public static Rom getRom() {
        return getRom(null);
    }

    /**
     * 获取当前手机Rom（单例）
     *
     * @param checkers 自定义识别器
     * @return
     */
    public static Rom getRom(List<Checker> checkers) {
        if (rom == null) {
            synchronized (RomIdentifier.class) {
                if (rom == null) {
                    rom = getRomType(checkers);
                }
            }
        }
        return rom;
    }

    /**
     * 获取当前手机Rom
     *
     * @return
     */
    private static Rom getRomType(List<Checker> checkers) {

        if (checkers == null) {
            checkers = getChecker();
        }

        RomProperties romProperties = new RomProperties();

        //检查所有Checker系统属性是否与当前手机匹配，匹配则返回对应Rom，否则执行第二步。
        for (Checker checker : checkers) {
            if (checker.checkBuildProp(romProperties)) {
                return checker.getRom();
            }
        }

        //第二步，检查所有Checker手机制造商是否与当前手机匹配，匹配则返回对应Rom
        for (Checker checker : checkers) {
            if (checker.checkManufacturer()) {
                return checker.getRom();
            }
        }

        return Rom.Other;
    }
}
