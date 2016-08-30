package com.qccr.books.app.user;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qccr.lib.utils.CaptureActivity;

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

    void initView(View rootView) {
        userImage = (CircleImageView) rootView.findViewById(R.id.user_image);
        userSetting = (ImageView) rootView.findViewById(R.id.user_setting);

        tvMyTheme = (TextView) rootView.findViewById(R.id.tv_mytheme);
        tvMyLove = (TextView) rootView.findViewById(R.id.tv_mylove);
        tvNotification = (TextView) rootView.findViewById(R.id.tv_notification);
        tvSecretary = (TextView) rootView.findViewById(R.id.tv_secretary);

        tvSecretary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), CaptureActivity.class));
            }
        });

    }

    void initData() {
        userSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hellooooooooooooooooooooooooooooooooooooooooo", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
