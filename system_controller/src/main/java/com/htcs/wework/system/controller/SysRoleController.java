package com.htcs.wework.system.controller;

import com.github.pagehelper.PageHelper;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysRole;
import com.htcs.wework.system.model.SysRoleFunction;
import com.htcs.wework.system.model.dto.SysRoleSearchDto;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import com.htcs.wework.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-11 15:09
 **/
@RestController
@RequestMapping("/admin/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 根据 角色名/角色值 获取角色列表信息
     *
     * @param sysRoleSearchDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/listRole")
    public ReturnStatus<PageBean<Map<String, Object>>> listRole(SysRoleSearchDto sysRoleSearchDto,
                                                                int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list =  sysRoleService.listRole(sysRoleSearchDto);
        PageBean<Map<String, Object>> pageBean = new PageBean<>(list);
        return new ReturnStatus<>(pageBean);
    }

    /**
     * 新增角色
     *
     * @param sysRole
     * @return
     */
    @PostMapping(value = "/addRole")
    public ReturnStatus addRole(SysRole sysRole) {
        sysRoleService.addRole(sysRole);
        return new ReturnStatus("添加成功！");
    }

    /**
     * 根据id获取角色信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getRoleById")
    public ReturnStatus<SysRole> getRoleById(Integer id) {
        SysRole sysRole = sysRoleService.getRoleById(id);
        return new ReturnStatus<>(sysRole);
    }

    /**
     * 根据id修改角色
     *
     * @param sysRole
     * @return
     */
    @PostMapping(value = "/updateRole")
    public ReturnStatus updateRole(SysRole sysRole) {
        sysRoleService.updateRole(sysRole);
        return new ReturnStatus("修改成功！");
    }

    /**
     * 根据id批量删除角色
     *
     * @param ids
     * @return
     */
    @PostMapping(value = "/removeRole")
    public ReturnStatus removeRole(String ids) {
        sysRoleService.removeRole(ids);
        return new ReturnStatus("删除成功！");
    }

    /**
     * 根据角色id获取拥有该角色的用户列表
     *
     * @param sysUserSearchDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/showRoleUsers")
    public ReturnStatus<PageBean<Map<String, Object>>> showRoleUsers(SysUserSearchDto sysUserSearchDto,
                                                                      int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = sysRoleService.showRoleUsers(sysUserSearchDto);
        PageBean<Map<String, Object>> pageBean = new PageBean<>(list);
        return new ReturnStatus<>(pageBean);
    }

    /**
     * 添加用户到角色
     *
     * @param roleId
     * @param userIds
     * @return
     */
    @PostMapping(value = "/addUserToRole")
    public ReturnStatus addUserToRole(Integer roleId, String userIds) {
        sysRoleService.addUserToRole(roleId, userIds);
        return new ReturnStatus("添加成功！");
    }

    /**
     * 从角色里删除用户
     *
     * @param roleId
     * @param userIds
     * @return
     */
    @PostMapping(value = "/removeUserFromRole")
    public ReturnStatus removeUserFromRole(Integer roleId, String userIds) {
        sysRoleService.removeUserFromRole(roleId, userIds);
        return new ReturnStatus("删除成功！");
    }

    /**
     * 获取角色所拥有的菜单权限
     *
     * @param roleId 角色id
     * @return
     */
    @GetMapping(value = "/getRoleFunction")
    public ReturnStatus<List<Integer>> getRoleFunction(Integer roleId) {
        List<Integer> list = sysRoleService.getRoleFunction(roleId);
        return new ReturnStatus<>(list);
    }

    /**
     * 给角色设置菜单权限
     *
     * @param roleFunction 角色权限实体
     * @return
     */
    @PostMapping(value = "/setFunctionToRole")
    public ReturnStatus setFunctionToRole(SysRoleFunction roleFunction) {
        sysRoleService.setFunctionToRole(roleFunction);
        return new ReturnStatus("保存成功！");
    }
}
