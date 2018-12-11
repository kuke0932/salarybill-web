package com.htcs.wework.system.service.impl;

import com.google.common.base.Preconditions;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.system.dao.SysGroupMapper;
import com.htcs.wework.system.dao.SysGroupUserMapper;
import com.htcs.wework.system.model.SysGroup;
import com.htcs.wework.system.model.SysGroupUser;
import com.htcs.wework.system.model.dto.SysGroupSearchDto;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import com.htcs.wework.system.service.SysGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dragon
 * @create 2018-01-12 16:21
 **/
@Service
public class SysGroupServiceImpl implements SysGroupService {
    @Autowired
    private SysGroupMapper sysGroupMapper;
    @Autowired
    private SysGroupUserMapper sysGroupUserMapper;

    @Override
    public List<Map<String, Object>> listGroup(String groupName) {
        return sysGroupMapper.listGroup(groupName);
    }

    @Override
    public void addGroup(SysGroup sysGroup) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        sysGroup.setCreateBy(loginSysUser.getId());
        sysGroup.setCreateName(loginSysUser.getUserName());
        sysGroup.setCreateTime(new Date());
        sysGroupMapper.insertSelective(sysGroup);
    }

    @Override
    public void updateGroup(SysGroup sysGroup) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        sysGroup.setUpdateBy(loginSysUser.getId());
        sysGroup.setUpdateName(loginSysUser.getUserName());
        sysGroup.setUpdateTime(new Date());
        sysGroupMapper.updateByPrimaryKeySelective(sysGroup);
    }

    @Override
    public SysGroup getGroupById(Integer id) {
        return sysGroupMapper.selectByPrimaryKey(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeGroup(String ids) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        Integer userId = loginSysUser.getId();
        String userName = loginSysUser.getUserName();
        Date date = new Date();
        // 获取id集合
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        SysGroup sysGroup = new SysGroup();
        sysGroup.setUpdateBy(userId);
        sysGroup.setUpdateName(userName);
        sysGroup.setUpdateTime(date);
        sysGroup.setIdList(idList);
        sysGroupMapper.logicalDeleteByIds(sysGroup);
    }

    @Override
    public List<Map<String, Object>> listAddGroup(SysGroupSearchDto groupSearchDto) {
        return sysGroupMapper.listAddGroup(groupSearchDto);
    }

    @Override
    public List<Map<String, Object>> showGroupUsers(SysUserSearchDto sysUserSearchDto) {
        return sysGroupMapper.showGroupUsers(sysUserSearchDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserToGroup(Integer groupId, String userIds) {
        SysGroupUser sysGroupUser = new SysGroupUser();
        sysGroupUser.setGroupId(groupId);
        Arrays.stream(userIds.split(","))
                .map(Integer::valueOf)
                .forEach(v -> {
                    sysGroupUser.setUserId(v);
                    sysGroupUserMapper.insertSelective(sysGroupUser);
                });
    }

    @Override
    public void removeUserFromGroup(Integer groupId, String userIds) {
        SysGroupUser sysGroupUser = new SysGroupUser();
        sysGroupUser.setGroupId(groupId);
        Arrays.stream(userIds.split(","))
                .map(Integer::valueOf)
                .forEach(v -> {
                    sysGroupUser.setUserId(v);
                    sysGroupUserMapper.deleteByGroupIdAndUserId(sysGroupUser);
                });
    }
}
