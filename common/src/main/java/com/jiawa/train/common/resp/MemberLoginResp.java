package com.jiawa.train.common.resp;

import lombok.Data;

/**
 * @Author: chengang
 * @ClassName: MemberLoginResp
 * @Version: v1.0.0
 * @Description:
 **/
@Data
public class MemberLoginResp {

    private Long id;

    private String mobile;

    private String token;
}
