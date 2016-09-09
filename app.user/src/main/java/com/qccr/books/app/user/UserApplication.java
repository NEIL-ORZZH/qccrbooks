package com.qccr.books.app.user;

import android.app.Application;
import android.util.Log;

import com.qccr.books.lib.util.greendao.DBHelper;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/6-下午5:30.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

public final class UserApplication extends Application {

    private static final String TAG = "UserApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    void init() {
        DBHelper.init(this);
        Log.e(TAG, "init: userapplication");
    }
}
