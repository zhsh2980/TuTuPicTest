package com.zhangshan.guibai.tutupictest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.zhangshan.guibai.tutupictest.R;
import com.zhangshan.guibai.tutupictest.utils.GuiBaiActyUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class AActivity extends SwipeBackActivity {

    @BindView(R.id.activity_a)
    Button activityA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_a)
    public void onClick() {
        GuiBaiActyUtil.startActivity(this , BActivity.class);
    }
}
