package com.esteel.user.service.request.admin;

import com.esteel.common.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @version 1.0.0
 * @ClassName AddUserRequest.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  16:03
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class AddUserRequest  extends BaseRequest {


    /**用户名*/
    private String userName ;

    /**登录密码*/
    private String password ;

    /**手机号码*/
    private String mobile ;

    /**来源：0-网站、1-iPhone、2-Android、3-微信、4-H5、5-管理平台、6-小程序*/
    private Integer source ;

    /**IP地址*/
    private String ip ;
}
