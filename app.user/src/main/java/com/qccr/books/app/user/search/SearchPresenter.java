package com.qccr.books.app.user.search;

import com.qccr.books.app.user.Gank;
import com.qccr.books.app.user.search.http.MeiZhiFactory;
import com.qccr.books.app.user.search.modle.Meizhi;
import com.qccr.books.app.user.search.modle.MeizhiData;
import com.qccr.books.app.user.search.modle.VideoData;

import org.joda.time.DateTime;

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

    public SearchPresenter(SearchView view) {
        mView = view;
    }

    public void loadData() {

        mPage++;

        Observable.zip(MeiZhiFactory.getGankIOSingleton().getMeizhiData(mPage), MeiZhiFactory.getGankIOSingleton().getVideoData(mPage), new Func2<MeizhiData, VideoData, MeizhiData>() {
            @Override
            public MeizhiData call(MeizhiData meizhiData, VideoData videoData) {
                for (Meizhi meizhi : meizhiData.results) {
                    meizhi.desc = meizhi.desc + " " + getFirstVideoDesc(meizhi.publishedAt, videoData.results);
                }

                return meizhiData;
            }
        })
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
                        mView.loadDataSuccess(meizhiData.results);
                    }
                });

    }

    private String getFirstVideoDesc(Date publishedAt, List<Gank> results) {
        DateTime meizhi = new DateTime(publishedAt);
        for (Gank gank : results) {
            if (gank.publishedAt == null) gank.publishedAt = gank.createdAt;
            DateTime hanzi = new DateTime(gank.publishedAt);
            if (hanzi.dayOfYear().get() == meizhi.dayOfYear().get()) {
                return gank.desc;
            }
        }

        return "呵呵哒";
    }


}
