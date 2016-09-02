package com.qccr.books.app.user.search;

import android.util.Log;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/2-上午10:52.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

final class SearchPresenter {
    private static final String TAG = "SearchPresenter";

    SearchView mView;
    int mPage = 0;

    public SearchPresenter(SearchView view) {
        mView = view;
    }

    public void loadData() {
        mPage++;
        MeiZhiFactory.getGankIOSingleton()
                .getMeizhiData(mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MeizhiData>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MeizhiData meizhiData) {
                        mView.loadDataSuccess(meizhiData.results);
                    }
                });

    }


}
