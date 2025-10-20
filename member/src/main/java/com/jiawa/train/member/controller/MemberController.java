package com.jiawa.train.member.controller;

import com.jiawa.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: chengang
 * @ClassName: MemberController
 * @Version: v1.0.0
 * @Description:
 **/
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public Integer count() {
        return memberService.count();
    }

    @PostMapping("/register")
    public long register(String mobile) {
        return memberService.register(mobile);
    }
}
