package com.esteel.user.service.impl;

import com.esteel.user.dao.UserManager;
import com.esteel.user.entity.UserEntity;
import com.esteel.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  16:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserManager userManager ;

    /**
     * 查询注册用户列表
     * @param userName 注册名
     * @param realName 实名查询
     * @param mobile 电话号码 (加密)
     * @param landlinePhone 座机号码
     * @param email 邮箱
     * @param status 状态
     * @param pageNo   页码
     * @param pageSize 每页条数
     * @return 注册用户列表
     */
    @Override
    public List<UserEntity> queryUserList(String userName,
                                          String realName,
                                          String mobile,
                                          String landlinePhone,
                                          String email,
                                          Integer status,
                                          Integer pageNo,
                                          Integer pageSize) {

        return userManager.queryUserList(userName,
                                        realName,
                                        mobile,
                                        landlinePhone,
                                        email,
                                        status,
                                        pageNo,
                                        pageSize);
    }

    /**
     * 查询注册用户条数
     * @param userName 注册名
     * @param realName 实名查询
     * @param mobile 电话号码
     * @param landlinePhone 座机号码
     * @param email 邮箱
     * @param status 状态
     * @return 注册用户列表条数
     */
    @Override
    public int queryUserCount(String userName,
                              String realName,
                              String mobile,
                              String landlinePhone,
                              String email,
                              Integer status) {
        return userManager.queryUserCount(userName,realName,mobile,landlinePhone,email,status);
    }

    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param mobile   手机号码
     * @param password 密码
     * @param ip       ip地址
     * @param source   注册来源
     * @return 返回注册信息
     */
    @Override
    public UserEntity registerUser(String userName, String mobile, String password, String ip, Integer source) {
        return null;
    }

    /**
     * 根据电话号码查询
     *
     * @param mobile
     * @return
     */
    @Override
    public UserEntity queryUserByMobile(String mobile) {
        return userManager.queryByMobile(mobile);
    }

    /**
     * 根据用户名查询
     *
     * @param userName
     * @return
     */
    @Override
    public UserEntity queryUserByUserName(String userName) {
        return userManager.queryByUserName(userName);
    }

    /**
     * 根据userId查询
     *
     * @param userId
     * @return
     */
    @Override
    public UserEntity queryUserByUserId(Long userId) {
        return userManager.queryUserByUserIdAndStatus(userId,0);
    }

    /**
     * 根据userId查询
     *
     * @param userId 用户ID
     * @param status 状态：0-正常、9-作废
     * @return
     */
    @Override
    public UserEntity queryUserByUserIdAndStatus(Long userId, Integer status) {
        return userManager.queryUserByUserIdAndStatus(userId,status);
    }

    /**
     * 新增用户
     *
     * @param userName      昵称
     * @param mobile        手机号码
     * @param addStarMobile 加星手机号码
     * @param ip            注册IP地址
     * @param source        注册来源
     * @param password      密码
     * @return
     */
    @Override
    public boolean addUser(String userName,
                           String mobile,
                           String addStarMobile,
                           String ip,
                           Integer source,
                           String password) {
        return userManager.addUser(userName,mobile,addStarMobile,ip,source,password) ==1;
    }
}
