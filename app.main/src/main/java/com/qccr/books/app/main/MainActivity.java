package com.qccr.books.app.main;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;

import net.wequick.small.Small;

import java.util.ArrayList;
import java.util.List;

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
public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getName();

    PagerBottomTabLayout mTab;
    List<Fragment> mFragments;
    Controller mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    void initView() {
        mTab = (PagerBottomTabLayout) findViewById(R.id.tab);

        mController = mTab.builder()
                .addTabItem(R.mipmap.ic_topic_unselected, R.mipmap.ic_topic, "发现", getResources().getColor(android.R.color.black))
                .addTabItem(R.mipmap.ic_message_unselected, R.mipmap.ic_message, "消息", getResources().getColor(android.R.color.black))
                .addTabItem(R.mipmap.ic_user_unselected, R.mipmap.ic_user, "我的", getResources().getColor(android.R.color.black))
                .build();
    }

    void initData() {
        initFragments();

        mController.addTabItemClickListener(new OnTabItemSelectListener() {

            @Override
            public void onSelected(int index, Object tag) {
                Log.i(TAG, "onSelected:" + index + "   TAG: " + tag.toString());

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, mFragments.get(index));
                transaction.commit();
            }

            @Override
            public void onRepeatClick(int index, Object tag) {
                Log.i(TAG, "onRepeatClick:" + index + "   TAG: " + tag.toString());
            }
        });

    }

    void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add((Fragment) Small.createObject("fragment", "topic/fragment", MainActivity.this));
        mFragments.add((Fragment) Small.createObject("fragment", "message/fragment", MainActivity.this));
        mFragments.add((Fragment) Small.createObject("fragment", "user/fragment", MainActivity.this));

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, mFragments.get(0));
        transaction.commit();
    }

}
