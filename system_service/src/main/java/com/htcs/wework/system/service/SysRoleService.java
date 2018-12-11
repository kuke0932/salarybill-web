package com.htcs.wework.system.service;

import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.system.model.SysRole;
import com.htcs.wework.system.model.SysRoleFunction;
import com.htcs.wework.system.model.dto.SysRoleSearchDto;
import com.htcs.wework.system.model.dto.SysUserSearchDto;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-11 15:10
 **/
public interface SysRoleService {
    /**
     * 根据 角色名/角色值 获取角色列表信息
     *
     * @param sysRoleSearchDto
     * @return
     */
    List<Map<String,Object>> listRole(SysRoleSearchDto sysRoleSearchDto);

    /**
     * 新增角色
     *
     * @param sysRole
     */
    void addRole(SysRole sysRole);

    /**
     * 根据id修改角色
     *
     * @param sysRole
     */
    void updateRole(SysRole sysRole);

    /**
     * 根据id批量删除角色
     *
     * @param ids
     */
    ReturnStatus removeRole(String ids);

    /**
     * 根据id获取角色信息
     *
     * @param id
     * @return
     */
    SysRole getRoleById(Integer id);

    /**
     * 根据菜单id获取拥有该菜单的角色
     *
     * @param sysRoleSearchDto
     * @return
     */
    List<Map<String,Object>> listRoleByFunctionId(SysRoleSearchDto sysRoleSearchDto);

    /**
     * 新增文件夹获取还未添加的角色列表
     *
     * @param sysRoleSearchDto
     * @return
     */
    List<Map<String,Object>> listAddRole(SysRoleSearchDto sysRoleSearchDto);

    /**
     * 根据角色id获取拥有该角色的用户列表
     *
     * @param sysUserSearchDto
     * @return
     */
    List<Map<String,Object>> showRoleUsers(SysUserSearchDto sysUserSearchDto);

    /**
     * 添加用户到角色
     *
     * @param roleId
     * @param userIds
     */
    void addUserToRole(Integer roleId, String userIds);

    /**
     * 从角色里删除用户
     *
     * @param roleId
     * @param userIds
     */
    void removeUserFromRole(Integer roleId, String userIds);

    /**
     * 获取角色所拥有的菜单权限
     *
     * @param roleId 角色id
     * @return
     */
    List<Integer> getRoleFunction(Integer roleId);

    /**
     * 给角色设置菜单权限
     *
     * @param roleFunction
     */
    void setFunctionToRole(SysRoleFunction roleFunction);
}
