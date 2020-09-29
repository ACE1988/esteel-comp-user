package com.esteel.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName BaseEntity.java
 * @Description TODO
 * @createTime 2020年5月09日 18:02
 */
@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id ;

    private Integer status ;

    private Date createTime ;

    private Date updateTime ;

}
