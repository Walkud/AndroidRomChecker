package com.walkud.rom.checker.cc;

import com.walkud.rom.checker.Rom;
import com.walkud.rom.checker.utils.RomProperties;

/**
 * Rom识别抽象类
 * <p>
 * Created by Zhuliya on 2018/10/22
 */
public abstract class Checker {

    /**
     * 获取Rom信息
     *
     * @return
     */
    public abstract Rom getRom();

    /**
     * 检查系统属性
     *
     * @return
     */
    public abstract boolean checkBuildProp(RomProperties romProperties);

    /**
     * 检查手机制造商
     *
     * @return
     */
    public boolean checkManufacturer() {
        return getRom().getManufacturer().equalsIgnoreCase(getRom().getMa());
    }

}
