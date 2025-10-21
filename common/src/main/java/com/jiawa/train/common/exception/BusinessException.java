package com.jiawa.train.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: chengang
 * @ClassName: BusinessException
 * @Version: v1.0.0
 * @Description:
 **/
@Setter
@Getter
public class BusinessException extends RuntimeException {

    private BusinessExceptionEnum e;

    public BusinessException(BusinessExceptionEnum businessExceptionEnum) {
        this.e = businessExceptionEnum;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
