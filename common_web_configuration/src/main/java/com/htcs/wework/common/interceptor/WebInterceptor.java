package com.htcs.wework.common.interceptor;


import com.htcs.wework.common.conf.RequestUserHolder;
import com.htcs.wework.common.exception.ReturnStatusException;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.model.LoginWebUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaokaiyuan
 */
@Component
public class WebInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //获取登录的用户
        LoginWebUser loginWebUser = RequestUserHolder.currentWebUser();
        if (loginWebUser == null) {
            throw new ReturnStatusException(ReturnStatus.StatusCode.UNAUTHORIZED, "用户尚未登录，请重新登录！");
        }
        return true;
    }
}
