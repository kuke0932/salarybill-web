package com.htcs.wework.system.service.impl;

import com.google.common.base.Preconditions;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.exception.ReturnStatusException;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.system.dao.SysDepartmentMapper;
import com.htcs.wework.system.model.SysDepartment;
import com.htcs.wework.system.model.dto.SysDepartmentSearchDto;
import com.htcs.wework.system.model.dto.TreeDto;
import com.htcs.wework.system.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dragon
 * @create 2018-01-10 16:07
 **/
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public List<TreeDto> treeDepartment() {
        List<TreeDto> list = sysDepartmentMapper.listDepartment();
        List<TreeDto> departmentList = new ArrayList<>();
        for (TreeDto sysDepartment : list) {
            if (null == sysDepartment.getParentId()) {
                departmentList.add(sysDepartment);
            }
        }
        for (TreeDto sysDepartment: departmentList) {
            sysDepartment.setChildren(getChild(sysDepartment.getId(), list));
        }
        return departmentList;
    }

    private List<TreeDto> getChild(Integer id, List<TreeDto> list) {
        List<TreeDto> childList = new ArrayList<>();
        for (TreeDto sysDepartment: list) {
            if (Objects.equals(id, sysDepartment.getParentId())) {
                childList.add(sysDepartment);
            }
        }
        for (TreeDto sysDepartment: childList) {
            sysDepartment.setChildren(getChild(sysDepartment.getId(), list));
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    @Override
    public List<SysDepartment> listDepartmentByParentId(SysDepartmentSearchDto departmentSearchDto) {
        return sysDepartmentMapper.listDepartmentByParentId(departmentSearchDto);
    }

    @Override
    public void addDepartment(SysDepartment sysDepartment) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        sysDepartment.setCreateBy(loginSysUser.getId());
        sysDepartment.setCreateName(loginSysUser.getUserName());
        sysDepartment.setCreateTime(new Date());
        sysDepartmentMapper.insertSelective(sysDepartment);
    }

    @Override
    public void updateDepartment(SysDepartment sysDepartment) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        if (sysDepartment.getId() == 1) {
            throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "该部门不能修改！");
        }
        sysDepartment.setUpdateBy(loginSysUser.getId());
        sysDepartment.setUpdateName(loginSysUser.getUserName());
        sysDepartment.setUpdateTime(new Date());
        sysDepartmentMapper.updateByPrimaryKeySelective(sysDepartment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeDepartment(String ids) {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::valueOf).collect(Collectors.toList());

        idList.forEach(v -> {
                    if (v == 1) {
                        throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "总部门不能删除！");
                    }
                    int count = sysDepartmentMapper.countByParentId(v);
                    if (count > 0) {
                        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(v);
                        throw new IllegalArgumentException(sysDepartment.getDepartmentName() + "尚有子部门存在，请先删除子部门！");
                    }
                });
        sysDepartmentMapper.logicalDeleteByIds(loginSysUser.getId(), loginSysUser.getUserName(), idList);
    }

    @Override
    public Map<String, Object> getDepartmentById(Integer id) {
        return sysDepartmentMapper.getDepartmentById(id);
    }
}
