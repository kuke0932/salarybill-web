package com.htcs.wework.system.model;

import com.htcs.wework.common.model.LoginSysGroup;

import java.util.List;

/**
 * @author 
 */
public class SysGroup extends LoginSysGroup {

    /**
     * 逻辑操作，用于存放id集合
     */
    private List<Integer> idList;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}