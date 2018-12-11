package com.htcs.wework.system.service.impl;

import com.google.common.base.Preconditions;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.exception.ReturnStatusException;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.system.dao.SysRoleFunctionMapper;
import com.htcs.wework.system.dao.SysRoleMapper;
import com.htcs.wework.system.dao.SysRoleUserMapper;
import com.htcs.wework.system.model.SysRole;
import com.htcs.wework.system.model.SysRoleFunction;
import com.htcs.wework.system.model.SysRoleUser;
import com.htcs.wework.system.model.dto.SysRoleSearchDto;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import com.htcs.wework.system.service.SysRoleService;
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
 * @create 2018-01-11 15:12
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;
    @Autowired
    private SysRoleFunctionMapper sysRoleFunctionMapper;
    @Override
    public List<Map<String, Object>> listRole(SysRoleSearchDto sysRoleSearchDto) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        if (loginSysUser.getId() != 1) {
            return sysRoleMapper.listRoleNotAdmin(sysRoleSearchDto);
        }
        return sysRoleMapper.listRole(sysRoleSearchDto);
    }

    @Override
    public void addRole(SysRole sysRole) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        sysRole.setCreateBy(loginSysUser.getId());
        sysRole.setCreateName(loginSysUser.getUserName());
        sysRole.setCreateTime(new Date());
        sysRoleMapper.insertSelective(sysRole);
    }

    @Override
    public void updateRole(SysRole sysRole) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        if (sysRole.getId() == 1) {
            throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "该角色不能修改！");
        }

        sysRole.setUpdateBy(loginSysUser.getId());
        sysRole.setUpdateName(loginSysUser.getUserName());
        sysRole.setUpdateTime(new Date());
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public ReturnStatus removeRole(String ids) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());
        // 获取id集合
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        idList.forEach(id -> {
                    if (id == 1) {
                        throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "超级管理员角色不能删除！");
                    }
                });

        Integer userId = loginSysUser.getId();
        String userName = loginSysUser.getUserName();
        sysRoleMapper.logicalDeleteByIds(userId, userName, idList);
        return new ReturnStatus("删除成功！");
    }

    @Override
    public SysRole getRoleById(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Map<String, Object>> listRoleByFunctionId(SysRoleSearchDto sysRoleSearchDto) {
        return sysRoleMapper.listRoleByFunctionId(sysRoleSearchDto);
    }

    @Override
    public List<Map<String, Object>> listAddRole(SysRoleSearchDto sysRoleSearchDto) {
        return sysRoleMapper.listAddRole(sysRoleSearchDto);
    }

    @Override
    public List<Map<String, Object>> showRoleUsers(SysUserSearchDto sysUserSearchDto) {
        return sysRoleMapper.showRoleUsers(sysUserSearchDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserToRole(Integer roleId, String userIds) {
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setRoleId(roleId);
        Arrays.stream(userIds.split(","))
                .map(Integer::valueOf)
                .forEach(v -> {
                    sysRoleUser.setUserId(v);
                    sysRoleUserMapper.insertSelective(sysRoleUser);
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeUserFromRole(Integer roleId, String userIds) {
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setRoleId(roleId);
        Arrays.stream(userIds.split(","))
                .map(Integer::valueOf)
                .forEach(v -> {
                    if (v == 1) {
                        throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "admin用户不能删除！");
                    }
                    sysRoleUser.setUserId(v);
                    sysRoleUserMapper.deleteByRoleIdAndUserId(sysRoleUser);
                });
    }

    @Override
    public List<Integer> getRoleFunction(Integer roleId) {
        return sysRoleFunctionMapper.getRoleFunction(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setFunctionToRole(SysRoleFunction roleFunction) {
        sysRoleFunctionMapper.deleteByRoleId(roleFunction.getRoleId());
        sysRoleFunctionMapper.insertRoleFunction(roleFunction);
    }
}
