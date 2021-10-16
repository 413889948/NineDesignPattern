package com.hyx.nine.common;

import com.hyx.nine.pattern.single.Starve;
import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/16 23:41
 * 字典表的单例类
 */
public class DictSingle {
    private static final DictSingle DICT_SINGLE = new DictSingle();

    private final StringBuffer dict = new StringBuffer();

    private DictSingle() {
        LogUtil.info("创建了字典单例");
    }

    public static DictSingle getDictSingle(String dict) {
        DICT_SINGLE.dict.append(",").append(dict);
        LogUtil.info("字典单例对象获取了字典表：" + dict);
        LogUtil.info("目前加载字典：" + DICT_SINGLE.dict);
        return DICT_SINGLE;
    }
}
