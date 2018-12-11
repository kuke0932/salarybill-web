package com.htcs.wework.system.model;

import com.htcs.wework.common.model.LoginSysUser;

import java.util.List;

/**
 * @author 
 */
public class SysUser extends LoginSysUser {
    /**
     * 部门ID，用来传输数据用，数据库没有该字段
     * 多个id以","分割
     */
    private String departmentIds;

    /**
     * 部门ID集合，用来向前台传输数据用，数据库没有该字段
     */
    private List<Integer> departmentIdList;

    /**
     * 批量操作，用来存放id集合
     */
    private List<Integer> idList;

    public String getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(String departmentIds) {
        this.departmentIds = departmentIds;
    }

    public List<Integer> getDepartmentIdList() {
        return departmentIdList;
    }

    public void setDepartmentIdList(List<Integer> departmentIdList) {
        this.departmentIdList = departmentIdList;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}