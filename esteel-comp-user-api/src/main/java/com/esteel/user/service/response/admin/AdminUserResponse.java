package com.esteel.user.service.response.admin;

import com.esteel.common.dubbo.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminUserResponse.java
 * @Description TODO
 * @createTime 2020年5月20日 11:07
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class AdminUserResponse extends BaseResponse {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**主键id*/
    private Long id ;

    /**账号名*/
    private String userName ;

    /**邮箱*/
    private String email ;

    /**密码*/
    private String password ;

    /** 账号类型  0:初审 1：终审 2：主管*/
    private List<Integer> types ;

    /** 1:启用 0：禁用*/
    private Integer status ;

    private Date createTime ;

    private Date updateTime ;

    /**1 ：可分配 0：禁止分配*/
    private Integer autoStatus ;

    /**每日分配数*/
    private Integer num ;
}
