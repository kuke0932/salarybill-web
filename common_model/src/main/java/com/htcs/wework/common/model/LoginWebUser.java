package com.htcs.wework.common.model;


import org.springframework.beans.BeanUtils;

import me.chanjar.weixin.cp.bean.WxCpUser;

import java.io.Serializable;


/**
 * 前台用户实体
 */
public class LoginWebUser extends WxCpUser implements Serializable {
    private static final long serialVersionUID = -5547106444408050715L;
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String loginPwd;
    /**
     * 盐
     */
    private String salt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LoginWebUser copyOf() {
        LoginWebUser user = new LoginWebUser();
        BeanUtils.copyProperties(this, user);
        return user;
    }

}
