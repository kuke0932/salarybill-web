package com.htcs.wework.common.model;

import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by htcs on 2017/7/25.
 */
public class LoginSysFunction extends BaseModel {
    private static final long serialVersionUID = -2956398117210215723L;
    /**
     * 权限ID
     */
    private Integer id;
    /**
     * 权限父ID
     */
    private Integer parentId;
    /**
     * 权限名
     */
    private String functionName;
    /**
     * 英文名
     */
    private String functionCode;
    /**
     * 权限路径
     */
    private String functionUrl;
    /**
     * 权限类型 1菜单 2功能
     */
    private Byte functionType;
    /**
     * 排序
     */
    private Integer functionSort;
    /**
     * 按钮或者菜单上图标样式
     */
    private String iconStyle;
    /**
     * 是否展示在页面上  1 展示 0  隐藏
     */
    private Integer isVisible;

    /**
     * 子菜单
     */
    private List<LoginSysFunction> childrenList;

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

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public Byte getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Byte functionType) {
        this.functionType = functionType;
    }

    public Integer getFunctionSort() {
        return functionSort;
    }

    public void setFunctionSort(Integer functionSort) {
        this.functionSort = functionSort;
    }

    public String getIconStyle() {
        return iconStyle;
    }

    public void setIconStyle(String iconStyle) {
        this.iconStyle = iconStyle;
    }

    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }

    public List<LoginSysFunction> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<LoginSysFunction> childrenList) {
        this.childrenList = childrenList;
    }

    public LoginSysFunction copyOf() {
        LoginSysFunction loginSysFunction = new LoginSysFunction();
        BeanUtils.copyProperties(this, loginSysFunction);
        return loginSysFunction;
    }
}
