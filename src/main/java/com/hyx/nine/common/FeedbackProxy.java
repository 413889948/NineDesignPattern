package com.hyx.nine.common;

import com.hyx.nine.utils.LogUtil;

import org.springframework.stereotype.Component;

/**
 * @Author: huangyx
 * @Date: 2021/10/20 15:54
 * 代理模式-用户反馈类
 */
@Component
public class FeedbackProxy {

    public String feedback(String str,String over){
        LogUtil.info("进行反馈，内容："+str);
        LogUtil.info("完成反馈参数，内容："+over);
        return over;
    }

}
