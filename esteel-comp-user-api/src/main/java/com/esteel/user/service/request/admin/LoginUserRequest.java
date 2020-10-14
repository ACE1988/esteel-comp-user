package com.esteel.user.service.request.admin;

import com.esteel.common.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @version 1.0.0
 * @ClassName LoginUserRequest.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  17:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class LoginUserRequest  extends BaseRequest {

    /**手机号码*/
    @NotNull(message = "手机号码不能为空")
    private String mobile ;

    /**密码*/
    @NotNull(message = "密码不能为空")
    private String password;
}
