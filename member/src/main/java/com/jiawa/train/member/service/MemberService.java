package com.jiawa.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.jiawa.train.common.exception.BusinessException;
import com.jiawa.train.common.exception.BusinessExceptionEnum;
import com.jiawa.train.common.resp.MemberLoginResp;
import com.jiawa.train.common.util.SnowUtil;
import com.jiawa.train.member.domain.Member;
import com.jiawa.train.member.domain.MemberExample;
import com.jiawa.train.member.mapper.MemberMapper;
import com.jiawa.train.member.req.MemberLoginReq;
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
        Member member = selectMemberByMobile(mobile);

        // int x = 1 / 0;

        if (ObjectUtil.isNotNull(member)) {
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
        Member member = selectMemberByMobile(mobile);

        if (ObjectUtil.isNull(member)) {
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

    /**
     * 登录
     * @param req
     * @return
     */
    public MemberLoginResp login(MemberLoginReq req) {
        String mobile = req.getMobile();
        String code = req.getCode();
        Member memberDB = selectMemberByMobile(mobile);

        if (ObjectUtil.isNull(memberDB)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_NOT_REG);
        }

        // 校验验证码
        if (!"1111".equals(code)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_CODE_ERROR);
        }

        MemberLoginResp resp = new MemberLoginResp();
        BeanUtil.copyProperties(memberDB, resp);
        return resp;
    }

    private Member selectMemberByMobile(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
