package com.qccr.books.app.message;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * @author: zhuhuanhuan
 * @time: 17:24
 * @email: zhuhuanhuan@qccr.com
 * @version: 1.0.0
 * @desc:
 */
public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        initView();
        initData();
    }


    void initView() {
        Fragment messageFragment = new MessageFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, messageFragment);
        transaction.commit();

    }

    void initData() {

    }
}
