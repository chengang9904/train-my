package com.jiawa.train.common.exception;

/**
 * @Author: chengang
 * @ClassName: BusinessExceptionEnum
 * @Version: v1.0.0
 * @Description:
 **/
public enum BusinessExceptionEnum {

    MEMBER_MOBILE_EXISTS("手机号已存在");

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
