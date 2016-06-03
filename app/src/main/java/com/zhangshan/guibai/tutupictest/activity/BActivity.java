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

public class BActivity extends SwipeBackActivity {

    @BindView(R.id.activity_b)
    Button activityB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_b)
    public void onClick() {
        GuiBaiActyUtil.startActivity(this , CActivity.class);
    }
}
