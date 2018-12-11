package com.htcs.wework.common.util;

import com.htcs.wework.common.Common;
import com.htcs.wework.common.model.BaseEnum;
import com.htcs.wework.common.util.cache.CacheUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @author zhaokaiyuan
 * @create 2017-10-24 16:54
 **/
public class SmsUtil {

    static final String URL = "http://v.juhe.cn/sms/send";

    public static String send(String mobile, SmsTemplate smsTemplate) throws IOException {
        String onlyNumber = RandomStringUtils.randomNumeric(6);
        HashMap map = new HashMap();
        map.put("mobile", mobile);
        map.put("tpl_id", smsTemplate.getId());
        map.put("tpl_value", URLEncoder.encode(String.format(smsTemplate.getContent(), onlyNumber), "utf-8"));
        map.put("key", "");
        CacheUtils.getInstance(CacheUtils.CacheType.REDIS).put(mobile + smsTemplate.getVerifyCodeType(), onlyNumber);
        String post = HttpClientUtils.post(URL, map, "utf-8");
        return post;
    }


    public enum SmsTemplate implements BaseEnum {
        REGISTER("REGISTER", "53087", "#code#=%s", Common.VerifyCodeType.REGISTER),
        CHANGE_MOBILE("CHANGE_MOBILE", "53098", "#code#=%s", Common.VerifyCodeType.CHANGE_MOBILE),
        FORGET_PASSWORD("FORGET_PASSWORD", "53090", "#code#=%s", Common.VerifyCodeType.FORGET_PASSWORD),
        CHANGE_PASSWORD("CHANGE_PASSWORD", "53098", "#code#=%s", Common.VerifyCodeType.CHANGE_PASSWORD);

        private String id;
        private String value;
        private String content;
        private Common.VerifyCodeType verifyCodeType;

        SmsTemplate(String value, String id, String content, Common.VerifyCodeType verifyCodeType) {
            this.id = id;
            this.value = value;
            this.content = content;
            this.verifyCodeType = verifyCodeType;
        }

        public String getId() {
            return id;
        }

        @Override
        public String getValue() {
            return value;
        }

        public String getContent() {
            return content;
        }

        public Common.VerifyCodeType getVerifyCodeType() {
            return verifyCodeType;
        }

        @Override
        public String toString() {
            return "SmsTemplate{" +
                    "id='" + id + '\'' +
                    ", value='" + value + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}


