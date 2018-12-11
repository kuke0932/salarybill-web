package com.htcs.wework.system.controller;

import com.github.pagehelper.PageHelper;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysFunction;
import com.htcs.wework.system.model.dto.SysRoleSearchDto;
import com.htcs.wework.system.model.dto.TreeDto;
import com.htcs.wework.system.service.SysFunctionService;
import com.htcs.wework.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-12 10:58
 **/
@RestController
@RequestMapping("/admin/sysFunction")
public class SysFunctionController {
    @Autowired
    private SysFunctionService sysFunctionService;
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 新增菜单
     *
     * @param sysFunction
     * @return
     */
    @PostMapping(value = "/addFunction")
    public ReturnStatus addFunction(SysFunction sysFunction) {
        sysFunctionService.addFunction(sysFunction);
        return new ReturnStatus("添加成功！");
    }

    /**
     * 根据id获取菜单信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/getFunctionById")
    public ReturnStatus<SysFunction> getFunctionById(Integer id) {
        SysFunction sysFunction = sysFunctionService.getFunctionById(id);
        return new ReturnStatus<>(sysFunction);
    }

    /**
     * 根据id修改菜单
     *
     * @param sysFunction
     * @return
     */
    @PostMapping(value = "/updateFunction")
    public ReturnStatus updateFunction(SysFunction sysFunction) {
        sysFunctionService.updateFunction(sysFunction);
        return new ReturnStatus("修改成功！");
    }

    /**
     * 根据id批量删除菜单
     *
     * @param ids
     * @return
     */
    @PostMapping(value = "/removeFunction")
    public ReturnStatus removeFunction(String ids) {
        sysFunctionService.removeFunction(ids);
        return new ReturnStatus("删除成功!");
    }

    /**
     * 获取菜单树形结构
     *
     * @return
     */
    @GetMapping(value = "/treeFunction")
    public ReturnStatus<List<TreeDto>> treeFunction() {
        List<TreeDto> list = sysFunctionService.treeFunction();
        return new ReturnStatus<>(list);
    }

    /**
     * 根据菜单id获取拥有该菜单的角色
     *
     * @param sysRoleSearchDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/listRoleByFunctionId")
    public ReturnStatus<PageBean<Map<String, Object>>> listRoleByFunctionId(SysRoleSearchDto sysRoleSearchDto,
                                                                            int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> list = sysRoleService.listRoleByFunctionId(sysRoleSearchDto);
        PageBean<Map<String, Object>> pageBean = new PageBean<>(list);
        return new ReturnStatus<>(pageBean);
    }

    /**
     * 给菜单添加角色
     *
     * @param functionId
     * @param roleIds
     * @return
     */
    @PostMapping(value = "/addRoleToFunction")
    public ReturnStatus addRoleToFunction(Integer functionId, String roleIds) {
        sysFunctionService.addRoleToFunction(functionId, roleIds);
        return new ReturnStatus("添加成功！");
    }

    /**
     * 删除菜单和角色的关联关系
     *
     * @param functionId
     * @param roleIds
     * @return
     */
    @PostMapping(value = "/removeRoleFromFunction")
    public ReturnStatus removeRoleFromFunction(Integer functionId, String roleIds) {
        sysFunctionService.removeRoleFromFunction(functionId, roleIds);
        return new ReturnStatus("删除成功！");
    }
}
