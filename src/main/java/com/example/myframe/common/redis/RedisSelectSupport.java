package com.example.myframe.common.redis;

/**
 * @author zxp ThreadLocal 多线程共享变量
 */
public class RedisSelectSupport {

    private static final ThreadLocal<Integer> SELECT_CONTEXT = new ThreadLocal<>();

    public static void select(int db) {
        SELECT_CONTEXT.set(db);
    }

    public static Integer getSelect() {
        return SELECT_CONTEXT.get();
    }
}
