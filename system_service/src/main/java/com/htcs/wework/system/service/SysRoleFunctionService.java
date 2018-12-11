package com.htcs.wework.system.service;


import com.htcs.wework.system.model.SysFunction;

import java.util.List;

/**
 * @author zhaokaiyuan
 * @create 2018-01-10 14:50
 **/
public interface SysRoleFunctionService {

    List<SysFunction> listFunctionsByRoleIds(List roleIds);
}
