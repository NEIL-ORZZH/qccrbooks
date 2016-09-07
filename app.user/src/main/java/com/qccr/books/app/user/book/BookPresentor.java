package com.qccr.books.app.user.book;

import android.util.Log;

import com.qccr.books.lib.util.realm.Book;
import com.qccr.books.lib.util.realm.RealmUtil;

import io.realm.RealmResults;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

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
        RealmUtil.getRealm()
                .where(Book.class)
                .findAll()
                .asObservable()
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<RealmResults<Book>>() {
                    @Override
                    public void call(RealmResults<Book> books) {
                        mView.loadBooksSuccess(books);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, "call: ", throwable);
                        mView.loadBooksFailed(throwable.toString());
                    }
                });
    }
}
