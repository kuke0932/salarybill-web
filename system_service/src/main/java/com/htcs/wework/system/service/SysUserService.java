package com.htcs.wework.system.service;

import com.htcs.wework.system.model.SysDepartment;
import com.htcs.wework.system.model.SysGroup;
import com.htcs.wework.system.model.SysUser;
import com.htcs.wework.system.model.dto.SysUserSearchDto;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-10 9:02
 **/
public interface SysUserService {

    SysUser getUserByLoginName(String loginName);

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    boolean addUser(SysUser sysUser);

    /**
     * 根据id修改用户
     *
     * @param sysUser
     */
    void updateUser(SysUser sysUser);

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    SysUser getUserById(Integer id);

    /**
     * 根据 部门id/用户名/用户昵称 查询用户列表信息
     *
     * @param userSearchDto
     * @return
     */
    List<Map<String, Object>> listUser(SysUserSearchDto userSearchDto);

    /**
     * 根据id批量删除用户
     *
     * @param ids
     */
    void removeUser(String ids);

    /**
     * 启用或禁用账号
     *
     * @param sysUser
     */
    void updateStatus(SysUser sysUser);

    /**
     * 重置密码
     *
     * @param sysUser
     */
    void resetPassword(SysUser sysUser);

    /**
     * 根据用户id获取部门信息
     *
     * @param userId
     * @return
     */
    List<SysDepartment> listDepartmentByUserId(Integer userId);

    /**
     * 根据用户id获取群组信息
     *
     * @param userId
     * @return
     */
    List<SysGroup> listGroupByUserId(Integer userId);
}
