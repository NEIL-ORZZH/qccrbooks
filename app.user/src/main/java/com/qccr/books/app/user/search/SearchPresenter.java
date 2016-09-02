package com.qccr.books.app.user.search;

import android.util.Log;

import com.qccr.books.app.user.Gank;

import java.util.Date;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
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
    int mLastVideoIndex = 0;

    public SearchPresenter(SearchView view) {
        mView = view;
    }

    public void loadData() {

        mPage++;

        Observable.zip(MeiZhiFactory.getGankIOSingleton().getMeizhiData(mPage), MeiZhiFactory.getGankIOSingleton().getVideoData(mPage), new Func2<MeizhiData, VideoData, MeizhiData>() {
            @Override
            public MeizhiData call(MeizhiData meizhiData, VideoData videoData) {
                Log.e(TAG, "call: " + Thread.currentThread().getName());
                for (Meizhi meizhi : meizhiData.results) {
                    meizhi.desc = meizhi.desc + " " +
                            getFirstVideoDesc(meizhi.publishedAt, videoData.results);
                }

                return meizhiData;
            }
        })
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
                        Log.e(TAG, "onnext: " + Thread.currentThread().getName());

                        mView.loadDataSuccess(meizhiData.results);
                    }
                });

    }

    private String getFirstVideoDesc(Date publishedAt, List<Gank> results) {
        String videoDesc = "";
        for (int i = mLastVideoIndex; i < results.size(); i++) {
            Gank video = results.get(i);
            if (video.publishedAt == null) video.publishedAt = video.createdAt;
            if (Dates.isTheSameDay(publishedAt, video.publishedAt)) {
                videoDesc = video.desc;
                mLastVideoIndex = i;
                break;
            }
        }
        return videoDesc;
    }


}
