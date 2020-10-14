package com.esteel.user.dao;

import com.esteel.user.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 1.0.0
 * @ClassName UserManager.java
 * @author: liu Jie
 * @Description: TODO
 * @createTime: 2020年-10月-12日  16:15
 */
public interface UserManager {

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
    List<UserEntity> queryUserList(@Param("userName") String userName,
                                   @Param("realName") String realName,
                                   @Param("mobile") String mobile,
                                   @Param("landlinePhone") String landlinePhone,
                                   @Param("email") String email,
                                   @Param("status") Integer status,
                                   @Param("pageNo") Integer pageNo,
                                   @Param("pageSize") Integer pageSize);



    /**
     * 查询注册用户列表
     * @param userName 注册名
     * @param realName 实名查询
     * @param mobile 电话号码
     * @param landlinePhone 座机号码
     * @param email 邮箱
     * @param status 状态
     * @return 注册用户列表条数
     */
    int queryUserCount(@Param("userName") String userName,
                       @Param("realName") String realName,
                       @Param("mobile") String mobile,
                       @Param("landlinePhone") String landlinePhone,
                       @Param("email") String email,
                       @Param("status") Integer status);


    /**
     * 根据手机号码查询
     * @param mobile 手机号码
     * @return 用户信息
     */
    UserEntity queryByMobile(@Param("mobile") String mobile);

    /**
     * 根据用户昵称查询
     * @param userName 用户名查询
     * @return 用户信息
     */
    UserEntity queryByUserName (@Param("userName") String userName);

    /**
     * 根据用户ID查询
     * @param userId 用户ID
     * @return 用户信息
     */
    UserEntity queryUserByUserId(@Param("userId") Long userId);

    /**
     * 根据用户ID查询
     * @param userId 用户ID
     * @param status 账号状态
     * @return 用户信息
     */
    UserEntity queryUserByUserIdAndStatus (@Param("userId") Long userId,
                                           @Param("status") Integer status);

    /**
     * 新增用户
     * @param userName 昵称
     * @param mobile 手机号码
     * @param addStarMobile 加星手机号码
     * @param ip ip地址
     * @param source 注册来源
     * @param password 密码
     * @return  添加
     */
    int addUser(@Param("userName") String userName,
                @Param("mobile") String mobile,
                @Param("addStarMobile") String addStarMobile,
                @Param("ip") String ip,
                @Param("source") Integer source,
                @Param("password") String password);
}
