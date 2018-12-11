package com.htcs.wework.system.controller;

import com.github.pagehelper.PageHelper;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysUser;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import com.htcs.wework.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-10 8:57
 **/
@RestController
@RequestMapping("/admin/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/addUser")
    public ReturnStatus addUser(SysUser sysUser) {
        boolean success = sysUserService.addUser(sysUser);
        if (!success) {
            return new ReturnStatus("用户名已存在，请重新输入！");
        }
        return new ReturnStatus("添加成功！");
    }

    /**
     * 修改用户信息
     *
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/updateUser")
    public ReturnStatus updateUser(SysUser sysUser) {
        sysUserService.updateUser(sysUser);
        return new ReturnStatus("修改成功！");
    }

    /**
     * 根据id批量删除用户
     *
     * @param ids
     * @return
     */
    @PostMapping(value = "/removeUser")
    public ReturnStatus removeUser(String ids) {
        sysUserService.removeUser(ids);
        return new ReturnStatus("删除成功！");
    }

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getUserById")
    public ReturnStatus<SysUser> getUserById(Integer id) {
        SysUser sysUser = sysUserService.getUserById(id);
        return new ReturnStatus<>(sysUser);
    }

    /**
     * 根据 部门id/用户名/用户昵称 查询用户列表信息
     *
     * @param userSearchDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/listUser")
    public ReturnStatus<PageBean<Map<String, Object>>> listUser(SysUserSearchDto userSearchDto, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = sysUserService.listUser(userSearchDto);
        PageBean<Map<String, Object>> pageBean = new PageBean<>(list);
        return new ReturnStatus<>(pageBean);
    }

    /**
     * 启用或禁用账号
     *
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/updateStatus")
    public ReturnStatus updateStatus(SysUser sysUser) {
        sysUserService.updateStatus(sysUser);
        return new ReturnStatus("操作成功！");
    }

    /**
     * 重置密码
     *
     * @param sysUser
     * @return
     */
    @PostMapping(value = "/resetPassword")
    public ReturnStatus resetPassword(SysUser sysUser) {
        sysUserService.resetPassword(sysUser);
        return new ReturnStatus("操作成功！");
    }
}
