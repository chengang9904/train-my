package com.jiawa.train.common.controller;


import com.jiawa.train.common.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp ExceptionHandler(Exception e) throws Exception {
        LOG.info("系统异常 ", e);
        CommonResp resp = new CommonResp<>();
        resp.setSuccess(false);
        resp.setMessage(e.getMessage());
        return resp;
    }

}
