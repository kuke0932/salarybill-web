package com.htcs.wework.system.service;


import com.htcs.wework.system.model.SysFunction;
import com.htcs.wework.system.model.dto.TreeDto;

import java.util.List;

/**
 * @author zhaokaiyuan
 * @create 2018-01-11 16:03
 **/
public interface SysFunctionService {

    /**
     * 新增菜单
     *
     * @param sysFunction 菜单实体类
     */
    void addFunction(SysFunction sysFunction);

    /**
     * 根据id修改菜单
     *
     * @param sysFunction 菜单实体类
     */
    void updateFunction(SysFunction sysFunction);

    /**
     * 根据id批量删除菜单
     *
     * @param ids 要删除的菜单id，多个id中间以“,”隔开
     */
    void removeFunction(String ids);

    /**
     * 根据id获取菜单信息
     *
     * @param id 要删除的菜单id，多个id中间以“,”隔开
     * @return
     */
    SysFunction getFunctionById(Integer id);

    /**
     * 获取菜单的树形结构
     *
     * @return
     */
    List<TreeDto> treeFunction();

    /**
     * 给菜单添加角色
     *
     * @param functionId 菜单id
     * @param roleIds    角色id，多个id中间以“,”隔开
     */
    void addRoleToFunction(Integer functionId, String roleIds);

    /**
     * 删除菜单和角色的关联关系
     *
     * @param functionId 菜单id
     * @param roleIds    角色id，多个id中间以“,”隔开
     */
    void removeRoleFromFunction(Integer functionId, String roleIds);
}
