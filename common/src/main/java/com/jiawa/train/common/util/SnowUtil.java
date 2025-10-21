package com.jiawa.train.common.util;

import cn.hutool.core.util.IdUtil;

/**
 * @Author: chengang
 * @ClassName: SnowUtil
 * @Version: v1.0.0
 * @Description:
 **/
public class SnowUtil {

    private static long dataCenterId = 1;

    private static long workId = 1;

    public static long getSnowFlakeId() {
        return IdUtil.getSnowflake(workId, dataCenterId).nextId();
    }

    public static String getSnowFlakeIdStr() {
        return IdUtil.getSnowflake(workId, dataCenterId).nextIdStr();
    }
}
