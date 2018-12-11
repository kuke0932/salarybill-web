package com.htcs.wework.system.mock_controller;


import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysUser;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dragon
 * @create 2018-01-10 8:57
 **/
@Api(tags = "用户", description = "用户增删改查接口")
@RestController
@RequestMapping("mock/admin/sysUser")
public class SysUserController {

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @ApiOperation("添加用户")
    @PostMapping(value = "/addUser")
    public ReturnStatus addUser(@ApiParam(value = "用户实体", required = true) @RequestBody SysUser sysUser) {
        return ReturnStatus.success();
    }

    /**
     * 修改用户信息
     *
     * @param sysUser
     * @return
     */
    @ApiOperation("修改用户信息")
    @PostMapping(value = "/updateUser")
    public ReturnStatus updateUser(@ApiParam(value = "用户实体", required = true) @RequestBody SysUser sysUser) {
        return ReturnStatus.success();
    }

    /**
     * 根据id批量删除用户
     *
     * @param ids
     * @return
     */
    @ApiOperation("根据id批量删除用户")
    @PostMapping(value = "/removeUser")
    public ReturnStatus removeUser(@ApiParam(value = "用户id,多个用户以,分割") @RequestParam String ids) {
        return ReturnStatus.success();
    }

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id获取用户信息")
    @GetMapping(value = "/getUserById")
    public ReturnStatus<SysUser> getUserById(@ApiParam(value = "用户id", required = true) @RequestParam Long id) {
        return ReturnStatus.success();
    }

    /**
     * 根据 部门id/用户名/用户昵称 查询用户列表信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("根据 部门id/用户名/用户昵称 查询用户列表信息")
    @GetMapping(value = "/listUser")
    public ReturnStatus<PageBean<SysUser>> listUser(@ApiParam(value = "区分是查看用户还是添加用户（1查看用户列表，2群组添加用户，3角色添加用户）") Integer showOrAdd,
                                                    @ApiParam(value = "部门id") Integer departmentId,
                                                    @ApiParam(value = "登录名") String loginName,
                                                    @ApiParam(value = "用户昵称") String userName,
                                                    @ApiParam(value = "页码", required = true) @RequestParam int pageNum,
                                                    @ApiParam(value = "页大小", required = true) @RequestParam int pageSize) {
        return ReturnStatus.success();
    }

    /**
     * 启用或禁用账号
     * @param sysUserId
     * @param oldStatus
     * @param newStatus
     * @return
     */
    @ApiOperation("启用或禁用账号")
    @PostMapping(value = "/updateStatus")
    public ReturnStatus updateStatus(@ApiParam(value = "用户id", required = true) @RequestParam Long sysUserId,
                                     @ApiParam(value = "用户旧状态", required = true) @RequestParam Byte oldStatus,
                                     @ApiParam(value = "用户新状态", required = true) @RequestParam Byte newStatus) {
        return ReturnStatus.success();
    }

    /**
     * 重置密码
     *
     * @param sysUserId
     * @param Password
     * @param confirmPassword
     * @return
     */
    @ApiOperation("重置密码")
    @PostMapping(value = "/resetPassword")
    public ReturnStatus resetPassword(@ApiParam(value = "用户id", required = true) @RequestParam Long sysUserId,
                                      @ApiParam(value = "用户新密码", required = true) @RequestParam String Password,
                                      @ApiParam(value = "用户确认密码", required = true) @RequestParam String confirmPassword) {
        return ReturnStatus.success();
    }
}
