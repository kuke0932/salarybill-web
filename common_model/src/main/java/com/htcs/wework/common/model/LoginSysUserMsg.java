package com.htcs.wework.common.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoginSysUserMsg implements Serializable {

    private static final long serialVersionUID = 6657538959340601790L;
    /**
     * 登录用户
     */
    private LoginSysUser user;
    /**
     * 用户群组
     */
    private List<LoginSysGroup> loginSysGroupList;
    /**
     * 用户部门列表
     */
    private List<LoginSysDepartment> loginSysDepartmentList;
    /**
     * 角色列表
     */
    private List<LoginSysRole> loginSysRoleList;
    /**
     * 功能列表
     */
    private List<LoginSysFunction> loginSysFunctionList;
    /**
     * 菜单地址集合
     */
    private Set<String> functionUrlSet = new HashSet<String>();
    /**
     * 菜单功能树
     */
    private LoginSysFunction functionTree;

    public LoginSysUser getUser() {
        return user;
    }

    public void setUser(LoginSysUser user) {
        this.user = user;
    }

    public List<LoginSysRole> getLoginSysRoleList() {
        return loginSysRoleList;
    }

    public void setLoginSysRoleList(List<LoginSysRole> loginSysRoleList) {
        this.loginSysRoleList = loginSysRoleList;
    }

    public LoginSysFunction getFunctionTree() {
        return functionTree;
    }

    public void setFunctionTree(LoginSysFunction functionTree) {
        this.functionTree = functionTree;
    }

    public List<LoginSysFunction> getLoginSysFunctionList() {
        return loginSysFunctionList;
    }

    public void setLoginSysFunctionList(List<LoginSysFunction> loginSysFunctionList) {
        if (loginSysFunctionList != null) {
            for (LoginSysFunction function : loginSysFunctionList) {
                functionUrlSet.add(function.getFunctionUrl());
            }
        }
        this.loginSysFunctionList = loginSysFunctionList;
    }

    public List<LoginSysGroup> getLoginSysGroupList() {
        return loginSysGroupList;
    }

    public void setLoginSysGroupList(List<LoginSysGroup> loginSysGroupList) {
        this.loginSysGroupList = loginSysGroupList;
    }

    public List<LoginSysDepartment> getLoginSysDepartmentList() {
        return loginSysDepartmentList;
    }

    public void setLoginSysDepartmentList(List<LoginSysDepartment> loginSysDepartmentList) {
        this.loginSysDepartmentList = loginSysDepartmentList;
    }
}
