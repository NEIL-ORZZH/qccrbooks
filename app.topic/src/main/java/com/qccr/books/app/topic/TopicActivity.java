package com.qccr.books.app.topic;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class TopicActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        initView();
        initData();
    }


    void initView() {
        Fragment topicFragment = new TopicFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, topicFragment);
        transaction.commit();

    }

    void initData() {

    }
}
