package com.jiawa.train.member.service;

import cn.hutool.core.collection.CollectionUtil;
import com.jiawa.train.member.domain.Member;
import com.jiawa.train.member.domain.MemberExample;
import com.jiawa.train.member.mapper.MemberMapper;
import com.jiawa.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chengang
 * @ClassName: MemberService
 * @Version: v1.0.0
 * @Description:
 **/
@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);

        if (CollectionUtil.isNotEmpty(list)) {
            // return list.get(0).getId();
            throw new RuntimeException("该手机号已注册");
        }

        Member record = new Member();
        record.setId(System.currentTimeMillis());
        record.setMobile(mobile);

        memberMapper.insert(record);
        return record.getId();
    }
}
