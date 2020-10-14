package com.esteel.user.service.request.admin;

import com.esteel.common.dubbo.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @version 1.0.0
 * @ClassName UserRequest.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  15:59
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class UserRequest extends PageRequest {

    /**姓名查询*/
    private String userName ;

    /**号码查询*/
    private String phone ;

    /**邮箱查询*/
    private String email ;

    private Long userId ;
}
