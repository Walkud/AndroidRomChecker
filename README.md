# Android Rom 识别库

![JCenter](https://img.shields.io/badge/JCenter-1.0.0-blue.svg) ![Licence](https://img.shields.io/badge/Licence-Apache-brightgreen.svg) ![MinSDK](https://img.shields.io/badge/MinSDK-4%2B-red.svg)


## 效果图
小米 MIX 3 Android 9.0

<img src="./material/app_gif.gif" width="30%">

## 使用说明

```
//添加依赖
implementation 'com.walkud.rom.checker:RomChecker:1.0.0'

```


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
    Sense("sense"), // HTC

    //未适配
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

##### 未适配Rom可自行参照已实现的Cheker进行适配

```
//获取默认识别器
List<Checker> checkers = RomIdentifier.getRom.getChecker();
//checkers.add();//添加自定义识别器
//读取当前手机ROM
Rom rom = RomIdentifier.getRom(checkers);

```

###### **PS：后续会持续添加未适配Rom的识别器。**

## 原理

原理比较简单，请自行阅读源码。


## 参考

[SenhLinsh/Android-ROM-Identifier](https://github.com/SenhLinsh/Android-ROM-Identifier)


## License

```
Copyright [2018] [Walkud]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
