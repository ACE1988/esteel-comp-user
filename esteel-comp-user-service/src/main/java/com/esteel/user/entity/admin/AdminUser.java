package com.esteel.user.entity.admin;

import com.esteel.user.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminUser.java
 * @Description TODO
 * @createTime 2020年5月20日 10:09
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class AdminUser extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**用户名*/
    private String userName ;

    /**邮箱*/
    private String email ;

    /**密码*/
    private String password ;

    /**账号类型  0:初审 1：终审 2：主管*/
    private String types ;

    /**分配数*/
    private Integer num ;

    /**0：分配 1：禁止分配*/
    private Integer autoStatus ;

    /**1:男 ，2：女 ， 0：保密*/
    private Integer sex ;

    /**最近一次登录时间*/
    private Date loginTime ;
}
