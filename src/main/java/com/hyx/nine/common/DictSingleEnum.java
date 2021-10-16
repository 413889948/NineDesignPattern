package com.hyx.nine.common;

import com.hyx.nine.utils.LogUtil;

/**
 * @author hyx
 * @date 2021/10/16 23:59
 */
public enum DictSingleEnum {
    /**
     *
     */
    DICT_SINGLE;

    private final StringBuffer dict = new StringBuffer();

    public static DictSingleEnum getDictSingle(String dict) {
        DICT_SINGLE.dict.append(",").append(dict);
        LogUtil.info("字典单例对象获取了字典表：" + dict);
        LogUtil.info("目前加载字典：" + DICT_SINGLE.dict);
        return DICT_SINGLE;
    }

}
