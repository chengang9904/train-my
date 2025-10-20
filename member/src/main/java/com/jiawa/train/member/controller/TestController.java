package com.jiawa.train.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chengang
 * @ClassName: TestController
 * @Version: v1.0.0
 * @Description:
 **/
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world12323";
    }
}
