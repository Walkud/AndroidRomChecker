# Android Rom 识别库

## 使用说明


```
//读取当前手机ROM
Rom rom = RomIdentifier.getRom();
//打印Rom信息
Log.d("AndroidRomChecker", "Rom：" + rom.toString());

```


## Rom适配
已适配Rom在cc包下都会存在对应的Checker识别器。

```
public enum Rom {
	//目前已适配
    MIUI("xiaomi"), // 小米
    Flyme("meizu"), // 魅族
    EMUI("huawei"), // 华为
    ColorOS("oppo"), // OPPO
    FuntouchOS("vivo"), // vivo
    SmartisanOS("smartisan"), // 锤子
    AmigoOS("amigo"), // 金立
    EUI("letv"), // 乐视

    //未适配
    Sense(""), // HTC
    _360OS(""), // 奇酷360
    NubiaUI(""), // 努比亚
    H2OS(""), // 一加
    YunOS(""), // 阿里巴巴
    YuLong("yulong"), // 酷派
    SamSung("samsung"), // 三星
    Sony("sony"), // 索尼
    Lenovo("lenovo"), // 联想
    LG("lg"), // LG
    ZTE("zte"),//中兴
    Google(""), // 原生
    Other(""); // 其它
    ……
}

```

###### **PS：未适配Rom可自行参照已实现的Cheker进行适配**

```
//获取默认识别器
List<Checker> checkers = RomIdentifier.getRom.getChecker();
//checkers.add();//添加自定义识别器
//读取当前手机ROM
Rom rom = RomIdentifier.getRom(checkers);

```

## 原理

原理比较简单，请自行阅读源码。


##参考

[SenhLinsh/Android-ROM-Identifier](https://github.com/SenhLinsh/Android-ROM-Identifier)
