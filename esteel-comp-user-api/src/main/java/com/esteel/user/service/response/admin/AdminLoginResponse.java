package com.esteel.user.service.response.admin;

import com.esteel.common.dubbo.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminLoginResponse.java
 * @Description 登录
 * @createTime 2020年5月11日 17:10
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class AdminLoginResponse extends BaseResponse {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId ;

    private String userName ;

    private String email ;

}
