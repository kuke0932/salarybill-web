package com.htcs.wework.system.model.dto;

/**
 * 用户查询条件dto
 *
 * @author Dragon
 * @create 2018-01-10 15:25
 **/
public class SysUserSearchDto {
    /**
     * 部门id
     */
    private Integer departmentId;
    /**
     * 群组id
     */
    private Integer groupId;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 区分是查看用户还是添加用户（1查看用户列表，2群组添加用户，3角色添加用户）
     */
    private Integer showOrAdd;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getShowOrAdd() {
        return showOrAdd;
    }

    public void setShowOrAdd(Integer showOrAdd) {
        this.showOrAdd = showOrAdd;
    }
}
