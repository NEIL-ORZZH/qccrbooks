package com.qccr.books.lib.util.retrofit;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/6-下午2:08.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

public final class DouBanFactory {

    static final Object monitor = new Object();
    static DouBanISBN sGankIOSingleton = null;

    public static DouBanISBN getDouBanSingleton() {
        synchronized (monitor) {
            if (sGankIOSingleton == null) {
                sGankIOSingleton = new BookRetrofit().getDouBanISBN();
            }
            return sGankIOSingleton;
        }
    }

}
