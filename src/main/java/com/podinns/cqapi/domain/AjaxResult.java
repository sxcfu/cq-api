package com.podinns.cqapi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;

/**
 * Project Name:${project_name}
 *
 * @Author : Lib
 * @Date: ${date}-${time}
 * @Description Copyright (c) ${year}, libao@podinns.com All Rights Reserved.
 */
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MESSAGE_TAG = "msg";

    public static final String DATA_TAG = "data";


    /**
     * 状态类型
     */
    public enum Type {
        /**
         * 成功
         */
        SUCCESS(200),
        /**
         * 系统错误
         */
        ERROR(500),
        /**
         * token过期
         */
        EXPIRED(401),
        /**
         * 404
         */
        NOFOUND(404),
        /**
         * 警告
         */
        WARN(301);
        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    /**
     * 状态类型
     */
    private Type type;

    /**
     * 状态码
     */
    private int code;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回内容
     */
    private String msg;

    /**
     * 数据对象
     */
    private Object data;

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type    状态类型
     * @param message 返回内容
     */
    public AjaxResult(Type type, String message) {
        super.put(CODE_TAG, type.value);
        super.put(MESSAGE_TAG, message);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param type    状态类型
     * @param message 返回内容
     * @param data    数据对象
     */
    public AjaxResult(Type type, String message, Object data) {
        super.put(CODE_TAG, type.value);
        super.put(MESSAGE_TAG, message);
        this.msg = message;
        this.type =type;
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static AjaxResult success(Object data) {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param message 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String message) {
        return AjaxResult.success(message, null);
    }

    /**
     * 返回成功消息
     *
     * @param message 返回内容
     * @param data    数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String message, Object data) {
        return new AjaxResult(Type.SUCCESS, message, data);
    }

    /**
     * 返回警告消息
     *
     * @param message 返回内容
     * @return 警告消息
     */
    public static AjaxResult warn(String message) {
        return AjaxResult.warn(message, null);
    }

    /**
     * 返回警告消息
     *
     * @param message 返回内容
     * @param data    数据对象
     * @return 警告消息
     */
    public static AjaxResult warn(String message, Object data) {
        return new AjaxResult(Type.WARN, message, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param message 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(String message) {
        return AjaxResult.error(message, "");
    }

    /**
     * 返回错误消息
     *
     * @param message 返回内容
     * @param data    数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String message, Object data) {
        return new AjaxResult(Type.ERROR, message, data);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AjaxResult noFound(String msg) {
        return new AjaxResult(Type.NOFOUND, msg);
    }

    /**
     * 返回错误消息
     *
     * @return 警告消息
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("code", getCode())
                .append("message", getMsg())
                .append("data", getData())
                .toString();
    }
}
