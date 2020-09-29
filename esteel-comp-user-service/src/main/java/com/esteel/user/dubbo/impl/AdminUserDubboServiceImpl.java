package com.esteel.user.dubbo.impl;

import com.alibaba.fastjson.JSONObject;
import com.esteel.user.common.Md5;
import com.esteel.user.entity.admin.AdminUser;
import com.esteel.user.service.AdminUserDubboService;
import com.esteel.user.service.AdminUserService;
import com.esteel.user.service.request.admin.AddAdminUserRequest;
import com.esteel.user.service.request.admin.AdminUserLoginRequest;
import com.esteel.user.service.request.admin.AdminUserRequest;
import com.esteel.user.service.response.admin.AdminLoginResponse;
import com.esteel.user.service.response.admin.AdminUserResponse;
import com.esteel.common.core.ErrorCode;
import com.esteel.common.dubbo.DubboResponse;
import com.esteel.common.dubbo.PageResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminUserDubboServiceImpl.java
 * @Description 用户管理
 * @createTime 2020年5月20日 11:55
 */
@Service(version = AdminUserDubboService.DUBBO_VERSION, validation = "true")
public class AdminUserDubboServiceImpl implements AdminUserDubboService {


    Logger logger = LoggerFactory.getLogger(AdminUserDubboServiceImpl.class);

    @Autowired
    AdminUserService adminUserService ;

    /**
     * 新增操作员
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public DubboResponse<Boolean> addAdminUser(AddAdminUserRequest request) {

      return DubboResponse.success(Boolean.TRUE);
    }

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<PageResponse<AdminUserResponse>> queryAdminUser(AdminUserRequest request) {
        if(StringUtils.isNotBlank(request.getEmail())){
            request.setEmail(request.getEmail().toLowerCase());
        }
        int pageStart = (request.getStartItem() != null ? request.getStartItem() : 0);
        int pageSize = (request.getPageSize() != null ? request.getPageSize() : 10);
        if(request.getAutoStatus() == null ){
            request.setAutoStatus(1);
        }
        int count = adminUserService.queryAdminUserCount(request.getUserName(),request.getEmail(),request.getStatus(),request.getAutoStatus());
        List<AdminUser> list = adminUserService.queryAdminUserList(request.getUserName(),request.getEmail(),request.getStatus(),pageStart,pageSize,request.getAutoStatus());
        List<AdminUserResponse> responses = list.stream().map(x -> {
                AdminUserResponse response = new AdminUserResponse();
                response.setEmail(x.getEmail());
                response.setAutoStatus(x.getAutoStatus());
                response.setId(x.getId());
                response.setNum(x.getNum());
                response.setPassword(x.getPassword());
                response.setStatus(x.getStatus());
                response.setUserName(x.getUserName());
                return response ;
            }).collect(Collectors.toList());
        logger.info("【操作员管理】 列表查询 request={}", JSONObject.toJSON(request));
        return DubboResponse.success(PageResponse.data(pageStart,pageSize,count,responses));
    }

    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<AdminLoginResponse> adminUserLogin(AdminUserLoginRequest request) {
        logger.info("【调用外部接口：用户】 用户登录 email={},password={}",request.getEmail(),request.getPassword());

        AdminUser adminUser  = adminUserService.queryAdminUserByEmail(request.getEmail());
        System.out.println(Md5.getMd5(request.getPassword()));
        if(adminUser != null && adminUser.getPassword().contains(Md5.getMd5(request.getPassword()))){
            AdminUserResponse response = new AdminUserResponse() ;
            AdminLoginResponse loginResponse = new AdminLoginResponse();
            loginResponse.setEmail(adminUser.getEmail());
            loginResponse.setUserId(adminUser.getId());
            loginResponse.setUserName(adminUser.getUserName());
            return DubboResponse.success(loginResponse);
        }
        return DubboResponse.fail(ErrorCode.ApiError.DENIED_BY_RULE);
    }
}
