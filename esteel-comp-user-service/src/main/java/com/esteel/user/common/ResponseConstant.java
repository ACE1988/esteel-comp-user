package com.esteel.user.common;

/**
 * @version 1.0.0
 * @ClassName ResponseConstant.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  18:15
 */
public class ResponseConstant {

    public static final String REGISTER_NAME_EXIST = "1000011";
    public static final String REGISTER_NAME_EXIST_MSG = "注册用户名不能为空";

    public static final String REGISTER_PHONE_NOT_NULL = "1000012";
    public static final String REGISTER_PHONE_NOT_NULL_MSG = "注册用手机号不能为空";

    public static final String REGISTER_PHONE_EXIST = "1000013";
    public static final String REGISTER_PHONE_EXIST_MSG = "该电话号码已注册";

    public static final String REGISTER_PASSWORD_FORMAT = "1000014";
    public static final String REGISTER_PASSWORD_FORMAT_MSG = "密码格式错误";
}
