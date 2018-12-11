package com.htcs.wework.system.model;

import com.htcs.wework.common.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class SysDepartmentUser extends BaseModel {
    private static final long serialVersionUID = 3075470089374337317L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 部门ID
     */
    private Integer departmentId;

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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}