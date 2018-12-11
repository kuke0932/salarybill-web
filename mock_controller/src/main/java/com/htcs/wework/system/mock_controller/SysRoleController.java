package com.htcs.wework.system.mock_controller;

import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysRole;
import com.htcs.wework.system.model.SysRoleFunction;
import com.htcs.wework.system.model.dto.SysRoleSearchDto;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "角色", description = "角色增删改查接口")
@RequestMapping("mock/admin/role")
public class SysRoleController {
    /**
     * 根据 角色名/角色值 获取角色列表信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("查询角色")
    @GetMapping(value = "/listRole", produces = "application/json")
    public ReturnStatus<PageBean<SysRole>> listRole(@ApiParam("角色名") String roleName,
                                                    @ApiParam("角色值") String roleValue,
                                                    @ApiParam("页码") @RequestParam int pageNum,
                                                    @ApiParam("页大小") @RequestParam int pageSize) {
        return ReturnStatus.success();
    }

    /**
     * 新增角色
     *
     * @param sysRole
     * @return
     */
    @PostMapping(value = "/addRole")
    public ReturnStatus addRole(@ApiParam("角色实体") @RequestBody SysRole sysRole) {
        return ReturnStatus.success();
    }

    /**
     * 根据id获取角色信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getRoleById")
    @ApiOperation("根据id查询角色信息")
    public ReturnStatus<SysRole> getRoleById(@ApiParam("角色id") Long id) {
        return ReturnStatus.success();
    }

    /**
     * 根据id修改角色
     *
     * @param sysRole
     * @return
     */
    @PostMapping(value = "/updateRole")
    @ApiOperation("修改角色")
    public ReturnStatus updateRole(@ApiParam("角色实体") @RequestBody SysRole sysRole) {
        return ReturnStatus.success();
    }

    /**
     * 根据id批量删除角色
     *
     * @param ids
     * @return
     */
    @PostMapping(value = "/removeRole")
    @ApiOperation("删除角色")
    public ReturnStatus removeRole(@ApiParam("角色id, 多个角色以,分割") @RequestParam String ids) {
        return ReturnStatus.success();
    }

    /**
     * 根据角色id获取拥有该角色的用户列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/showRoleUsers")
    @ApiOperation("根据角色id获取用户列表")
    public ReturnStatus<PageBean<Map<String, Object>>> showRoleUsers(@ApiParam(value = "角色id", required = true) Integer roleId,
                                                                     @ApiParam("登录名") String loginName,
                                                                     @ApiParam("用户昵称") String userName,
                                                                     @ApiParam("页码") @RequestParam int pageNum,
                                                                     @ApiParam("页码") @RequestParam int pageSize) {
        return ReturnStatus.success();
    }

    /**
     * 添加用户到角色
     *
     * @param roleId
     * @param userIds
     * @return
     */
    @PostMapping(value = "/addUserToRole")
    @ApiOperation("添加用户到角色")
    public ReturnStatus addUserToRole(@ApiParam("角色id") Long roleId, @ApiParam("用户id,多个用户以,分割") String userIds) {
        return ReturnStatus.success();
    }

    /**
     * 从角色里删除用户
     *
     * @param roleId
     * @param userIds
     * @return
     */
    @PostMapping(value = "/removeUserFromRole")
    @ApiOperation("从角色删除用户")
    public ReturnStatus removeUserFromRole(@ApiParam("角色id") Long roleId, @ApiParam("用户id,多个用户以,分割") String userIds) {
        return ReturnStatus.success();
    }

    /**
     * 获取角色所拥有的菜单权限
     *
     * @param roleId 角色id
     * @return
     */
    @GetMapping(value = "/getRoleFunction")
    @ApiOperation("查询角色菜单权限")
    public ReturnStatus<List<Long>> getRoleFunction(@ApiParam("角色id") Long roleId) {
        return ReturnStatus.success();
    }

    /**
     * 给角色设置菜单权限
     *
     * @param roleFunction 角色权限实体
     * @return
     */
    @PostMapping(value = "/setFunctionToRole")
    @ApiOperation("给角色设置菜单")
    public ReturnStatus setFunctionToRole(@ApiParam @RequestBody SysRoleFunction roleFunction) {
        return ReturnStatus.success();
    }
}
