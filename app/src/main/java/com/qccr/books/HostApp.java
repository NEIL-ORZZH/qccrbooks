package com.qccr.books;

import android.app.Application;

import net.wequick.small.Small;

/**
 * @author: zhuhuanhuan
 * @time: 17:24
 * @email: zhuhuanhuan@qccr.com
 * @version: 1.0.0
 * @desc:
 */
public class HostApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // If you have some native web modules, uncomment following
        // to declare a base URI for cross-platform page jumping.
        //
        // Small.setBaseUri("http://your_domain/path");
        //

        // !Important, ensure the Small can smooth functioning even 
        // after the application was killed in background.
        Small.setBaseUri("com.qccr.books.app.");
        Small.preSetUp(this);
    }
}