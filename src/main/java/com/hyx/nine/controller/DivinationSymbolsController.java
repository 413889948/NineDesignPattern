package com.hyx.nine.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: huangyx
 * @Date: 2021/7/22 10:14
 *
 */
@Controller
@Api(tags = "测试的类")
public class DivinationSymbolsController {
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("测试接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "test", value = "测试参数", defaultValue = "测试"),
    }
    )
    public String go2Index(@RequestBody String string) {

        return "index";
    }

}
