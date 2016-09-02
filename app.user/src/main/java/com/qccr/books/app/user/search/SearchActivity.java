package com.qccr.books.app.user.search;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.qccr.books.app.user.R;
import com.qccr.books.app.user.search.modle.Meizhi;
import com.qccr.books.app.user.search.widget.MultiSwipeRefreshLayout;

import net.danlew.android.joda.JodaTimeAndroid;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class SearchActivity extends Activity implements SearchView {

    private static final String TAG = "SearchActivity";
    private static final int PRELOAD_SIZE = 6;

    @Bind(R.id.rv_meizhi)
    RecyclerView rvMeizhi;
    @Bind(R.id.swipe_refresh_layout)
    MultiSwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.main_fab)
    FloatingActionButton mainFab;

    MeizhiListAdapter mMeizhiListAdapter;

    private boolean mIsFirstTimeTouchBottom = true;
    private SearchPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    void initView() {
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvMeizhi.setLayoutManager(layoutManager);

        rvMeizhi.addOnScrollListener(getOnBottomListener(layoutManager));

        initSwipeRefreshLayout();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeColors(Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.RED);

        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeRefreshLayout.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mSwipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);

        //设置下拉刷新的监听
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e(TAG, "onRefresh: ");
                Observable.timer(2, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long s) {
                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        });
            }
        });
    }

    void initData() {
        mPresenter = new SearchPresenter(this);
        mPresenter.loadData();

        JodaTimeAndroid.init(getApplicationContext());

    }

    RecyclerView.OnScrollListener getOnBottomListener(final StaggeredGridLayoutManager layoutManager) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView rv, int dx, int dy) {
                boolean isBottom =
                        layoutManager.findLastCompletelyVisibleItemPositions(new int[2])[1] >=
                                mMeizhiListAdapter.getItemCount() - PRELOAD_SIZE;
                if (!mSwipeRefreshLayout.isRefreshing() && isBottom) {
                    if (!mIsFirstTimeTouchBottom) {
                        mSwipeRefreshLayout.setRefreshing(true);

                        mPresenter.loadData();
                    } else {
                        mIsFirstTimeTouchBottom = false;
                    }
                }
            }
        };
    }

    private OnMeizhiTouchListener getOnMeizhiTouchListener() {

        return new OnMeizhiTouchListener() {
            public void onTouch(View v, View meizhiView, View card, Meizhi meizhi) {
                if (meizhi == null) return;
                if (v == meizhiView) {
                    startPictureActivity(meizhi, meizhiView);
                } else if (v == card) {
                    Toast.makeText(SearchActivity.this, "敬请期待", Toast.LENGTH_SHORT).show();
//                    startGankActivity(meizhi.publishedAt);
                }
            }
        };
    }

    private void startPictureActivity(Meizhi meizhi, View transitView) {
        Intent intent = PictureActivity.newIntent(this, meizhi.url, meizhi.desc);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, transitView, PictureActivity.TRANSIT_PIC);
        try {
            ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            startActivity(intent);
        }
    }

    @Override
    public void loadDataSuccess(List<Meizhi> meizhis) {
        if (mMeizhiListAdapter == null) {
            mMeizhiListAdapter = new MeizhiListAdapter(this, meizhis);
            mMeizhiListAdapter.setOnMeizhiTouchListener(getOnMeizhiTouchListener());

            rvMeizhi.setAdapter(mMeizhiListAdapter);
        } else {
            mMeizhiListAdapter.addItems(meizhis);
            mMeizhiListAdapter.notifyDataSetChanged();
        }
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadDataFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}

