package com.htcs.wework.common.model;

import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author zhaokaiyuan
 * @create 2018-01-10 15:27
 **/
public class LoginSysDepartment extends BaseModel {
    private static final long serialVersionUID = 5900525614718627626L;
    private Integer id;
    /**
     * 父部门id
     */
    private Integer parentId;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门描述
     */
    private String departmentDesc;
    /**
     * 部门标签
     */
    private String departmentTags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public String getDepartmentTags() {
        return departmentTags;
    }

    public void setDepartmentTags(String departmentTags) {
        this.departmentTags = departmentTags;
    }

    public LoginSysDepartment copyOf() {
        LoginSysDepartment loginSysDepartment = new LoginSysDepartment();
        BeanUtils.copyProperties(this, loginSysDepartment);
        return loginSysDepartment;
    }
}
