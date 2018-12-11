package com.htcs.wework.system.model;

import com.htcs.wework.common.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class SysRoleUser extends BaseModel {
    private static final long serialVersionUID = -2909035444051038937L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 用户ID
     */
    private Integer userId;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}