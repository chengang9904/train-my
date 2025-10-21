package com.jiawa.train.common.exception;

import lombok.Data;

/**
 * @Author: chengang
 * @ClassName: BusinessException
 * @Version: v1.0.0
 * @Description:
 **/
@Data
public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum e;

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        this.e = businessExceptionEnum;
    }
}
