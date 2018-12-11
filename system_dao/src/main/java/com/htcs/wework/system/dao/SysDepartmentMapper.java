package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysDepartment;
import com.htcs.wework.system.model.dto.SysDepartmentSearchDto;
import com.htcs.wework.system.model.dto.TreeDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysDepartmentMapper {
    int insertSelective(SysDepartment record);

    SysDepartment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDepartment record);

    List<TreeDto> listDepartment();

    List<SysDepartment> listDepartmentByParentId(SysDepartmentSearchDto departmentSearchDto);

    int countByParentId(Integer parentId);

    Map<String,Object> getDepartmentById(Integer id);

    void logicalDeleteByIds(@Param("id") Integer id,
                            @Param("userName") String userName,
                            @Param("idList") List<Integer> idList);
}