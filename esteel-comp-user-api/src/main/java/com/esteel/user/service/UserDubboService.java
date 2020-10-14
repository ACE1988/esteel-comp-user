package com.esteel.user.service;

import com.esteel.common.dto.PaginationSupport;
import com.esteel.common.dubbo.DubboResponse;
import com.esteel.user.service.request.admin.AddUserRequest;
import com.esteel.user.service.request.admin.LoginUserRequest;
import com.esteel.user.service.request.admin.UserRequest;
import com.esteel.user.service.response.admin.UserResponse;

/**
 * @version 1.0.0
 * @ClassName UserDubboService.java
 * @author: liu Jie
 * @Description: 平台会员DUBBO
 * @createTime: 2020年-10月-12日  15:56
 */
public interface UserDubboService {

    String DUBBO_VERSION = "1.0.0";

    /**
     * 平台会员查询
     * @param request
     * @return
     */
    DubboResponse<PaginationSupport<UserResponse>> queryUser(UserRequest request) ;

    /**
     * 添加用户
     * @param request
     * @return
     */
    DubboResponse<UserResponse> addUser(AddUserRequest request);

    /**
     * 用户登录
     * @param request
     * @return
     */
    DubboResponse<UserResponse> userLogin(LoginUserRequest request);

    /**
     * 根据用户ID查询
     * @param request
     * @return
     */
    DubboResponse<UserResponse> queryUserByUserId(UserRequest request);
}
