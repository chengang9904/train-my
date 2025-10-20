package com.jiawa.train.member.controller;

import com.jiawa.train.common.resp.CommonResp;
import com.jiawa.train.member.req.MemberRegisterReq;
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
    public CommonResp<Integer> count() {
        CommonResp<Integer> resp = new CommonResp<>();
        resp.setContent(memberService.count());
        return resp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(MemberRegisterReq req) {
        CommonResp<Long> resp = new CommonResp<>();
        resp.setContent(memberService.register(req));
        return resp;
    }
}
