package com.htcs.wework.system.service.impl;

import com.htcs.wework.system.dao.SysFunctionMapper;
import com.htcs.wework.system.model.SysFunction;
import com.htcs.wework.system.service.SysRoleFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaokaiyuan
 * @create 2018-01-10 15:34
 **/
@Service
public class SysRoleFunctionServiceImpl implements SysRoleFunctionService {

    @Autowired
    SysFunctionMapper sysFunctionMapper;

    @Override
    public List<SysFunction> listFunctionsByRoleIds(List roleIds) {

        return sysFunctionMapper.listFunctionsByRoleIds(roleIds);
    }
}
