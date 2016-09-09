package com.qccr.books.app.user.book;

import android.util.Log;

import com.qccr.books.lib.util.greendao.Book;
import com.qccr.books.lib.util.greendao.BookDao;
import com.qccr.books.lib.util.greendao.DBHelper;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/7-下午1:59.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

final class BookPresentor {

    private static final String TAG = "BookPresentor";

    BookView mView;

    BookPresentor(BookView view) {
        mView = view;
    }

    void loadBooks() {
        DBHelper.getDaoSession().getBookDao().queryBuilder().orderAsc(BookDao.Properties.Id)
                .rx()
                .list()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Book>>() {
                    @Override
                    public void call(List<Book> books) {
                        mView.loadBooksSuccess(books);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.loadBooksFailed(throwable.toString());
                        Log.e(TAG, "call: ", throwable);
                    }
                });
//        RealmUtil.getRealm()
//                .where(Book.class)
//                .findAll()
//                .asObservable()
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<RealmResults<Book>>() {
//                    @Override
//                    public void call(RealmResults<Book> books) {
//                        mView.loadBooksSuccess(books);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Log.e(TAG, "call: ", throwable);
//                        mView.loadBooksFailed(throwable.toString());
//                    }
//                });
    }
}
