package com.htcs.wework.system.model.dto;

import java.util.List;

/**
 * 角色查询条件dto
 *
 * @author Dragon
 * @create 2018-01-11 15:17
 **/
public class SysRoleSearchDto {
    /**
     * 菜单id
     */
    private Integer functionId;
    /**
     * 角色id集合
     */
    private List<Integer> roleIds;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色值
     */
    private String roleValue;
    /**
     * 区分是查看角色还是添加角色（1查看角色列表，2菜单添加角色）
     */
    private Integer showOrAdd;

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public Integer getShowOrAdd() {
        return showOrAdd;
    }

    public void setShowOrAdd(Integer showOrAdd) {
        this.showOrAdd = showOrAdd;
    }
}
