package com.esteel.user.service.request.admin;

import com.esteel.common.dubbo.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminUserRequest.java
 * @Description TODO
 * @createTime 2020年5月20日 11:04
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class AdminUserRequest extends PageRequest {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 账号
     */
    private String userName;

    /**
     * 邮箱
     */
    private String email ;

    /**
     * 1:分配 0：禁用分配
     */
    private Integer autoStatus  = 1 ;

    /**
     * 1:启用 0：禁用
     */
    private Integer status ;

}
