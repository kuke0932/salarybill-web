package com.htcs.wework.common.conf;


import com.htcs.wework.common.CacheConstans;
import com.htcs.wework.common.annotations.HasRole;
import com.htcs.wework.common.exception.ReturnStatusException;
import com.htcs.wework.common.model.LoginSysUser;
import com.htcs.wework.common.util.cache.CacheUtils;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.model.LoginSysRole;
import com.htcs.wework.common.model.LoginSysUserMsg;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
public class PermissionAOP {

    private static Logger logger = LoggerFactory.getLogger(PermissionAOP.class);

    @Pointcut("@annotation(com.htcs.wework.common.annotations.HasRole)")
    public void hasRole() {
        logger.debug(" has role");
    }


    @Around("hasRole()")
    public void beforeExec(ProceedingJoinPoint pjp) throws Throwable {
        LoginSysUser loginSysUser = RequestUserHolder.currentSysUser();
        if(loginSysUser == null) {
            throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "签名错误，请重新获取签名！");
        }

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        HasRole annotation = method.getAnnotation(HasRole.class);
        String[] roleValue = annotation.value();
        HasRole.Type type = annotation.type();

        LoginSysUserMsg loginMsg = (LoginSysUserMsg) CacheUtils.getInstance(CacheUtils.CacheType.REDIS).get(CacheConstans.SYSTEM_CACHE, loginSysUser.getLoginName() + ".sys");
        List<LoginSysRole> roleList = loginMsg.getLoginSysRoleList();

        boolean hasRole = true;
        LoginSysRole role = new LoginSysRole();
        for (int i = 0; i < roleValue.length; i++) {
            role.setRoleValue(roleValue[i]);
            if (!roleList.contains(role)) {
                hasRole = false;
                if (type.equals(HasRole.Type.AND)) {
                    break;
                }
            } else {
                if (type.equals(HasRole.Type.OR)) {
                    break;
                }
            }
        }
        if (hasRole) {
            pjp.proceed();
        } else {
            throw new ReturnStatusException(ReturnStatus.StatusCode.FORBIDDEN, "对不起，您没有权限访问！");
        }

    }

}
