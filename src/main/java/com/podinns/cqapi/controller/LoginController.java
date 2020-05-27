package com.podinns.cqapi.controller;

import com.podinns.cqapi.common.JwtUtils;
import com.podinns.cqapi.config.AppConfig;
import com.podinns.cqapi.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AppConfig appConfig;

    @RequestMapping("/getToken")
    public AjaxResult selectHotelBases(String appId, String appSecret) {
        if (appId != null) {
            appConfig.getAppId();
        }
        if (appSecret != null) {
            appConfig.getAppId();
        }
        if (appId.equals(appConfig.getAppId()) && appSecret.equals(appConfig.getAppSecret())) {
            String tocken = JwtUtils.sign(appId, appSecret);
            return AjaxResult.success("登录成功", tocken);
        }
        return AjaxResult.error("用户名或密码有误");
    }
}