package com.esteel.user.service;

import com.esteel.common.dto.PaginationSupport;
import com.esteel.common.dubbo.DubboResponse;
import com.esteel.common.dubbo.PageResponse;
import com.esteel.user.service.request.admin.AddAdminUserRequest;
import com.esteel.user.service.request.admin.AdminUserLoginRequest;
import com.esteel.user.service.request.admin.AdminUserRequest;
import com.esteel.user.service.response.admin.AdminLoginResponse;
import com.esteel.user.service.response.admin.AdminUserResponse;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminUserDubboService.java
 * @Description 操作员管理
 * @createTime 2020年5月20日 11:01
 */
public interface AdminUserDubboService {

    String DUBBO_VERSION="1.0.0";

    /**
     * 新增操作员
     * @param request
     * @return
     */
    DubboResponse<Boolean> addAdminUser(AddAdminUserRequest request);

    /**
     * 操作员列表
     * @param request
     * @return
     */
    DubboResponse<PageResponse<AdminUserResponse>> queryAdminUser(AdminUserRequest request);


    /**
     * 操作员列表
     * @param request
     * @return
     */
    DubboResponse<PaginationSupport<AdminUserResponse>> queryAdminUserV2(AdminUserRequest request);

    /**
     * 用户登录
     * @param request
     * @return
     */
    DubboResponse<AdminLoginResponse> adminUserLogin(AdminUserLoginRequest request);
}
