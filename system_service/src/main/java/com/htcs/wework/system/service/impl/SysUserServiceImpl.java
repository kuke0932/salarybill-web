package com.htcs.wework.system.service.impl;

import com.google.common.base.Preconditions;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.exception.ReturnStatusException;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.common.util.RandomStrUtils;
import com.htcs.wework.system.dao.SysDepartmentUserMapper;
import com.htcs.wework.system.dao.SysGroupUserMapper;
import com.htcs.wework.system.dao.SysUserMapper;
import com.htcs.wework.system.model.SysDepartment;
import com.htcs.wework.system.model.SysDepartmentUser;
import com.htcs.wework.system.model.SysGroup;
import com.htcs.wework.system.model.SysUser;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import com.htcs.wework.system.service.SysUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dragon
 * @create 2018-01-10 9:04
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysDepartmentUserMapper sysDepartmentUserMapper;
	@Autowired
	private SysGroupUserMapper sysGroupUserMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean addUser(SysUser sysUser) {
		LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
		Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());
		int count = sysUserMapper.countByLoginName(sysUser.getLoginName());
		if (count > 0) {
			return false;
		}

		Date date = new Date();
		String salt = RandomStrUtils.generateStr(6);
		sysUser.setSalt(salt);
		sysUser.setLoginPwd(DigestUtils.md5Hex(salt + sysUser.getLoginPwd()));
		sysUser.setCreateBy(loginSysUser.getId());
		sysUser.setCreateName(loginSysUser.getUserName());
		sysUser.setCreateTime(date);
		sysUserMapper.insertSelective(sysUser);
		// 插入部门和用户关联关系
		String departmentIds = sysUser.getDepartmentIds();
		SysDepartmentUser departmentUser = new SysDepartmentUser();
		departmentUser.setUserId(sysUser.getId());
		departmentUser.setCreateBy(loginSysUser.getId());
		departmentUser.setCreateName(loginSysUser.getUserName());
		departmentUser.setCreateTime(date);
		Arrays.stream(departmentIds.split(","))
				.map(Integer::valueOf)
				.forEach(v -> {
					departmentUser.setDepartmentId(v);
					sysDepartmentUserMapper.insertSelective(departmentUser);
		});
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateUser(SysUser sysUser) {
		LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
		Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());
		if (sysUser.getId() == 1) {
			throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "该用户不能修改！");
		}

		Date date = new Date();
		sysUser.setUpdateBy(loginSysUser.getId());
		sysUser.setUpdateName(loginSysUser.getUserName());
		sysUser.setUpdateTime(date);
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
		// 修改部门和用户关联关系
		sysDepartmentUserMapper.deleteByUserId(sysUser.getId());
		SysDepartmentUser departmentUser = new SysDepartmentUser();
		departmentUser.setUserId(sysUser.getId());
		departmentUser.setUpdateBy(loginSysUser.getId());
		departmentUser.setUpdateName(loginSysUser.getUserName());
		departmentUser.setUpdateTime(date);
		String departmentIds = sysUser.getDepartmentIds();
		Arrays.stream(departmentIds.split(","))
				.map(Integer::valueOf)
				.forEach(v -> {
					departmentUser.setDepartmentId(v);
					sysDepartmentUserMapper.insertSelective(departmentUser);
				});
	}

	@Override
	public SysUser getUserById(Integer id) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
		List<Integer> list = sysDepartmentUserMapper.listDepartmentIdByUserId(id);
		sysUser.setDepartmentIdList(list);
		return sysUser;
	}

	@Override
	public List<Map<String, Object>> listUser(SysUserSearchDto userSearchDto) {
		LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
		if (loginSysUser.getId() != 1) {
			return sysUserMapper.listUserNotAdmin(userSearchDto);
		}
		return sysUserMapper.listUser(userSearchDto);
	}

	@Override
    @Transactional(rollbackFor = Exception.class)
	public void removeUser(String ids) {
		LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
		Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

		// 获取id集合
		List<Integer> idList = Arrays.stream(ids.split(","))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		idList.forEach(id -> {
			if (id == 1) {
				throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "该用户不能删除！");
			}
		});

		Integer userId = loginSysUser.getId();
		String userName = loginSysUser.getUserName();

		sysUserMapper.logicalDeleteByIds(userId, userName, idList);
	}

	@Override
	public void updateStatus(SysUser sysUser) {
		LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
		Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

		if (sysUser.getId() == 1) {
			throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "该用户不能修改！");
		}

		sysUser.setUpdateBy(loginSysUser.getId());
		sysUser.setUpdateName(loginSysUser.getUserName());
		sysUser.setUpdateTime(new Date());

		sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	@Override
	public void resetPassword(SysUser sysUser) {
		LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
		Preconditions.checkNotNull(loginSysUser, new ReturnStatus.Builder().status(ReturnStatus.StatusCode.UNAUTHORIZED).message("登录超时，请重新登录！").build());

		if (sysUser.getId() == 1) {
			throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "该用户不能修改！");
		}

		String salt = RandomStrUtils.generateStr(6);
		sysUser.setSalt(salt);
		sysUser.setLoginPwd(DigestUtils.md5Hex(salt + sysUser.getLoginPwd()));
		sysUser.setUpdateBy(loginSysUser.getId());
		sysUser.setUpdateName(loginSysUser.getUserName());
		sysUser.setUpdateTime(new Date());
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	@Override
	public List<SysDepartment> listDepartmentByUserId(Integer id) {
		return sysDepartmentUserMapper.listDepartmentByUserId(id);
	}

	@Override
    public SysUser getUserByLoginName(String loginName) {

        return sysUserMapper.selectByLoginName(loginName);
    }

	@Override
	public List<SysGroup> listGroupByUserId(Integer userId) {
		return sysGroupUserMapper.listGroupByUserId(userId);
	}
}
