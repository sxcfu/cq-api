package com.podinns.cqapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project Name:${project_name}
 *
 * @Author : Lib
 * @Date: ${date}-${time}
 * @Description Copyright (c) ${year}, libao@podinns.com All Rights Reserved.
 */
@Data
@Component
@ConfigurationProperties(prefix = "cqapi")
public class AppConfig {
    private String appId;
    private String appSecret;
}
