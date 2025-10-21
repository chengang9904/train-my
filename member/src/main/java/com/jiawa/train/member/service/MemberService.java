package com.jiawa.train.member.service;

import cn.hutool.core.collection.CollectionUtil;
import com.jiawa.train.common.exception.BusinessException;
import com.jiawa.train.common.exception.BusinessExceptionEnum;
import com.jiawa.train.common.util.SnowUtil;
import com.jiawa.train.member.domain.Member;
import com.jiawa.train.member.domain.MemberExample;
import com.jiawa.train.member.mapper.MemberMapper;
import com.jiawa.train.member.req.MemberRegisterReq;
import com.jiawa.train.member.req.MemberSendCodeReq;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);

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

        // int x = 1 / 0;

        if (CollectionUtil.isNotEmpty(list)) {
            // return list.get(0).getId();
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXISTS);
        }

        Member record = new Member();
        record.setId(SnowUtil.getSnowFlakeId());
        record.setMobile(mobile);

        memberMapper.insert(record);
        return record.getId();
    }

    /**
     * 发送短信
     * @param req
     * @return
     */
    public void sendCode(MemberSendCodeReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);

        if (CollectionUtil.isEmpty(list)) {
            LOG.info("手机号未注册");
            Member record = new Member();
            record.setId(SnowUtil.getSnowFlakeId());
            record.setMobile(mobile);
            memberMapper.insert(record);
        } else {
            LOG.info("手机号已注册");
        }

        // 生成验证码
        // String code = RandomUtil.randomString(4);
        String code = "1111";
        // TODO: 保存到redis中

        // TODO: 发送验证码
        LOG.info("发送验证码：{}", code);
    }
}
