package com.qccr.books.app.user;

import android.text.TextUtils;
import android.util.Log;

import com.qccr.books.lib.util.greendao.Book;
import com.qccr.books.lib.util.greendao.DBHelper;
import com.qccr.books.lib.util.retrofit.DouBanBook;
import com.qccr.books.lib.util.retrofit.DouBanFactory;
import com.qccr.books.lib.util.rxbus.RxBus;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/7-下午1:38.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

final class UserPresentor {

    private static final String TAG = "UserPresentor";

    UserPresentor() {

    }

    public void saveDouBanData2DB() {
        RxBus.getDefault().toObservable().subscribe(new Action1<Object>() {
            @Override
            public void call(final Object event) {
                if (event instanceof String) {
                    DouBanFactory.getDouBanSingleton()
                            .getMeizhiData(event.toString())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Action1<DouBanBook>() {
                                @Override
                                public void call(final DouBanBook douBanBook) {
                                    Book book = new Book();
                                    book.setId(Long.valueOf(douBanBook.getId()));
                                    book.setRating(douBanBook.getRating().getAverage());
                                    book.setTitle(douBanBook.getTitle());
                                    book.setOrginTitle(douBanBook.getOrigin_title());
                                    StringBuilder authors = new StringBuilder();
                                    for (String author : douBanBook.getAuthor()) {
                                        authors.append(author)
                                                .append(",");
                                    }
                                    book.setAuthor(authors.substring(0, authors.length() - 2));
                                    book.setSmallPic(douBanBook.getImages().getSmall());
                                    book.setMediumPic(douBanBook.getImages().getMedium());
                                    book.setLargePic(douBanBook.getImages().getLarge());
                                    if (TextUtils.isEmpty(douBanBook.getIsbn13())) {
                                        book.setIsbn(douBanBook.getIsbn10());
                                    } else {
                                        book.setIsbn(douBanBook.getIsbn13());
                                    }
                                    book.setSummary(douBanBook.getSummary());
                                    book.setPublisher(douBanBook.getPublisher());
                                    book.setPrice(douBanBook.getPrice());
                                    book.setPages(douBanBook.getPages());
                                    book.setApiUrl(douBanBook.getUrl());

                                    DBHelper.getDaoSession().getBookDao().insert(book);

                                }
                            }, new Action1<Throwable>() {
                                @Override
                                public void call(Throwable throwable) {
                                    Log.e(TAG, "call: ", throwable);
                                }
                            });
                }
            }
        });
    }
}
