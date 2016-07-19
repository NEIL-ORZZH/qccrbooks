package com.qccr.books.app.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivity extends AppCompatActivity {

    @BindView(R.id.user_image)
    CircleImageView userImage;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_4)
    TextView tv4;
    @BindView(R.id.user_setting)
    ImageView userSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.user_setting)
    void gotoSettingActivity() {
        Toast.makeText(this, "Hellooooooooooooooooooooooooooooooooooooooooo", Toast.LENGTH_SHORT).show();
    }
}
