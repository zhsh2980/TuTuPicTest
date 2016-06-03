package com.zhangshan.guibai.tutupictest.base;

import android.app.Application;

import org.lasque.tusdk.core.TuSdk;

/**
 * Created by zhangshan on 16/5/31.
 */

public class BaseApplication extends Application {

    String key = "d358a6ecdd44d7fd-00-re9gp1";

    @Override
    public void onCreate() {
        super.onCreate();
        // 开发ID (请前往 http://tusdk.com 获取您的 APP 开发秘钥)
        TuSdk.init(this.getApplicationContext(), key);
        //为便于开发，可打开 TuSDK 的调试日志，在初始化方法的同一位置添加以下代码：
        //发布应用时请关闭日志。
        TuSdk.enableDebugLog(true);
    }
}
