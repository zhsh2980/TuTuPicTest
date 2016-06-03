package com.zhangshan.guibai.tutupictest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.zhangshan.guibai.tutupictest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class CActivity extends SwipeBackActivity {

    @BindView(R.id.activity_c)
    Button activityC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_c)
    public void onClick() {
        finish();
    }
}
