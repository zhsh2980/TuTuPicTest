package com.zhangshan.guibai.tutupictest.utils;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

    
    public class ToastUtil {
        private static Toast mToast;
        private static Handler mhandler = new Handler();
        private static Runnable r = new Runnable() {
            public void run() {
                mToast.cancel();
            };
        };
     
        public static void showToast(Context context, String text) {
            mhandler.removeCallbacks(r);
            if (null != mToast) {
                mToast.setText(text);
            } else {
                mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            }
            mhandler.postDelayed(r, 5000);
            mToast.show();
        }
     
        public static void showToast(Context context, int strId) {
            showToast(context, context.getString(strId));
        }
    }
    
    
    
