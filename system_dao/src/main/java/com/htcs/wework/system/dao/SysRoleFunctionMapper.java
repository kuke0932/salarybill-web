package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysRoleFunction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleFunctionMapper {

    int insertSelective(SysRoleFunction record);

    void deleteByFunctionAndRoleId(SysRoleFunction sysRoleFunction);

    List<Integer> getRoleFunction(Integer roleId);

    void deleteByRoleId(Integer roleId);

    void insertRoleFunction(SysRoleFunction roleFunction);
}