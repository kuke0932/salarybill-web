package com.htcs.wework.system.dao;

import com.htcs.wework.system.model.SysDepartment;
import com.htcs.wework.system.model.SysDepartmentUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDepartmentUserMapper {

    int insertSelective(SysDepartmentUser record);

    void deleteByUserId(Integer userId);

    List<Integer> listDepartmentIdByUserId(Integer userId);

    List<SysDepartment> listDepartmentByUserId(Integer userId);
}