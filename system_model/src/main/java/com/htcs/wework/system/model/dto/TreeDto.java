package com.htcs.wework.system.model.dto;

import java.util.List;

/**
 * 用来放返回前台的树形结构的数据
 *
 * @author Dragon
 * @create 2018-01-22 16:38
 **/
public class TreeDto {

    /**
     * 节点id
     */
    private Integer id;

    /**
     * 父节点id
     */
    private Integer parentId;

    /**
     * 节点名
     */
    private String label;

    /**
     * 子节点
     */
    private List<TreeDto> children;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDto> children) {
        this.children = children;
    }
}
