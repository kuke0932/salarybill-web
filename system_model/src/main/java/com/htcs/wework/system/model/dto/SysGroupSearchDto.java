package com.htcs.wework.system.model.dto;

import java.util.List;

/**
 * 群组查询条件dto
 *
 * @author Dragon
 * @create 2018-01-16 16:52
 **/
public class SysGroupSearchDto {
    /**
     * 群组名
     */
    private String groupName;
    /**
     * 群组id集合
     */
    private List<Integer> groupIds;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Integer> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<Integer> groupIds) {
        this.groupIds = groupIds;
    }
}
