package com.esteel.user.service.response.admin;

import com.esteel.common.dubbo.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * @version 1.0.0
 * @ClassName UserResponse.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  15:57
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class UserResponse  extends BaseResponse {

    /**用户代码*/
    private Long userId ;

    /**部门代码*/
    private String deptId ;

    /**用户名*/
    private String userName ;

    /**登录密码*/
    private String password ;

    /**微信 unionID*/
    private String unionId ;

    /**微信 openID*/
    private String openId ;

    /**注册时间*/
    private Date registerTime ;

    /**注销时间*/
    private Date retireTime ;

    /**手机号已验证：0-否 1-是*/
    private int mobileVerified ;

    /**邮件地址已验证：0-否 1-是*/
    private int emailVerified ;

    /**来源：0-网站、1-iPhone、2-Android、3-微信、4-H5、5-管理平台、6-小程序*/
    private int source ;

    /**设备号*/
    private String deviceId;

    /**IP地址*/
    private String ip ;

    /**用户浏览器cookie*/
    private String cookie ;

    /**经度*/
    private String geoX ;

    /**纬度*/
    private String geoY ;

    /**审核人*/
    private Long auditor ;

    /**审核日期*/
    private Date auditDate ;

    /**审核时间*/
    private Date auditTime ;

    /**登录IP*/
    private String loginIp;

    /**登录时间*/
    private Date loginTime ;

    /**上次登录时间*/
    private Date lastLoginTime ;

    /**实名*/
    private String realName ;

    /**性别 0-男  1-女*/
    private int sex ;

    /**手机号码*/
    private String mobile ;

    /**手机号码*/
    private String addStarMobile ;

    /**电子邮件*/
    private String email ;

    /**微信账号*/
    private String wechat ;

    /**QQ号码*/
    private String qq ;

    /**微博帐号*/
    private String weibo ;

    /**头像URL*/
    private String iconUrl ;

    /**城市代码*/
    private String cityCode ;

    /**省份*/
    private String province ;

    /**通讯地址*/
    private String address ;

    /**邮编*/
    private String postCode ;

    /**固定电话*/
    private String phone ;

    /**传真*/
    private String fax ;

    /**证件号码*/
    private String idCode ;

    /**证件类型：0-身份证 1-军官证*/
    private String idType ;

    /**生日*/
    private Date birthday ;

    /**姓名修改次数*/
    private int nameModifyNum ;

    /**备注*/
    private String notes ;

    /**创建人*/
    private Long createId ;

    /**创建人名称*/
    private String createName ;

    /**创建时间*/
    private Date createTime ;

    /**修改人*/
    private Long updateId;

    /**修改人姓名*/
    private String updateName ;

    /**状态：0-正常、9-作废*/
    private int status;

    /**修改时间*/
    private Date updateTime;
}
