package com.qccr.books;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tab)
    PagerBottomTabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    void initView() {
        mTab.builder()
                .addTabItem(R.mipmap.ic_topic_unselected, R.mipmap.ic_topic, "发现", getResources().getColor(android.R.color.black))
                .addTabItem(R.mipmap.ic_message_unselected, R.mipmap.ic_message, "消息", getResources().getColor(android.R.color.black))
                .addTabItem(R.mipmap.ic_user_unselected, R.mipmap.ic_user, "我的", getResources().getColor(android.R.color.black))
                .build();
    }
}
