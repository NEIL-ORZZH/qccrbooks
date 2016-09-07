package com.qccr.books.app.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qccr.books.app.user.search.MeiZhiActivity;
import com.qccr.books.lib.util.zbar.CaptureActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    CircleImageView userImage;
    ImageView userSetting;
    TextView tvMyTheme;
    TextView tvMyLove;
    TextView tvNotification;
    TextView tvSecretary;
    TextView tvFuLi;

    UserPresentor presentor;

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

        presentor.saveDouBanData2DB();
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

        presentor = new UserPresentor();
    }

}
