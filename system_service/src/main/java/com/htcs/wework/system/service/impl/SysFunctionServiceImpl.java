package com.htcs.wework.system.service.impl;

import com.google.common.base.Preconditions;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.exception.ReturnStatusException;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.system.dao.SysFunctionMapper;
import com.htcs.wework.system.dao.SysRoleFunctionMapper;
import com.htcs.wework.system.model.SysFunction;
import com.htcs.wework.system.model.SysRoleFunction;
import com.htcs.wework.system.model.dto.TreeDto;
import com.htcs.wework.system.service.SysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaokaiyuan
 * @create 2018-01-11 16:04
 **/
@Service
public class SysFunctionServiceImpl implements SysFunctionService {

    @Autowired
    SysFunctionMapper sysFunctionMapper;
    @Autowired
    private SysRoleFunctionMapper sysRoleFunctionMapper;

    @Override
    public void addFunction(SysFunction sysFunction) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        sysFunction.setCreateBy(loginSysUser.getId());
        sysFunction.setCreateName(loginSysUser.getUserName());
        sysFunction.setCreateTime(new Date());
        sysFunctionMapper.insertSelective(sysFunction);
    }

    @Override
    public void updateFunction(SysFunction sysFunction) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        if (sysFunction.getId() == 1) {
            throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "该菜单不能修改！");
        }

        sysFunction.setUpdateBy(loginSysUser.getId());
        sysFunction.setUpdateName(loginSysUser.getUserName());
        sysFunction.setUpdateTime(new Date());
        sysFunctionMapper.updateByPrimaryKeySelective(sysFunction);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeFunction(String ids) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::valueOf).collect(Collectors.toList());

        idList.forEach(v -> {
                    if (v == 1) {
                        throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "系统菜单不能删除！");
                    }
                    int count = sysFunctionMapper.countByParentId(v);
                    if (count > 0) {
                        SysFunction sysFunction = sysFunctionMapper.selectByPrimaryKey(v);
                        throw new IllegalArgumentException(sysFunction.getFunctionName() + "尚有子菜单存在，请先删除子菜单！");
                    }
                });
        sysFunctionMapper.logicalDeleteByIds(loginSysUser.getId(), loginSysUser.getUserName(), idList);
    }

    @Override
    public SysFunction getFunctionById(Integer id) {
        return sysFunctionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TreeDto> treeFunction() {
        List<TreeDto> list = sysFunctionMapper.listFunctions();
        List<TreeDto> functionList = new ArrayList<>();
        for (TreeDto sysFunction : list) {
            if (null == sysFunction.getParentId()) {
                functionList.add(sysFunction);
            }
        }
        for (TreeDto sysFunction : functionList) {
            sysFunction.setChildren(getChild(sysFunction.getId(), list));
        }
        return functionList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRoleToFunction(Integer functionId, String roleIds) {
        SysRoleFunction sysRoleFunction = new SysRoleFunction();
        sysRoleFunction.setFunctionId(functionId);
        Arrays.stream(roleIds.split(","))
                .map(Integer::valueOf)
                .forEach(v -> {
                    sysRoleFunction.setRoleId(v);
                    sysRoleFunctionMapper.insertSelective(sysRoleFunction);
                });
    }

    @Override
    public void removeRoleFromFunction(Integer functionId, String roleIds) {
        Arrays.stream(roleIds.split(","))
                .map(Integer::valueOf)
                .forEach(id -> {
                    if (id == 1) {
                        throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "超级管理员角色不能删除！");
                    }
                });
        SysRoleFunction sysRoleFunction = new SysRoleFunction();
        sysRoleFunction.setFunctionId(functionId);
        Arrays.stream(roleIds.split(","))
                .map(Integer::valueOf)
                .forEach(v -> {
                    sysRoleFunction.setRoleId(v);
                    sysRoleFunctionMapper.deleteByFunctionAndRoleId(sysRoleFunction);
                });
    }

    private List<TreeDto> getChild(Integer id, List<TreeDto> list) {
        List<TreeDto> childList = new ArrayList<>();
        for (TreeDto sysFunction : list) {
            if (Objects.equals(sysFunction.getParentId(), id)) {
                childList.add(sysFunction);
            }
        }
        for (TreeDto function : childList) {
            function.setChildren(getChild(function.getId(), list));
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
