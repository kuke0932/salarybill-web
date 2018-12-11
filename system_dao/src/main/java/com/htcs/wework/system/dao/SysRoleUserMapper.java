package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysRoleUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleUserMapper {

    int insertSelective(SysRoleUser record);

    void deleteByRoleIdAndUserId(SysRoleUser sysRoleUser);
}