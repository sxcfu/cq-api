package com.podinns.cqapi.interceptor;

import com.podinns.cqapi.common.JwtConstants;
import com.podinns.cqapi.common.JwtUtils;
import com.podinns.cqapi.config.AppConfig;
import com.podinns.cqapi.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Project Name:${project_name}
 *
 * @Author : Lib
 * @Date: ${date}-${time}
 * @Description Copyright (c) ${year}, libao@podinns.com All Rights Reserved.
 */
public class LogcostInterceptor implements HandlerInterceptor {
    private  String appId;
    private  String appSecret;



    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader(JwtConstants.AUTHORIZATION);
        boolean check = JwtUtils.verify(authorization, appId,appSecret);

        if(!check){
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.print(AjaxResult.error("登录超时").toString());
                out.flush();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
        }

        return check;

    }

     @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}

