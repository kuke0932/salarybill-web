package com.htcs.wework.system.controller;

import com.google.common.base.Preconditions;
import com.htcs.wework.common.CacheConstans;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.model.*;
import com.htcs.wework.common.util.SingletonLoginUtils;
import com.htcs.wework.common.util.cache.CacheUtils;
import com.htcs.wework.common.util.token.JWTokenUtils;
import com.htcs.wework.system.model.*;
import com.htcs.wework.system.model.dto.RouteDto;
import com.htcs.wework.system.service.SysRoleFunctionService;
import com.htcs.wework.system.service.SysRoleUserService;
import com.htcs.wework.system.service.SysUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class SysLoginController {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysRoleUserService sysRoleUserService;
    @Autowired
    SysRoleFunctionService sysRoleFunctionService;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public ReturnStatus login(String username, String password) throws Exception {

        Preconditions.checkArgument(StringUtils.isNotEmpty(username), "登录名不能为空");
        Preconditions.checkArgument(StringUtils.isNotEmpty(password), "密码不能为空");

        SysUser sysUser = sysUserService.getUserByLoginName(username);
        Preconditions.checkNotNull(sysUser, "用户名不存在，请注册！");

        String salt = sysUser.getSalt();
        String decryptPassWord = password;
        String hashPassword = DigestUtils.md5Hex(salt + decryptPassWord);
        Preconditions.checkArgument(hashPassword.equals(sysUser.getLoginPwd()), "用户名或密码错误，请重新输入！");

        String userKey = username + ".sys";
        String token = JWTokenUtils.createToken(userKey);

        List<SysRole> roleListByUserId = sysRoleUserService.listRolesBySysUserId(sysUser.getId());
        Preconditions.checkArgument(roleListByUserId.size() != 0, "当前用户没有权限，请联系管理员添加权限！");
        List<Integer> roleIds = roleListByUserId.stream().map(LoginSysRole::getId).collect(Collectors.toList());
        List<SysFunction> functionListByRoleList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(roleListByUserId)) {
            functionListByRoleList = sysRoleFunctionService.listFunctionsByRoleIds(roleIds);
        }

        List<SysDepartment> departmentList = sysUserService.listDepartmentByUserId(sysUser.getId());
        List<SysGroup> groupList = sysUserService.listGroupByUserId(sysUser.getId());

        LoginSysUserMsg loginSysUserMsg = new LoginSysUserMsg();
        loginSysUserMsg.setUser(sysUser.copyOf());
        loginSysUserMsg.setLoginSysRoleList(roleListByUserId.stream().map(LoginSysRole::copyOf).collect(Collectors.toList()));
        loginSysUserMsg.setLoginSysFunctionList(functionListByRoleList.stream().map(LoginSysFunction::copyOf).collect(Collectors.toList()));
        loginSysUserMsg.setLoginSysGroupList(groupList.stream().map(LoginSysGroup::copyOf).collect(Collectors.toList()));
        loginSysUserMsg.setLoginSysDepartmentList(departmentList.stream().map(LoginSysDepartment::copyOf).collect(Collectors.toList()));

        CacheUtils.getInstance(CacheUtils.CacheType.REDIS).put(CacheConstans.SYSTEM_CACHE, userKey, loginSysUserMsg, 60, TimeUnit.MINUTES);

        return new ReturnStatus<>(ReturnStatus.StatusCode.OK, "登录成功", token);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @PostMapping("/logout")
    public ReturnStatus logout() {
        try {
            LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
            String userKey = loginSysUser.getLoginName() + ".sys";
            CacheUtils.getInstance(CacheUtils.CacheType.REDIS).remove(CacheConstans.SYSTEM_CACHE, userKey);
        } finally {
            return new ReturnStatus(ReturnStatus.StatusCode.OK, "");
        }
    }

    /*@GetMapping("/functionListTree")
    public LoginSysFunction functionListTree(HttpServletRequest request) {
        LoginSysFunction loginSysFunction = SingletonLoginUtils.getLoginFunctionTreeByHeader(request, 1);
        return loginSysFunction;
    }*/

    /**
     * 生成路由
     *
     * @return
     */
    @GetMapping("/generateRoutes")
    public ReturnStatus<List<RouteDto>> generateRoutes() {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        String userKey = loginSysUser.getLoginName() + ".sys";
        LoginSysUserMsg loginSysUserMsg = (LoginSysUserMsg) CacheUtils.getInstance(CacheUtils.CacheType.REDIS).get(CacheConstans.SYSTEM_CACHE, userKey);
        List<LoginSysFunction> loginSysFunctionList = loginSysUserMsg.getLoginSysFunctionList();
        List<RouteDto> routeDtos = new ArrayList<>();
        LoginSysFunction loginSysFunction = SingletonLoginUtils.initFunctionTree(loginSysFunctionList, 1);

        if (loginSysFunction != null && loginSysFunction.getChildrenList() != null) {
            loginSysFunction.getChildrenList().forEach(t -> {
                routeDtos.add(buildRoutes(t));
            });
        }

        return new ReturnStatus<>(routeDtos);
    }

    private RouteDto buildRoutes(LoginSysFunction loginSysFunction) {
        Byte functionType = loginSysFunction.getFunctionType();
        String functionUrl = loginSysFunction.getFunctionUrl();
        RouteDto routeDto = new RouteDto();
        routeDto.setChildren(new ArrayList<>());
        routeDto.setPath(functionUrl);
        routeDto.setName(loginSysFunction.getFunctionName());
        routeDto.setComponent(functionUrl);
        routeDto.setHidden(false);
        routeDto.setMeta(
                RouteDto.Meta.builder()
                        .setIcon(loginSysFunction.getIconStyle())
                        .setTitle(loginSysFunction.getFunctionName())
                        .setFunctionType(loginSysFunction.getFunctionType())
                        .setCode(loginSysFunction.getFunctionCode())
                        .setNoTab(loginSysFunction.getIsVisible() == 0)
        );
        // 按钮
        if (functionType == 2) {
            routeDto.setHidden(true);
        }
        if (loginSysFunction.getChildrenList() != null) {
            loginSysFunction.getChildrenList().forEach(t -> {
                routeDto.getChildren().add(buildRoutes(t));
            });
        }
        return routeDto;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/getUserInfo")
    public ReturnStatus getLoginMsg() {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        HashMap<String, java.io.Serializable> map = new HashMap<>();

        String userKey = loginSysUser.getLoginName() + ".sys";
        LoginSysUserMsg o = (LoginSysUserMsg) CacheUtils.getInstance(CacheUtils.CacheType.REDIS).get(CacheConstans.SYSTEM_CACHE, userKey);

        map.put("id", loginSysUser.getId());
        map.put("name", loginSysUser.getLoginName());
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction", loginSysUser.getUserName());
        return new ReturnStatus<>(map);
    }
}
