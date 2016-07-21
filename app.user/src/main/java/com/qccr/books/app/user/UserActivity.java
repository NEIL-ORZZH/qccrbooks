package com.qccr.books.app.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivity extends AppCompatActivity {

    CircleImageView userImage;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    ImageView userSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initView();
        initData();
    }


    void initView() {
        userImage = (CircleImageView) findViewById(R.id.user_image);
        userSetting = (ImageView) findViewById(R.id.user_setting);

        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);
        tv4 = (TextView) findViewById(R.id.tv_4);

    }

    void initData() {
        userSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserActivity.this, "Hellooooooooooooooooooooooooooooooooooooooooo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
