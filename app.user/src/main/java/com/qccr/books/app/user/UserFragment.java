package com.qccr.books.app.user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {


    CircleImageView userImage;
    ImageView userSetting;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_user, container, false);

        initView(rootView);
        initData();

        return rootView;
    }

    void initView(View rootView) {
        userImage = (CircleImageView) rootView.findViewById(R.id.user_image);
        userSetting = (ImageView) rootView.findViewById(R.id.user_setting);

        tv1 = (TextView) rootView.findViewById(R.id.tv_1);
        tv2 = (TextView) rootView.findViewById(R.id.tv_2);
        tv3 = (TextView) rootView.findViewById(R.id.tv_3);
        tv4 = (TextView) rootView.findViewById(R.id.tv_4);

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
