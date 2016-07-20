package com.qccr.books.app.topic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicActivity extends AppCompatActivity {

    @BindView(R.id.rv_guess)
    RecyclerView rvGuess;
    @BindView(R.id.btn_change)
    Button btnChange;

    TopicHeaderAdapter topicHeaderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        ButterKnife.bind(this);

        initData();
    }

    void initData() {
        List<TopicHeader> headers = new ArrayList<>();

        TopicHeader header = new TopicHeader();
        header.intro = "吃货不孤单";
        header.name = "吃货不孤单";
        header.picUrl = "http://cdn.ruguoapp.com/o_1a94vr1vfj1b1tvmaol1itc15u2ba.jpeg?imageView2/0/w/300/h/300/interlace/1";
        headers.add(header);

        TopicHeader header1 = new TopicHeader();
        header1.intro = "蝉游记精选";
        header1.name = "蝉游记精选";
        header1.picUrl = "http://cdn.ruguoapp.com/o_1a9501o0l14ir1lmk1de8jboisj37.jpeg?imageView2/0/w/300/h/300/interlace/1";
        headers.add(header1);

        TopicHeader header2 = new TopicHeader();
        header2.intro = "马云最新演讲和言论";
        header2.name = "马云最新演讲和言论";
        header2.picUrl = "http://cdn.ruguoapp.com/o_1ae1a3qhbdfe1c9sal2a67u6st.jpg?imageView2/0/w/300/h/300/interlace/1";
        headers.add(header2);

        topicHeaderAdapter = new TopicHeaderAdapter(headers);
        rvGuess.setLayoutManager(new GridLayoutManager(this, 3));
        rvGuess.setAdapter(topicHeaderAdapter);
    }
}
