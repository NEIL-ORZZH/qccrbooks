package com.qccr.books.app.message;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    RecyclerView messageContent;

    MessageAdapter mMessageAdapter;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_message, container, false);
        initView(rootView);
        initData();

        return rootView;
    }

    void initView(View rootView) {
        messageContent = (RecyclerView) rootView.findViewById(R.id.message_content);
    }

    void initData() {
        List<Message> messages = new ArrayList<>();
        Message message = new Message();
        message.title = "摄影精选推送";
        message.titlePic = "http://cdn.ruguoapp.com/o_1a94vunc514kpj9s1g0s13tksl02t.jpeg?imageView2/0/w/120/h/120/interlace/1";
        message.date = "2016-07-20T01:31:15.238Z";
        message.content = "思聪投资的《吐槽大会》被下架背后：一个具有所有爆款特质节目的掌控与意外";
        message.commentCount = 11;
        message.likeCount = 100;
        message.paperUrl = "http://edu.163.com/16/0715/06/BS0DLRPR00294NE9.html";
        messages.add(message);

        Message msg = new Message();
        msg.title = "每天一点设计好灵感";
        msg.titlePic = "http://cdn.ruguoapp.com/o_1al194mb71sns7ke16q3s9o1k9i5j.jpg?imageView2/0/w/720/h/360";
        msg.date = "2016-06-12T03:20:41.097Z";
        msg.content = "好品位不是一天养成的，每天看一点好设计，灵感不期而至。";
        msg.commentCount = 22;
        msg.likeCount = 200;
        msg.paperUrl = "http://edu.163.com/16/0715/06/BS0DLRPR00294NE9.html";
        messages.add(msg);

        mMessageAdapter = new MessageAdapter(messages);
        messageContent.setLayoutManager(new LinearLayoutManager(getContext()));
        messageContent.setAdapter(mMessageAdapter);
    }

}
