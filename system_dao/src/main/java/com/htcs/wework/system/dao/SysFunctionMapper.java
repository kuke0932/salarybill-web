package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysFunction;
import com.htcs.wework.system.model.dto.TreeDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysFunctionMapper {
    int insertSelective(SysFunction record);

    SysFunction selectByPrimaryKey(Integer id);

    List<SysFunction> listFunctionsByRoleIds(@Param("list") List roleIds);

    int updateByPrimaryKeySelective(SysFunction record);

    int countByParentId(Integer parentId);

    List<TreeDto> listFunctions();

    void logicalDeleteByIds(@Param("id") Integer id,
                            @Param("userName") String userName,
                            @Param("idList") List<Integer> idList);
}