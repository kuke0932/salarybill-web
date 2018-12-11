package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysUser;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserMapper {

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    SysUser selectByLoginName(String loginName);

    int updateByPrimaryKeySelective(SysUser record);

    int countByLoginName(String loginName);

    List<Map<String,Object>> listUser(SysUserSearchDto userSearchDto);

    void logicalDeleteByIds(@Param("updateBy") Integer updateBy,
                            @Param("updateName") String updateName,
                            @Param("idList") List<Integer> idList);

    List<Map<String,Object>> listUserNotAdmin(SysUserSearchDto userSearchDto);
}