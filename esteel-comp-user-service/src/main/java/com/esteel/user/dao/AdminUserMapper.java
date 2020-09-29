package com.esteel.user.dao;

import com.esteel.user.entity.admin.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminUserServiceMapper.java
 * @Description 操作员管理
 * @createTime 2020年5月20日 10:28
 */
public interface AdminUserMapper {

    /**
     * 查询用户列表总数
     * @param userName 账号名
     * @param email 邮箱
     * @param status 0:启用 1：禁用
     * @param autoStatus 0:分配 1：禁止分配
     * @return
     */
    int queryAdminUserCount(@Param("userName") String userName,
                            @Param("email")String email,
                            @Param("status")Integer status,
                            @Param("autoStatus") Integer autoStatus);

    /**
     * 查询用户列表
     * @param userName 账号名
     * @param email 邮箱
     * @param status 0:启用 1：禁用
     * @param autoStatus 0:分配 1：禁止分配
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<AdminUser> queryAdminUserList(@Param("userName")String userName,
                                       @Param("email")String email,
                                       @Param("status")Integer status,
                                       @Param("pageNum") Integer pageNum,
                                       @Param("pageSize")Integer pageSize,
                                       @Param("autoStatus")Integer autoStatus);

    /**
     * 重置密码
     * @param id 主键id
     * @param password 新密码
     * @return
     */
    int resetPassword(@Param("id")Long id,
                      @Param("password")String password);

    /**
     * 启用，禁用用户
     * @param id 主键id
     * @param status   0:启用 1：禁用
     * @return
     */
    int updateStatus (@Param("id")Long id,
                      @Param("status")Integer status);

    /**
     * 设置分配数
     * @param id 主键id
     * @param num 分配数
     * @return
     */
    int updateNum(@Param("id")Long id,
                  @Param("num")Integer num);

    /**
     * 禁用启用分配
     * @param id
     * @param autoStatus
     * @return
     */
    int updateAutoStatus(@Param("id")Long id,
                         @Param("autoStatus")Integer autoStatus);

    /**
     * 新增操作员
     * @param userName 用户名
     * @param email 邮箱
     * @param types  账号类型  0:初审 1：终审 2：主管
     * @param num 分配数
     * @param status   0:启用 1：禁用
     * @param password 密码
     * @param autoStatus 0:分配 1:禁止分配
     * @return
     */
    int addAdminUser(@Param("userName")String userName,
                     @Param("email")String email,
                     @Param("types")String types,
                     @Param("num")Integer num,
                     @Param("status")Integer status,
                     @Param("password")String password,
                     @Param("autoStatus") Integer autoStatus);

    /**
     * 通过邮件查询操作员信息
     * @param email
     * @return
     */
    AdminUser queryAdminUserByEmail(@Param("email") String email);

    /**
     * 用户名查询
     * @param userName
     * @return
     */
    AdminUser queryAdminUserByUserName(@Param("userName") String userName);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    AdminUser queryByUserId(@Param("userId") Long userId);

    /**
     * 更新操作员最近一次登陆时间
     * @param userId
     * @param loginTime
     * @return
     */
    int updateLoginTime(@Param("userId") Long userId,@Param("loginTime") Date loginTime);

    /**
     * 修改用户角色
     * @param userId
     * @param types
     * @return
     */
    int updateTypesById(@Param("userId") Long userId,@Param("types") String types);

    /**
     * 修改用户信息
     * @param adminUser
     * @return
     */
    int updateAdminUser(@Param("adminUser") AdminUser adminUser);

    /**
     * 查询操作员列表(不分页)
     *
     * @param type
     * @param email
     * @param userName
     * @return
     */
    List<AdminUser> queryAdminUser(@Param("type") Integer type,
                                   @Param("email")String email,
                                   @Param("userName")String userName);

    /**
     * 操作员列表
     * @param autoStatus
     * @param status
     * @param types
     * @return
     */
    List<AdminUser> queryByAutoStatusAndStatusAndTypes(@Param("autoStatus") Integer autoStatus,
                                                       @Param("status") Integer status,
                                                       @Param("types") String types);
}
