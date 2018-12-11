package com.htcs.wework.system.controller;

import com.github.pagehelper.PageHelper;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysDepartment;
import com.htcs.wework.system.model.dto.SysDepartmentSearchDto;
import com.htcs.wework.system.model.dto.TreeDto;
import com.htcs.wework.system.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-10 16:02
 **/
@RestController
@RequestMapping("/admin/sysDepartment")
public class SysDepartmentController {
    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 一次性获取所有部门的树形结构（用户数据量小的情况）
     *
     * @return
     */
    @GetMapping(value = "/treeDepartment")
    public ReturnStatus<List<TreeDto>> treeDepartment() {
        List<TreeDto> list = sysDepartmentService.treeDepartment();
        return new ReturnStatus<>(list);
    }

    /**
     * 根据父节点获取子节点列表
     *
     * @param departmentSearchDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/listDepartmentByParentId")
    public ReturnStatus<PageBean<SysDepartment>> listDepartmentByParentId(SysDepartmentSearchDto departmentSearchDto,
                                                                          int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysDepartment> list = sysDepartmentService.listDepartmentByParentId(departmentSearchDto);
        PageBean<SysDepartment> pageBean = new PageBean<>(list);
        return new ReturnStatus<>(pageBean);
    }

    /**
     * 新增部门
     *
     * @param sysDepartment
     * @return
     */
    @PostMapping(value = "/addDepartment")
    public ReturnStatus addDepartment(SysDepartment sysDepartment) {
        sysDepartmentService.addDepartment(sysDepartment);
        return new ReturnStatus("添加成功！");
    }

    /**
     * 根据id获取部门信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getDepartmentById")
    public ReturnStatus<Map<String, Object>> getDepartmentById(Integer id) {
        Map<String, Object> sysDepartment = sysDepartmentService.getDepartmentById(id);
        return new ReturnStatus<>(sysDepartment);
    }

    /**
     * 根据id修改部门信息
     *
     * @param sysDepartment
     * @return
     */
    @PostMapping(value = "/updateDepartment")
    public ReturnStatus updateDepartment(SysDepartment sysDepartment) {
        sysDepartmentService.updateDepartment(sysDepartment);
        return new ReturnStatus("修改成功！");
    }

    /**
     * 根据id批量删除部门
     *
     * @param ids
     * @return
     */
    @PostMapping(value = "/removeDepartment")
    public ReturnStatus removeDepartment(String ids) {
        sysDepartmentService.removeDepartment(ids);
        return new ReturnStatus("删除成功！");
    }
}
