package com.esteel.user.service;

import com.esteel.user.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 1.0.0
 * @ClassName UserService.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  16:07
 */
public interface UserService {

    /**
     * 查询注册用户列表
     * @param userName 注册名
     * @param realName 实名查询
     * @param mobile 电话号码
     * @param landlinePhone 座机号码
     * @param email 邮箱
     * @param status 状态
     * @param pageNo  页码
     * @param pageSize  每页条数
     * @return 注册用户列表
     */
    List<UserEntity> queryUserList(String userName,
                                   String realName,
                                   String mobile,
                                   String landlinePhone,
                                   String email,
                                   Integer status,
                                   Integer pageNo,
                                   Integer pageSize);


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
    int queryUserCount(String userName,
                       String realName,
                       String mobile,
                       String landlinePhone,
                       String email,
                       Integer status);


    /**
     * 用户注册
     * @param userName 用户名
     * @param mobile 手机号码
     * @param password 密码
     * @param ip ip地址
     * @param source 注册来源
     * @return 返回注册信息
     */
    UserEntity registerUser(String userName,
                            String mobile,
                            String password,
                            String ip,
                            Integer source );

    /**
     * 根据电话号码查询
     * @param mobile
     * @return
     */
    UserEntity queryUserByMobile (String mobile);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    UserEntity queryUserByUserName(String userName);

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    UserEntity queryUserByUserId (Long userId);


    /**
     * 根据userId查询
     * @param userId 用户ID
     * @param status 状态：0-正常、9-作废
     * @return
     */
    UserEntity queryUserByUserIdAndStatus (Long userId,Integer status);

    /**
     * 新增用户
     * @param userName 昵称
     * @param mobile 手机号码
     * @param addStarMobile 加星手机号码
     * @param ip 注册IP地址
     * @param source 注册来源
     * @param password 密码
     * @return
     */
    boolean addUser(String userName,
                String mobile,
                String addStarMobile,
                String ip,
                Integer source,
                String password);
}
