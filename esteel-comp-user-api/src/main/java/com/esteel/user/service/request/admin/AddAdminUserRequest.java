package com.esteel.user.service.request.admin;

import com.esteel.common.dubbo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AddAdminUserRequest.java
 * @Description 新增操作员
 * @createTime 2020年5月20日 10:58
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class AddAdminUserRequest extends BaseRequest {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**用户名*/
    @NotNull(message = "账号名不能为空")
    private String userName ;

    /**邮箱*/
    @NotNull(message = "邮箱不能为空")
    private String email ;

    /**密码*/
    private String password = "Aa123456";

    /**0:初审 1：终审 2：主管*/
    @NotNull(message = "角色Id")
    private List<Integer> types  ;

    /**分配数*/
    private Integer num = 50 ;

    /**操作员*/
    private Long operatorId ;
}
