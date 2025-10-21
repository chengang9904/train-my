package com.jiawa.train.common.controller;


import com.jiawa.train.common.exception.BusinessException;
import com.jiawa.train.common.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);


    /**
     * 所有的异常处理
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp ExceptionHandler(Exception e) {
        LOG.info("系统异常 ", e);
        CommonResp resp = new CommonResp<>();
        resp.setSuccess(false);
        resp.setMessage("系统出现异常，请联系管理员");
        return resp;
    }

    /**
     * 业务的异常统一处理
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp ExceptionHandler(BusinessException e) {
        LOG.info("业务异常: {}", e.getE().getDesc());
        CommonResp resp = new CommonResp<>();
        resp.setSuccess(false);
        resp.setMessage(e.getE().getDesc());
        return resp;
    }

    /**
     * 业务的异常统一处理
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp ExceptionHandler(BindException e) {
        LOG.info("校验异常: {}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        CommonResp resp = new CommonResp<>();
        resp.setSuccess(false);
        resp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return resp;
    }
}
