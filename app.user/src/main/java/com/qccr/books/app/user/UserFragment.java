package com.qccr.books.app.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qccr.books.app.user.search.MeiZhiActivity;
import com.qccr.books.lib.util.realm.Book;
import com.qccr.books.lib.util.realm.RealmUtil;
import com.qccr.books.lib.util.retrofit.DouBanBook;
import com.qccr.books.lib.util.retrofit.DouBanFactory;
import com.qccr.books.lib.util.rxbus.RxBus;
import com.qccr.books.lib.util.zbar.CaptureActivity;

import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.Realm;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private static final String TAG = "UserFragment";

    CircleImageView userImage;
    ImageView userSetting;
    TextView tvMyTheme;
    TextView tvMyLove;
    TextView tvNotification;
    TextView tvSecretary;
    TextView tvFuLi;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_user, container, false);

        initView(rootView);
        initData();

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

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

                                    RealmUtil.getRealm().executeTransactionAsync(new Realm.Transaction() {
                                        @Override
                                        public void execute(Realm realm) {
                                            Book book = realm.createObject(Book.class);
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

                                        }
                                    });



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

    void initView(View rootView) {
        userImage = (CircleImageView) rootView.findViewById(R.id.user_image);
        userSetting = (ImageView) rootView.findViewById(R.id.user_setting);

        tvMyTheme = (TextView) rootView.findViewById(R.id.tv_mytheme);
        tvMyLove = (TextView) rootView.findViewById(R.id.tv_mylove);
        tvNotification = (TextView) rootView.findViewById(R.id.tv_notification);
        tvSecretary = (TextView) rootView.findViewById(R.id.tv_secretary);
        tvFuLi = (TextView) rootView.findViewById(R.id.tv_fuli);

        tvSecretary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CaptureActivity.class));
            }
        });

        tvFuLi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MeiZhiActivity.class));
            }
        });
    }

    void initData() {
        userSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MeiZhiActivity.class));
            }
        });
    }

}
