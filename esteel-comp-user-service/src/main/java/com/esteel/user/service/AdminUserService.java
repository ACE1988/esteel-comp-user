package com.esteel.user.service;

import com.esteel.user.entity.admin.AdminUser;

import java.util.Date;
import java.util.List;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminUserService.java
 * @Description 操作员管理
 * @createTime 2020年5月20日 10:15
 */
public interface AdminUserService {

    /**
     * 查询用户列表总数
     * @param userName 账号名
     * @param email 邮箱
     * @param status 0:启用 1：禁用
     * @param autoStatus 0:分配 1：禁止分配
     * @return
     */
    int queryAdminUserCount(String userName,
                            String email,
                            Integer status,
                            Integer autoStatus);

    /**
     * 查询用户列表
     * @param userName 账号名
     * @param email 邮箱
//     * @param type 账号类型  0:初审 1：终审 2：主管
     * @param status 0:启用 1：禁用
     * @param pageNum
     * @param pageSize
     * @param autoStatus 0:分配 1：禁止分配
     * @return
     */
    List<AdminUser> queryAdminUserList(String userName,
                                       String email,
                                       Integer status,
                                       Integer pageNum,
                                       Integer pageSize,
                                       Integer autoStatus);

    /**
     * 重置密码
     * @param id 主键id
     * @param password 新密码
     * @return
     */
    boolean resetPassword(Long id,String password);

    /**
     * 启用，禁用用户
     * @param id 主键id
     * @param status   0:启用 1：禁用
     * @return
     */
    boolean updateStatus (Long id, Integer status);


    /**
     * 开启、禁用分配
     * @param id
     * @param autoStatus
     * @return
     */
    boolean updateAutoStatus(Long id,Integer  autoStatus);

    /**
     * 新增操作员
     * @param userName 用户名
     * @param email 邮箱
     * @param types 角色id  账号类型  0:初审 1：终审 2：主管
     * @param num 分配数
     * @param status   0:启用 1：禁用
     * @param password 密码
     * @param autoStatus 0:分配 1：禁止分配
     * @return
     */
    boolean addAdminUser(String userName,
                         String email,
                         String types,
                         Integer num,
                         Integer status,
                         String password,
                         Integer autoStatus);

    /**
     * 通过邮件查询用户信息
     * @param email
     * @return
     */
    AdminUser queryAdminUserByEmail(String email);

    /**
     * 用户名查询
     * @param userName
     * @return
     */
    AdminUser queryAdminUserByUserName(String userName);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    AdminUser queryByUserId(Long userId);

    /**
     * 更新操作员最近登录时间
     * @param userId
     * @param loginTime
     * @return
     */
    boolean updateLoginTime(Long userId, Date loginTime);

    /**
     * 修改用户角色
     * @param userId
     * @param types  账号类型  0:初审 1：终审 2：主管
     * @return
     */
    boolean updateTypesById(Long userId,String types);

    /**
     * 查询操作员列表(不分页)
     * @param type
     * @param email
     * @param userName
     * @return
     */
    List<AdminUser> queryAdminUser(Integer type,String email,String userName);

    /**
     * 根据条件查询列表
     * @param autoStatus
     * @param status
     * @param types
     * @return
     */
    List<AdminUser> queryByAutoStatusAndStatusAndTypes(Integer autoStatus,Integer status,String types);

    /**
     * 修改用户信息
     * @param adminUser
     * @return
     */
    boolean updateAdminUser(AdminUser adminUser);
}
