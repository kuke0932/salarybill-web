package com.htcs.wework.system.mock_controller;

import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysFunction;
import com.htcs.wework.system.model.dto.SysRoleSearchDto;
import com.htcs.wework.system.model.dto.TreeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "菜单", description = "菜单增删改查接口")
@RestController
@RequestMapping("mock/admin/sysFunction")
public class SysFunctionController {

    @ApiOperation("添加菜单")
    @PostMapping(value = "/addFunction", produces = "application/json")
    public ReturnStatus addFunction(@ApiParam(value = "菜单实体", required = true) @RequestBody SysFunction sysFunction) {
        return ReturnStatus.success();
    }

    /**
     * 根据id获取菜单信息
     *
     * @param id
     * @return
     */
    @ApiOperation("获取菜单内容")
    @GetMapping(value = "/getFunctionById", produces = "application/json")
    public ReturnStatus<SysFunction> getFunctionById(@ApiParam(value = "菜单类型", required = true) @RequestParam Long id) {
        return ReturnStatus.success();
    }

    /**
     * 根据id修改菜单
     *
     * @param sysFunction
     * @return
     */
    @ApiOperation("修改菜单")
    @PostMapping(value = "/updateFunction", produces = "application/json")
    public ReturnStatus updateFunction(@ApiParam(value = "菜单实体", required = true) @RequestBody SysFunction sysFunction) {
        return ReturnStatus.success();
    }

    /**
     * 根据id批量删除菜单
     *
     * @param ids
     * @return
     */
    @ApiOperation("删除菜单")
    @PostMapping(value = "/removeFunction", produces = "application/json")
    public ReturnStatus removeFunction(@ApiParam(value = "菜单id,多个菜单以,分割", required = true) @RequestParam String ids) {
        return ReturnStatus.success();
    }

    /**
     * 获取菜单树形结构
     *
     * @return
     */
    @GetMapping(value = "/treeFunction")
    @ApiOperation(value = "树形菜单", produces = "application/json")
    public ReturnStatus<List<TreeDto>> treeFunction() {
        return ReturnStatus.success();
    }

    /**
     * 根据菜单id获取拥有该菜单的角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/listRoleByFunctionId")
    @ApiOperation(value = "根据菜单id查询角色", produces = "application/json")
    public ReturnStatus<PageBean<Map<String, Object>>> listRoleByFunctionId(@ApiParam(value = "菜单id") Integer functionId,
                                                                            @ApiParam(value = "区分是查看角色还是添加角色（1查看角色列表，2菜单添加角色）") Integer showOrAdd,
                                                                            @ApiParam(value = "角色名") String roleName,
                                                                            @ApiParam(value = "角色值") String roleValue,
                                                                            @ApiParam(value = "页码", required = true) @RequestParam int pageNum,
                                                                            @ApiParam(value = "页大小", required = true) @RequestParam int pageSize) {
        return ReturnStatus.success();
    }

    /**
     * 给菜单添加角色
     *
     * @param functionId
     * @param roleIds
     * @return
     */
    @PostMapping(value = "/addRoleToFunction")
    @ApiOperation(value = "菜单添加角色", produces = "application/json")
    public ReturnStatus addRoleToFunction(@ApiParam(value = "菜单id", required = true) @RequestParam Long functionId,
                                          @ApiParam(value = "角色id, 多个角色以,分割", required = true) @RequestParam String roleIds) {
        return ReturnStatus.success();
    }

    /**
     * 删除菜单和角色的关联关系
     *
     * @param functionId
     * @param roleIds
     * @return
     */
    @PostMapping(value = "/removeRoleFromFunction")
    @ApiOperation(value = "删除菜单和角色关联关系", produces = "application/json")
    public ReturnStatus removeRoleFromFunction(@ApiParam(value = "菜单id", required = true) @RequestParam Long functionId,
                                               @ApiParam(value = "角色id, 多个角色以,分割", required = true) @RequestParam String roleIds) {
        return ReturnStatus.success();
    }
}
