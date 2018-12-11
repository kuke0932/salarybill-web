package com.htcs.wework.common.conf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.htcs.wework.common.CacheConstans;
import com.htcs.wework.common.util.cache.CacheUtils;
import com.htcs.wework.common.util.token.JWTokenUtils;
import com.htcs.wework.common.model.LoginSysUserMsg;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by htcs on 2017/7/26.
 */
//@ControllerAdvice
public class HeaderModifierAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    //

    /**
     * 防重放攻击 一个token最多使用X次 (如果x为1，页面ajax请求需要一个一个进行)
     * 或者 jwt jti放随机数
     *
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        try {
            String token = request.getHeaders().get(CacheConstans.X_AUTH_TOKEN).get(0);
            String claims = token.split(".")[1];
            JSONObject json = JSON.parseObject(claims, JSONObject.class);
            String subject = json.getString("sub");

            String newToken = JWTokenUtils.createToken(subject);

            response.getHeaders().set(CacheConstans.X_AUTH_TOKEN, newToken);
            LoginSysUserMsg loginSysUserMsg = (LoginSysUserMsg) CacheUtils.getInstance(CacheUtils.CacheType.REDIS).get(CacheConstans.SYSTEM_CACHE, subject);
            CacheUtils.getInstance(CacheUtils.CacheType.REDIS).remove(CacheConstans.SYSTEM_CACHE, subject);
            CacheUtils.getInstance(CacheUtils.CacheType.REDIS).put(CacheConstans.SYSTEM_CACHE, subject, loginSysUserMsg);
        } catch (Exception e) {

        }
        return body;
    }
}
