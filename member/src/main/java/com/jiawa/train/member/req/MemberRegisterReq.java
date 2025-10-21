package com.jiawa.train.member.req;

import jakarta.validation.constraints.NotBlank;

/**
 * @Author: chengang
 * @ClassName: MemberRegisterReq
 * @Version: v1.0.0
 * @Description:
 **/
public class MemberRegisterReq {

    @NotBlank(message = "【手机号】不能为空")
    private String mobile;

    public MemberRegisterReq(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
