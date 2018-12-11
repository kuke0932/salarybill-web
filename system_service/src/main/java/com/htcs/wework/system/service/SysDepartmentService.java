package com.htcs.wework.system.service;

import com.htcs.wework.system.model.SysDepartment;
import com.htcs.wework.system.model.dto.SysDepartmentSearchDto;
import com.htcs.wework.system.model.dto.TreeDto;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-10 16:05
 **/
public interface SysDepartmentService {

    /**
     * 获取所有部门的树形结构
     *
     * @return
     */
    List<TreeDto> treeDepartment();

    /**
     * 根据父节点获取子节点列表
     *
     * @param departmentSearchDto
     * @return
     */
    List<SysDepartment> listDepartmentByParentId(SysDepartmentSearchDto departmentSearchDto);

    /**
     * 新增部门
     *
     * @param sysDepartment
     */
    void addDepartment(SysDepartment sysDepartment);

    /**
     * 根据id修改部门信息
     *
     * @param sysDepartment
     */
    void updateDepartment(SysDepartment sysDepartment);

    /**
     * 根据id批量删除部门
     *
     * @param ids
     */
    void removeDepartment(String ids);

    /**
     * 根据id获取部门信息
     *
     * @param id
     * @return
     */
    Map<String, Object> getDepartmentById(Integer id);
}
