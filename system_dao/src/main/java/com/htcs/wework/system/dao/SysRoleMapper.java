package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysRole;
import com.htcs.wework.system.model.dto.SysRoleSearchDto;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysRoleMapper {

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    List<SysRole> listBySysUserId(@Param("sysUserId") Integer sysUserId);

    int updateByPrimaryKeySelective(SysRole record);

    List<Map<String,Object>> listRole(SysRoleSearchDto sysRoleSearchDto);

    List<Map<String,Object>> listRoleByFunctionId(SysRoleSearchDto sysRoleSearchDto);

    List<Map<String,Object>> listAddRole(SysRoleSearchDto sysRoleSearchDto);

    List<Map<String,Object>> showRoleUsers(SysUserSearchDto sysUserSearchDto);

    List<Map<String,Object>> listRoleNotAdmin(SysRoleSearchDto sysRoleSearchDto);

    void logicalDeleteByIds(@Param("updateBy") Integer updateBy,
                            @Param("updateName") String updateName,
                            @Param("idList") List<Integer> idList);
}