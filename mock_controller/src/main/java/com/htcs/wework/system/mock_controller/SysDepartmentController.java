package com.htcs.wework.system.mock_controller;

import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysDepartment;
import com.htcs.wework.system.model.dto.SysDepartmentSearchDto;
import com.htcs.wework.system.model.dto.TreeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Api(tags = "部门", description = "部门增删改查接口")
@RestController
@RequestMapping("mock/admin/department")
public class SysDepartmentController {
    @ApiOperation("部门树形")
    @GetMapping(value = "/treeDepartment", produces = "application/json")
    public ReturnStatus<List<TreeDto>> treeDepartment() {
        return ReturnStatus.success();
    }

    /**
     * 根据父节点获取子节点列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("查询部门父id下的部门列表")
    @GetMapping(value = "/listDepartmentByParentId", produces = "application/json")
    public ReturnStatus<PageBean<SysDepartment>> listDepartmentByParentId(@ApiParam(value = "父id") Integer salarybillId,
                                                                          @ApiParam(value = "部门名称") String departmentName,
                                                                          @ApiParam(value = "页码", required = true) @RequestParam int pageNum,
                                                                          @ApiParam(value = "页大小", required = true) @RequestParam int pageSize) {
        return ReturnStatus.success();
    }


    /**
     * 新增部门
     *
     * @param sysDepartment
     * @return
     */
    @ApiOperation("添加部门")
    @PostMapping(value = "/addDepartment", produces = "application/json")
    public ReturnStatus addDepartment(@ApiParam(value = "部门实体", required = true) @RequestBody SysDepartment sysDepartment) {
        return ReturnStatus.success();
    }

    /**
     * 根据id获取部门信息
     *
     * @param id
     * @return
     */
    @ApiOperation("查询部门id")
    @GetMapping(value = "/getDepartmentById", produces = "application/json")
    public ReturnStatus<Map<String, Object>> getDepartmentById(@ApiParam(value = "部门id", required = true) @RequestParam Long id) {
        return ReturnStatus.success();
    }

    /**
     * 根据id修改部门信息
     *
     * @param sysDepartment
     * @return
     */
    @ApiOperation("修改部门")
    @PostMapping(value = "/updateDepartment", produces = "application/json")
    public ReturnStatus updateDepartment(@ApiParam(value = "部门实体", required = true) @RequestBody SysDepartment sysDepartment) {
        return ReturnStatus.success();
    }

    /**
     * 根据id批量删除部门
     *
     * @param ids
     * @return
     */
    @ApiOperation("删除部门")
    @PostMapping(value = "/removeDepartment", produces = "application/json")
    public ReturnStatus removeDepartment(@ApiParam(value = "部门id, 多个部门以,分割", required = true) String ids) {
        return ReturnStatus.success();
    }
}
