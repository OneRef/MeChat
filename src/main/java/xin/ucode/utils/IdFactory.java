package xin.ucode.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class IdFactory {
    private static final Snowflake SNOWFLAKE = IdUtil.getSnowflake(1L, 1L);

    private IdFactory() {
    }

    public static Long next() {
        return SNOWFLAKE.nextId();
    }
}