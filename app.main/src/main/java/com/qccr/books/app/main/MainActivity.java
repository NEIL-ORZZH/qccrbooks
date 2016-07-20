package com.qccr.books.app.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.wequick.small.Small;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

/**
 * @author: zhuhuanhuan
 * @time: 17:24
 * @email: zhuhuanhuan@qccr.com
 * @version: 1.0.0
 * @desc:
 */
public class MainActivity extends AppCompatActivity {
    static final String[] sUris = new String[]{"topic", "message", "user"};
    static final String[] sTitles = new String[]{"Top", "Message", "User"};
    private static final String TAG = MainActivity.class.getName();
    private static final int PAGE_TOPIC = 0;
    private static final int PAGE_MESSAGE = 1;

    private static final int PAGE_USER = 2;

    @BindView(R.id.tab)
    PagerBottomTabLayout mTab;

    @BindView(R.id.vp_container)
    ViewPager vpContainer;

    Controller mController;
    SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    void initView() {
        mController = mTab.builder()
                .addTabItem(R.mipmap.ic_topic_unselected, R.mipmap.ic_topic, "发现", getResources().getColor(android.R.color.black))
                .addTabItem(R.mipmap.ic_message_unselected, R.mipmap.ic_message, "消息", getResources().getColor(android.R.color.black))
                .addTabItem(R.mipmap.ic_user_unselected, R.mipmap.ic_user, "我的", getResources().getColor(android.R.color.black))
                .build();
    }

    void initData() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        vpContainer.setAdapter(mSectionsPagerAdapter);

        mController.addTabItemClickListener(new OnTabItemSelectListener() {

            @Override
            public void onSelected(int index, Object tag) {
                switch (index) {
                    case PAGE_TOPIC:
                        break;
                    case PAGE_MESSAGE:
                        break;
                    case PAGE_USER:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onRepeatClick(int index, Object tag) {
                Log.i(TAG, "onRepeatClick:" + index + "   TAG: " + tag.toString());
            }
        });
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment fragment = Small.createObject("fragment-v4", sUris[position], MainActivity.this);

            return fragment;
        }

        @Override
        public int getCount() {
            return sTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return sTitles[position];
        }
    }

}
