package com.jiawa.train.member.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author: chengang
 * @ClassName: MemberRegisterReq
 * @Version: v1.0.0
 * @Description:
 **/
@Data
public class MemberRegisterReq {

    @NotBlank(message = "【手机号】不能为空")
    private String mobile;
}
