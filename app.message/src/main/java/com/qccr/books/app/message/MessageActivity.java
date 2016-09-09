package com.qccr.books.app.message;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;

/**
 * @author: zhuhuanhuan
 * @time: 17:24
 * @email: zhuhuanhuan@qccr.com
 * @version: 1.0.0
 * @desc:
 */
public class MessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        initView();
        initData();
    }


    void initView() {
        Fragment messageFragment = new MessageFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, messageFragment);
        transaction.commit();

    }

    void initData() {

    }
}
