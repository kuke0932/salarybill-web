package com.htcs.wework.system.model;

import com.htcs.wework.common.model.BaseModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class SysRoleFunction extends BaseModel {
    private static final long serialVersionUID = -5463233643914126513L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer functionId;

    /**
     * 菜单id集合，数据库没有该字段，用于扩展
     */
    private List<Long> functionIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public List<Long> getFunctionIds() {
        return functionIds;
    }

    public void setFunctionIds(List<Long> functionIds) {
        this.functionIds = functionIds;
    }
}