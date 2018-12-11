package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysGroup;
import com.htcs.wework.system.model.SysGroupUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysGroupUserMapper {
    int insertSelective(SysGroupUser record);

    void deleteByGroupIdAndUserId(SysGroupUser sysGroupUser);

    List<SysGroup> listGroupByUserId(Integer userId);
}