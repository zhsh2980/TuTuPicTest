package com.zhangshan.guibai.tutupictest.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zhangshan.guibai.tutupictest.R;
import com.zhangshan.guibai.tutupictest.base.BaseActivity;
import com.zhangshan.guibai.tutupictest.utils.DisplayUtils;
import com.zhangshan.guibai.tutupictest.utils.GuiBaiActyUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends BaseActivity {

    @BindView(R.id.pic)
    Button pic;
    @BindView(R.id.camera)
    Button camera;
    @BindView(R.id.camera_and_edit)
    Button cameraAndEdit;
    @BindView(R.id.swipe_back_test)
    Button swipeBackTest;
    @BindView(R.id.my_message)
    LinearLayout myMessage;
    @BindView(R.id.store)
    LinearLayout store;
    @BindView(R.id.pay_music_bag)
    LinearLayout payMusicBag;
    @BindView(R.id.online_music)
    LinearLayout onlineMusic;
    @BindView(R.id.navigation_view)
    LinearLayout navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.drawer_open_close)
    Button drawerOpenClose;
    @BindView(R.id.close_drawer)
    Button closeDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //根据 xml 中的类型写下面的参数 line/rela
        setStatusBar(strRela);
        ButterKnife.bind(this);
        initDrawerWidth();// 设置左划右划的大小
    }

    /**
     * 侧滑宽度
     *
     * @author zhangshan
     */
    private void initDrawerWidth() {
        // 获取屏幕宽 高
        int width = DisplayUtils.getScreenWidth(this);
        int leftDrawerWidth = (int) (width * 0.8);
        // 设置左侧侧滑的宽度
        ViewGroup.LayoutParams leftDrawerLayoutParams = navigationView.getLayoutParams();
        leftDrawerLayoutParams.width = leftDrawerWidth;
        navigationView.setLayoutParams(leftDrawerLayoutParams);
    }

    /**
     * 主页的点击事件
     * @author zhangshan
     * @time 16/6/2 下午3:42
     */
    @OnClick({R.id.pic, R.id.camera, R.id.camera_and_edit,
            R.id.swipe_back_test, R.id.my_message, R.id.store,
            R.id.pay_music_bag, R.id.online_music, R.id.drawer_open_close
            , R.id.close_drawer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pic://图片滤镜
                GuiBaiActyUtil.startActivity(this, PicActivity.class);
                break;
            case R.id.camera://相机滤镜
                new CameraPage().showSample(this);
                break;
            case R.id.camera_and_edit://相机滤镜并编辑
                new CameraAndEditPage().showSample(this);
                break;
            case R.id.swipe_back_test://侧滑测试
                GuiBaiActyUtil.startActivity(this, AActivity.class);
                break;
            case R.id.drawer_open_close://侧滑打开关闭
                drawerOpenClose.setSelected(true);
                if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
                break;
        }
    }

    /**
     * 左划的点击事件
     * @author zhangshan
     */
    @OnClick({R.id.my_message, R.id.store,
            R.id.pay_music_bag, R.id.online_music
            , R.id.close_drawer})
    public void onLeftClick(View view) {
        switch (view.getId()) {
            case R.id.my_message://我的消息
                //1.其他变白
                setOthersWhite();
                //2.自己变红
                myMessage.setEnabled(false);//false 是背景变红
                //closeDrawer();
                break;
            case R.id.store://积分商城
                setOthersWhite();
                store.setEnabled(false);
                //closeDrawer();
                break;
            case R.id.pay_music_bag://付费音乐包
                setOthersWhite();
                payMusicBag.setEnabled(false);
                //closeDrawer();
                break;
            case R.id.online_music://在线听歌
                setOthersWhite();
                onlineMusic.setEnabled(false);
                //closeDrawer();
                break;
            case R.id.close_drawer://关闭侧滑
                closeDrawer();
                break;
        }
    }

    /**
     * 其他条目变白
     *
     * @author zhangshan
     */
    private void setOthersWhite() {
        myMessage.setEnabled(true);
        store.setEnabled(true);
        payMusicBag.setEnabled(true);
        onlineMusic.setEnabled(true);
    }

    //关闭drawer
    private void closeDrawer() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    private long mExitTime;

    /**
     * 退出程序
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            }/* else if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
            } */ else {
                super.onBackPressed();
            }
        }
        if (keyCode == KeyEvent.KEYCODE_BACK && !drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
