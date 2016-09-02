package com.qccr.books.app.user.search;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/2-上午11:20.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

final class ModleMeiZhi {

    public void getMeiZhiDatas(int page) {
        MeiZhiFactory.getGankIOSingleton()
                .getMeizhiData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MeizhiData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MeizhiData meizhiData) {

                    }
                });
    }
}
