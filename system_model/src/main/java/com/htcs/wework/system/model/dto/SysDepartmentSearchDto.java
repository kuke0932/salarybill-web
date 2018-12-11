package com.htcs.wework.system.model.dto;

import java.util.List;

/**
 * 部门查询条件dto
 *
 * @author Dragon
 * @create 2018-01-16 16:23
 **/
public class SysDepartmentSearchDto {
    /**
     * 父id
     */
    private Integer parentId;
    /**
     * 父部门名称
     */
    private String parentName;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门id集合
     */
    private List<Integer> departmentIds;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Integer> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<Integer> departmentIds) {
        this.departmentIds = departmentIds;
    }
}
