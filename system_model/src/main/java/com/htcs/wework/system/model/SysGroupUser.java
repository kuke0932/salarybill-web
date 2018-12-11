package com.htcs.wework.system.model;

import com.htcs.wework.common.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class SysGroupUser extends BaseModel {
    private static final long serialVersionUID = 169841299486380014L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 群组ID
     */
    private Integer groupId;

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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}