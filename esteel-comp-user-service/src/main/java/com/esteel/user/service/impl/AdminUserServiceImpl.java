package com.esteel.user.service.impl;

import com.esteel.user.common.ListUtils;
import com.esteel.user.dao.AdminUserMapper;
import com.esteel.user.entity.admin.AdminUser;
import com.esteel.user.common.Md5;
import com.esteel.user.mq.producer.UserProducer;
import com.esteel.user.service.AdminUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName AdminUserServiceImpl.java
 * @Description 操作员管理
 * @createTime 2020年5月20日 10:27
 */
@Component
public class AdminUserServiceImpl implements AdminUserService {

    Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);

    @Autowired
    AdminUserMapper adminUserMapper ;

    @Autowired
    StringRedisTemplate stringRedisTemplate ;

    @Autowired
    UserProducer userProducer ;

    /**
     * 查询用户列表总数
     *
     * @param userName 账号名
     * @param email    邮箱
//     * @param type     账号类型  0:初审 1：终审 2：主管
     * @param status   0:启用 1：禁用
     * @param
     * @return
     */
    @Override
    public int queryAdminUserCount(String userName,
                                   String email,
                                   Integer status,
                                   Integer autoStatus) {


        stringRedisTemplate.opsForValue().set("cc","dd");
        userProducer.userProducer("100001");
        return adminUserMapper.queryAdminUserCount(userName,email,status,autoStatus);
    }

    /**
     * 查询用户列表
     *
     * @param userName 账号名
     * @param email    邮箱
//     * @param type     账号类型  0:初审 1：终审 2：主管
     * @param status   0:启用 1：禁用
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<AdminUser> queryAdminUserList(String userName,
                                              String email,
                                              Integer status,
                                              Integer pageNum,
                                              Integer pageSize,
                                              Integer autoStatus) {
        return adminUserMapper.queryAdminUserList(userName,email,status,pageNum,pageSize,autoStatus);
    }

    /**
     * 重置密码
     *
     * @param id       主键id
     * @param password 新密码
     * @return
     */
    @Override
    public boolean resetPassword(Long id, String password) {
        if(StringUtils.isNotBlank(password)){
           password =  Md5.getMd5(password);
           return adminUserMapper.resetPassword(id,password) == 1;
        }
        return false ;
    }

    /**
     * 启用，禁用用户
     *
     * @param id     主键id
     * @param status 0:启用 1：禁用
     * @return
     */
    @Override
    public boolean updateStatus(Long id, Integer status) {
        return adminUserMapper.updateStatus(id,status) == 1;
    }

    /**
     * 开启、禁用分配
     * @param id
     * @param autoStatus
     * @return
     */
    @Override
    public boolean updateAutoStatus(Long id,Integer  autoStatus){
        return adminUserMapper.updateAutoStatus(id,autoStatus) == 1;
    }

    /**
     * 新增操作员
     *
     * @param userName 用户名
     * @param email    邮箱
     * @param types    账号类型  0:初审 1：终审 2：主管  多个逗号隔开
     * @param num      分配数
     * @param status   0:启用 1：禁用
     * @param password 密码
     * @return
     */
    @Override
    public boolean addAdminUser(String userName,
                                String email,
                                String types,
                                Integer num,
                                Integer status,
                                String password,
                                Integer autoStatus) {
        password =  Md5.getMd5(password);
        //邮箱转大写
        email = email.toLowerCase();
        List<Integer>  typeList = ListUtils.convertStringListToIntList(Arrays.asList(types.split(",")), Integer::parseInt);
        return adminUserMapper.addAdminUser(userName,email,types,num,status,password,autoStatus) == 1;
    }

    /**
     * 通过邮件查询用户信息
     *
     * @param email
     * @return
     */
    @Override
    public AdminUser queryAdminUserByEmail(String email) {
        return adminUserMapper.queryAdminUserByEmail(StringUtils.isBlank(email)? "" : email.toLowerCase());
    }

    /**
     * 用户名查询
     *
     * @param userName
     * @return
     */
    @Override
    public AdminUser queryAdminUserByUserName(String userName) {
        return adminUserMapper.queryAdminUserByUserName(userName);
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public AdminUser queryByUserId(Long userId) {
        return adminUserMapper.queryByUserId(userId);
    }

    /**
     * 更新操作员最近登录时间
     *
     * @param userId
     * @param loginTime
     * @return
     */
    @Override
    public boolean updateLoginTime(Long userId, Date loginTime) {
        return adminUserMapper.updateLoginTime(userId,loginTime) == 1;
    }

    /**
     * 修改用户角色
     *
     * @param userId
     * @param types
     * @return
     */
    @Override
    public boolean updateTypesById(Long userId, String types) {
        return adminUserMapper.updateTypesById(userId,types) == 1;
    }

    /**
     * 查询操作员列表(不分页)
     *
     * @param type
     * @param email
     * @param userName
     * @return
     */
    @Override
    public List<AdminUser> queryAdminUser(Integer type, String email, String userName) {
        return adminUserMapper.queryAdminUser(type,StringUtils.isBlank(email)? email: email.toLowerCase(),userName);
    }

    /**
     * 根据条件查询列表
     *
     * @param autoStatus
     * @param status
     * @param types
     * @return
     */
    @Override
    public List<AdminUser> queryByAutoStatusAndStatusAndTypes(Integer autoStatus, Integer status, String types) {
        return adminUserMapper.queryByAutoStatusAndStatusAndTypes(autoStatus,status,types);
    }

    /**
     * 修改用户信息
     *
     * @param adminUser
     * @return
     */
    @Override
    public boolean updateAdminUser(AdminUser adminUser) {
        return adminUserMapper.updateAdminUser(adminUser) >= 1 ;
    }

}
