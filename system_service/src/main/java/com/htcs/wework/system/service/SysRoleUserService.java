package com.htcs.wework.system.service;

import com.htcs.wework.system.model.SysRole;

import java.util.List;

/**
 * @author zhaokaiyuan
 * @create 2018-01-10 14:57
 **/
public interface SysRoleUserService {

    List<SysRole> listRolesBySysUserId(Integer userId);
}
