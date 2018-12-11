package com.htcs.wework.system.controller;

import com.github.pagehelper.PageHelper;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysGroup;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import com.htcs.wework.system.service.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-12 16:20
 **/
@RestController
@RequestMapping("/admin/sysGroup")
public class SysGroupController {
    @Autowired
    private SysGroupService sysGroupService;

    /**
     * 根据群组名获取群组列表
     *
     * @param groupName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/listGroup")
    public ReturnStatus<PageBean<Map<String, Object>>> listGroup(String groupName, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = sysGroupService.listGroup(groupName);
        PageBean<Map<String, Object>> pageBean = new PageBean<>(list);
        return new ReturnStatus<>(pageBean);
    }

    /**
     * 新增群组
     *
     * @param sysGroup
     * @return
     */
    @PostMapping(value = "/addGroup")
    public ReturnStatus addGroup(SysGroup sysGroup) {
        sysGroupService.addGroup(sysGroup);
        return new ReturnStatus("添加成功！");
    }

    /**
     * 根据id获取群组信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getGroupById")
    public ReturnStatus<SysGroup> getGroupById(Integer id) {
        SysGroup sysGroup = sysGroupService.getGroupById(id);
        return new ReturnStatus<>(sysGroup);
    }

    /**
     * 根据id修改群组
     *
     * @param sysGroup
     * @return
     */
    @PostMapping("/updateGroup")
    public ReturnStatus updateGroup(SysGroup sysGroup) {
        sysGroupService.updateGroup(sysGroup);
        return new ReturnStatus("修改成功！");
    }

    /**
     * 根据群组id批量删除群组
     *
     * @param ids
     * @return
     */
    @PostMapping(value = "/removeGroup")
    public ReturnStatus removeGroup(String ids) {
        sysGroupService.removeGroup(ids);
        return new ReturnStatus("删除成功！");
    }

    /**
     * 根据群组id获取该群组下的用户列表
     *
     * @param sysUserSearchDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/showGroupUsers")
    public ReturnStatus<PageBean<Map<String, Object>>> showGroupUsers(SysUserSearchDto sysUserSearchDto,
                                                                      int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = sysGroupService.showGroupUsers(sysUserSearchDto);
        PageBean<Map<String, Object>> pageBean = new PageBean<>(list);
        return new ReturnStatus<>(pageBean);
    }

    /**
     * 添加用户到群组
     *
     * @param groupId
     * @param userIds
     * @return
     */
    @PostMapping(value = "/addUserToGroup")
    public ReturnStatus addUserToGroup(Integer groupId, String userIds) {
        sysGroupService.addUserToGroup(groupId, userIds);
        return new ReturnStatus("添加成功！");
    }

    /**
     * 从群组里删除用户
     *
     * @param groupId
     * @param userIds
     * @return
     */
    @PostMapping(value = "/removeUserFromGroup")
    public ReturnStatus removeUserFromGroup(Integer groupId, String userIds) {
        sysGroupService.removeUserFromGroup(groupId, userIds);
        return new ReturnStatus("删除成功！");
    }
}
