package com.esteel.user.service.request.admin;

import com.esteel.common.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @version 1.0.0
 * @ClassName AdminUserLoginRequest.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-05月-20日  10:25
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class AdminUserLoginRequest extends BaseRequest {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**邮箱*/
    @NotBlank(message = "登录邮箱不能为空")
    private String email ;

    /**密码*/
    @NotBlank(message = "密码不能为空")
    private String password ;
}
