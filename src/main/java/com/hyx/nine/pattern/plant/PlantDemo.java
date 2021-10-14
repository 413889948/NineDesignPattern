package com.hyx.nine.pattern.plant;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author hyx
 */
@Service
public class PlantDemo {
    public ReturnDemo getReturn(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        if (StringUtils.equals(str, "ONE")) {
            return new ReturnDemoOne();
        } else if (StringUtils.equals(str, "TWO")) {
            return new ReturnDemoTwo();
        }
        return null;
    }
}
