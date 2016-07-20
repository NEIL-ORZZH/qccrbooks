package com.qccr.books.app.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

/**
 * @author: zhuhuanhuan
 * @time: 17:24
 * @email: zhuhuanhuan@qccr.com
 * @version: 1.0.0
 * @desc:
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    private static final int PAGE_TOPIC = 0;
    private static final int PAGE_MESSAGE = 1;
    private static final int PAGE_USER = 2;

    @BindView(R.id.tab)
    PagerBottomTabLayout mTab;
    @BindView(R.id.tv_page_content)
    TextView tvPageContent;

    Controller mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    void initView() {
        mController = mTab.builder()
                .addTabItem(R.mipmap.ic_topic_unselected, R.mipmap.ic_topic, "发现", getResources().getColor(android.R.color.black))
                .addTabItem(R.mipmap.ic_message_unselected, R.mipmap.ic_message, "消息", getResources().getColor(android.R.color.black))
                .addTabItem(R.mipmap.ic_user_unselected, R.mipmap.ic_user, "我的", getResources().getColor(android.R.color.black))
                .build();
    }

    void initData() {
        mController.addTabItemClickListener(new OnTabItemSelectListener() {

            @Override
            public void onSelected(int index, Object tag) {
                switch (index) {
                    case PAGE_TOPIC:
                        tvPageContent.setText("发现");
                        break;
                    case PAGE_MESSAGE:
                        tvPageContent.setText("消息");
                        break;
                    case PAGE_USER:
                        tvPageContent.setText("我的");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onRepeatClick(int index, Object tag) {
                Log.i(TAG, "onRepeatClick:" + index + "   TAG: " + tag.toString());
            }
        });
    }
}
