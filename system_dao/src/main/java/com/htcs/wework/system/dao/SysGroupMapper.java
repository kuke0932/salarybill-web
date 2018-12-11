package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysGroup;
import com.htcs.wework.system.model.dto.SysGroupSearchDto;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysGroupMapper {

    int insertSelective(SysGroup record);

    SysGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysGroup record);

    List<Map<String,Object>> listGroup(@Param("groupName") String groupName);

    List<Map<String,Object>> showGroupUsers(SysUserSearchDto sysUserSearchDto);

    List<Map<String,Object>> listAddGroup(SysGroupSearchDto groupSearchDto);

    void logicalDeleteByIds(SysGroup sysGroup);
}