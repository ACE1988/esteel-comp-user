package com.esteel.user.dubbo.impl;

import com.esteel.common.constant.Constants;
import com.esteel.common.core.ErrorCode;
import com.esteel.common.dto.PaginationSupport;
import com.esteel.common.dubbo.DubboResponse;
import com.esteel.user.common.DESWrapper;
import com.esteel.user.common.ResponseConstant;
import com.esteel.user.common.StringHelpers;
import com.esteel.user.entity.UserEntity;
import com.esteel.user.service.UserDubboService;
import com.esteel.user.service.UserService;
import com.esteel.user.service.request.admin.AddUserRequest;
import com.esteel.user.service.request.admin.LoginUserRequest;
import com.esteel.user.service.request.admin.UserRequest;
import com.esteel.user.service.response.admin.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0.0
 * @ClassName UserDubboServiceImpl.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  16:05
 */
@Slf4j
@Service(version = UserDubboService.DUBBO_VERSION,validation = "true")
public class UserDubboServiceImpl implements UserDubboService {

    @Autowired
    UserService userService ;

    /**
     * 平台会员查询
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<PaginationSupport<UserResponse>> queryUser(UserRequest request) {
        return null;
    }

    /**
     * 添加用户
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<UserResponse> addUser(AddUserRequest request) {

        DubboResponse<UserResponse> response = new DubboResponse<>();
        if(StringUtils.isBlank(request.getUserName())){
            response.setStatus(Constants.System.FAIL);
            response.setMsg(ResponseConstant.REGISTER_NAME_EXIST_MSG);
            response.setError(ResponseConstant.REGISTER_NAME_EXIST);
            return response;
        }

        if(StringUtils.isBlank(request.getMobile())){
            response.setStatus(Constants.System.FAIL);
            response.setMsg(ResponseConstant.REGISTER_PHONE_NOT_NULL_MSG);
            response.setError(ResponseConstant.REGISTER_PHONE_NOT_NULL);
            return response;
        }

        //检查手机格式是否正确


        //检查密码长度
        if(request.getPassword().trim().length() <= 6){
            response.setStatus(Constants.System.FAIL);
            response.setMsg(ResponseConstant.REGISTER_PASSWORD_FORMAT_MSG);
            response.setError(ResponseConstant.REGISTER_PASSWORD_FORMAT);
            return response;
        }

        String password = DESWrapper.encrypt(request.getPassword());
        String mobile = DESWrapper.encrypt(request.getMobile());

        //手机号码加密查询
        UserEntity userEntity = userService.queryUserByMobile(mobile);
        if(userEntity != null && userEntity.getMobile().equals(mobile)){
            response.setStatus(Constants.System.FAIL);
            response.setMsg(ResponseConstant.REGISTER_PHONE_EXIST_MSG);
            response.setError(ResponseConstant.REGISTER_PHONE_EXIST);
            return response;
        }

        userService.addUser(request.getUserName(),
                DESWrapper.encrypt(request.getMobile()),
                StringHelpers.getStarString2(request.getMobile(),3,4),
                request.getIp(),
                request.getSource(),
                password);

        userEntity = userService.queryUserByMobile(mobile);
        UserResponse result = new UserResponse();
        //属性
        BeanUtils.copyProperties(userEntity,result);
        return DubboResponse.success(result);
    }


    /**
     * 用户登录
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<UserResponse> userLogin(LoginUserRequest request) {
        log.info("【用户登录】  mobile={},password={}",request.getMobile(),request.getPassword());
        String mobile= DESWrapper.encrypt(request.getMobile());
        String password = DESWrapper.encrypt(request.getPassword());
        UserEntity userEntity  = userService.queryUserByMobile(mobile);
        if(userEntity != null && userEntity.getPassword().equals(password)){
            UserResponse response = new UserResponse() ;
            BeanUtils.copyProperties(userEntity,response);
            return DubboResponse.success(response);
        }
        return DubboResponse.fail(ErrorCode.ApiError.PARAMETER_VALIDATION_ERROR);
    }

    /**
     * 根据用户ID查询
     *
     * @param request
     * @return
     */
    @Override
    public DubboResponse<UserResponse> queryUserByUserId(UserRequest request) {
        log.info("【用户信息查询】  userId={}",request.getUserId());
        UserEntity userEntity =  userService.queryUserByUserId(request.getUserId());
        if(userEntity != null){
            UserResponse response = new UserResponse() ;
            BeanUtils.copyProperties(userEntity,response);
            return DubboResponse.success(response);
        }
        return DubboResponse.fail(ErrorCode.ApiError.PARAMETER_VALIDATION_ERROR);
    }
}
