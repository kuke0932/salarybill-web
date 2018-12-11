package com.htcs.wework.system.service;

import com.htcs.wework.system.model.SysGroup;
import com.htcs.wework.system.model.dto.SysGroupSearchDto;
import com.htcs.wework.system.model.dto.SysUserSearchDto;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-12 16:21
 **/
public interface SysGroupService {
    /**
     * 根据群组名获取群组列表
     *
     * @param groupName
     * @return
     */
    List<Map<String,Object>> listGroup(String groupName);

    /**
     * 新增群组
     *
     * @param sysGroup
     */
    void addGroup(SysGroup sysGroup);

    /**
     * 根据id修改群组
     *
     * @param sysGroup
     */
    void updateGroup(SysGroup sysGroup);

    /**
     * 根据id获取群组信息
     *
     * @param id
     * @return
     */
    SysGroup getGroupById(Integer id);

    /**
     * 根据群组id获取该群组下的用户列表
     *
     * @param sysUserSearchDto
     * @return
     */
    List<Map<String,Object>> showGroupUsers(SysUserSearchDto sysUserSearchDto);

    /**
     * 添加用户到群组
     *
     * @param groupId
     * @param userIds
     */
    void addUserToGroup(Integer groupId, String userIds);

    /**
     * 从群组里删除用户
     *
     * @param groupId
     * @param userIds
     */
    void removeUserFromGroup(Integer groupId, String userIds);

    /**
     * 根据群组id批量删除群组
     *
     * @param ids
     */
    void removeGroup(String ids);

    /**
     * 新增文件夹获取还未添加的群组列表
     *
     * @param groupSearchDto
     * @return
     */
    List<Map<String,Object>> listAddGroup(SysGroupSearchDto groupSearchDto);
}
