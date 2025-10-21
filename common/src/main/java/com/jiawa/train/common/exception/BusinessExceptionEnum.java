package com.jiawa.train.common.exception;

/**
 * @Author: chengang
 * @ClassName: BusinessExceptionEnum
 * @Version: v1.0.0
 * @Description:
 **/
public enum BusinessExceptionEnum {

    MEMBER_MOBILE_EXISTS("手机号已存在"),
    MEMBER_CODE_ERROR("验证码错误"),
    MEMBER_MOBILE_NOT_REG("手机号未注册");

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BusinessExceptionEnum{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
