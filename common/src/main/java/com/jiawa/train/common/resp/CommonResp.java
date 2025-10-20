package com.jiawa.train.common.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chengang
 * @ClassName: CommonResp
 * @Version: v1.0.0
 * @Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResp<T> {

    private boolean success = true;

    private String message;

    private T content;

    public CommonResp(T content) {
        this.content = content;
    }
}
