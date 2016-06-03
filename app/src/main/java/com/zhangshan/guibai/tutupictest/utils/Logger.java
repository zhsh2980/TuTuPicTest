package com.zhangshan.guibai.tutupictest.utils;

import android.support.v4.BuildConfig;
import android.util.Log;

/**
 * 调试程序信息,通过双击log日志，跳转到源码相应的位置
 */
public class Logger {

    public static void d(String tag, String log) {
        if (BuildConfig.DEBUG) {
            StackTraceElement invoker = getInvoker();
            Log.d(tag, getLogString(invoker, log));
        }
    }

    public static void v(String tag, String log) {
        if (BuildConfig.DEBUG) {
            StackTraceElement invoker = getInvoker();
            Log.v(tag, getLogString(invoker, log));
        }
    }

    public static void i(String tag, String log) {
        if (BuildConfig.DEBUG) {
            StackTraceElement invoker = getInvoker();
            Log.i(tag, getLogString(invoker, log));
        }
    }

    public static void e(String tag, String log) {
        if (BuildConfig.DEBUG) {
            StackTraceElement invoker = getInvoker();
            Log.e(tag, getLogString(invoker, log));
        }
    }

    public static void w(String tag, String log) {
        if (BuildConfig.DEBUG) {
            StackTraceElement invoker = getInvoker();
            Log.w(tag, getLogString(invoker, log));
        }
    }


    private static StackTraceElement getInvoker() {
        return Thread.currentThread().getStackTrace()[4];
    }

    private static String getLogString(StackTraceElement methodStack, String message) {
        String log = message;
        if (log == null) {
            log = "";
        }
        return callLogDetail(methodStack) + '\n' + log;
    }

    /**
     * Realization of double click jump events.
     *
     * @return
     */
    private static String callLogDetail(StackTraceElement methodStack) {
        String result = "at ";
        result += methodStack.getClassName() + ".";
        result += methodStack.getMethodName();
        result += "(" + methodStack.getFileName();
        result += ":" + methodStack.getLineNumber() + ") ";
        return result;
    }
}