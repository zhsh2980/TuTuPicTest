package com.zhangshan.guibai.tutupictest.base;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.zhangshan.guibai.tutupictest.R;

import java.lang.reflect.Field;

import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;

/**
 * 当前类注释:基类Activity 继承自FragmentActivity
 */
public class BaseActivity extends FragmentActivity{

    protected String strLine = "strLine";
    protected String strRela = "strRela";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.anmi_in_right_left,R.anim.anmi_out_right_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_in_left_right,R.anim.anit_out_left_right);
    }
    protected void openActivity(Class<?> pClass){
        Intent mIntent=new Intent(this,pClass);
        this.startActivity(mIntent);
    }

    /**
     * 设置沉浸式状态栏
     */
    protected void setStatusBar(final String kindOfRootBar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final ViewGroup linear_bar = (ViewGroup) findViewById(R.id.bar_layout);
            final int statusHeight = getStatusBarHeight();
            linear_bar.post(new Runnable() {
                @Override
                public void run() {
                    int titleHeight = linear_bar.getHeight();
                    /*
                    * 如果子类的actionbar布局是linearlayout 则下方显示linearlayout
                    * 如果子类的actionbar布局是RelativeLayout 则下方显示RelativeLayout
                    * */
                    switch (kindOfRootBar) {
                        case "strLine":
                            android.widget.LinearLayout.LayoutParams paramsll = (android.widget.LinearLayout
                                    .LayoutParams) linear_bar.getLayoutParams();
                            paramsll.height = statusHeight + titleHeight;
                            linear_bar.setLayoutParams(paramsll);
                            break;
                        case "strRela":
                            android.widget.RelativeLayout.LayoutParams paramsRela = (android.widget.RelativeLayout
                                    .LayoutParams) linear_bar.getLayoutParams();
                            paramsRela.height = statusHeight + titleHeight;
                            linear_bar.setLayoutParams(paramsRela);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
    /**
     * 获取状态栏的高度
     * @return
     */
    protected int getStatusBarHeight(){
        try
        {
            Class<?> c=Class.forName("com.android.internal.R$dimen");
            Object obj=c.newInstance();
            Field field=c.getField("status_bar_height");
            int x=Integer.parseInt(field.get(obj).toString());
            return  getResources().getDimensionPixelSize(x);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
