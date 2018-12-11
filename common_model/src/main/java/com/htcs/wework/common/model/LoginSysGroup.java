package com.htcs.wework.common.model;

import org.springframework.beans.BeanUtils;

/**
 * @author zhaokaiyuan
 * @create 2018-01-10 15:23
 **/
public class LoginSysGroup extends BaseModel {
    private static final long serialVersionUID = -8015053921422767513L;
    private Integer id;
    /**
     * 群组名称
     */
    private String groupName;
    /**
     * 群组描述
     */
    private String groupDesc;
    /**
     * 群组标签
     */
    private String groupTags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getGroupTags() {
        return groupTags;
    }

    public void setGroupTags(String groupTags) {
        this.groupTags = groupTags;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LoginSysGroup other = (LoginSysGroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
                && (this.getGroupDesc() == null ? other.getGroupDesc() == null : this.getGroupDesc().equals(other.getGroupDesc()))
                && (this.getGroupTags() == null ? other.getGroupTags() == null : this.getGroupTags().equals(other.getGroupTags()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getGroupDesc() == null) ? 0 : getGroupDesc().hashCode());
        result = prime * result + ((getGroupTags() == null) ? 0 : getGroupTags().hashCode());

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupName=").append(groupName);
        sb.append(", groupDesc=").append(groupDesc);
        sb.append(", groupTags=").append(groupTags);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public LoginSysGroup copyOf() {
        LoginSysGroup loginSysGroup = new LoginSysGroup();
        BeanUtils.copyProperties(this, loginSysGroup);
        return loginSysGroup;
    }
}
