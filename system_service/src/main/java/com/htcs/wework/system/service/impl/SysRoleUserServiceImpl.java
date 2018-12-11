package com.htcs.wework.system.service.impl;

import com.htcs.wework.system.dao.SysRoleMapper;
import com.htcs.wework.system.model.SysRole;
import com.htcs.wework.system.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaokaiyuan
 * @create 2018-01-10 15:33
 **/
@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> listRolesBySysUserId(Integer userId) {
        return sysRoleMapper.listBySysUserId(userId);
    }
}
