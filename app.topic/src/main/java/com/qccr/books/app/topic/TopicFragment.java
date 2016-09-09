package com.qccr.books.app.topic;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import me.wangyuwei.galleryview.GalleryEntity;
import me.wangyuwei.galleryview.GalleryView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {

    String[] mImgs = new String[]{"http://awb.img1.xmtbang.com/wechatmsg2015/article201505/20150525/thumb/9b65bb01da504a12807f50324fe01e3b.jpg",
            "http://cdn.ruguoapp.com/o_1ae1a3qhbdfe1c9sal2a67u6st.jpg?imageView2/0/w/300/h/300/interlace/1",
            "http://img4.imgtn.bdimg.com/it/u=665141257,1340555319&fm=21&gp=0.jpg",
            "http://cdn.ruguoapp.com/o_1a94vr1vfj1b1tvmaol1itc15u2ba.jpeg?imageView2/0/w/300/h/300/interlace/1",
            "http://cdn.ruguoapp.com/o_1a9501o0l14ir1lmk1de8jboisj37.jpeg?imageView2/0/w/300/h/300/interlace/1",
            "http://cdn.ruguoapp.com/o_1ae1a3qhbdfe1c9sal2a67u6st.jpg?imageView2/0/w/300/h/300/interlace/1",
            "http://img4.imgtn.bdimg.com/it/u=665141257,1340555319&fm=21&gp=0.jpg",
            "http://awb.img1.xmtbang.com/wechatmsg2015/article201505/20150525/thumb/9b65bb01da504a12807f50324fe01e3b.jpg",
            "http://cdn.ruguoapp.com/o_1a9501o0l14ir1lmk1de8jboisj37.jpeg?imageView2/0/w/300/h/300/interlace/1"};

    String[] mTitles = new String[]{"这是一个简单的测试",
            "必有小新",
            "Tracy McGrady",
            "吃货不孤单",
            "蝉游记精选",
            "马云最新演讲和言论",
            "Tracy McGrady",
            "这是一个简单的测试",
            "蝉游记精选"};

    Button btnChange;

    List<GalleryView> mGalleryList;

    public TopicFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_topic, container, false);

        initView(rootView);
        initData();

        return rootView;
    }

    void initView(View rootView) {
        mGalleryList = new ArrayList<>();
        mGalleryList.add((GalleryView) rootView.findViewById(R.id.gallery0));
        mGalleryList.add((GalleryView) rootView.findViewById(R.id.gallery1));
        mGalleryList.add((GalleryView) rootView.findViewById(R.id.gallery2));
        btnChange = (Button) rootView.findViewById(R.id.btn_refresh);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSmooth();
            }
        });
    }

    void initData() {
        for (int i = 0; i < mGalleryList.size(); i++) {
            mGalleryList.get(i).addGalleryData(refreshGallerViewData(i * 3));
        }
//        List<TopicHeader> headers = new ArrayList<>();
//
//        TopicHeader header = new TopicHeader();
//        header.intro = "吃货不孤单";
//        header.name = "吃货不孤单";
//        header.picUrl = "http://cdn.ruguoapp.com/o_1a94vr1vfj1b1tvmaol1itc15u2ba.jpeg?imageView2/0/w/300/h/300/interlace/1";
//        headers.add(header);
//
//        TopicHeader header1 = new TopicHeader();
//        header1.intro = "蝉游记精选";
//        header1.name = "蝉游记精选";
//        header1.picUrl = "http://cdn.ruguoapp.com/o_1a9501o0l14ir1lmk1de8jboisj37.jpeg?imageView2/0/w/300/h/300/interlace/1";
//        headers.add(header1);
//
//        TopicHeader header2 = new TopicHeader();
//        header2.intro = "马云最新演讲和言论";
//        header2.name = "马云最新演讲和言论";
//        header2.picUrl = "http://cdn.ruguoapp.com/o_1ae1a3qhbdfe1c9sal2a67u6st.jpg?imageView2/0/w/300/h/300/interlace/1";
//        headers.add(header2);

    }

    private List<GalleryEntity> refreshGallerViewData(int index) {
        List<GalleryEntity> result = new ArrayList<>();

        GalleryEntity entity0 = new GalleryEntity();
        entity0.imgUrl = mImgs[0 + index];
        entity0.title = mTitles[0 + index];
        result.add(entity0);

        GalleryEntity entity1 = new GalleryEntity();
        entity1.imgUrl = mImgs[1 + index];
        entity1.title = mTitles[1 + index];
        result.add(entity1);

        GalleryEntity entity2 = new GalleryEntity();
        entity2.imgUrl = mImgs[2 + index];
        entity2.title = mTitles[2 + index];
        result.add(entity2);

        return result;
    }

    private void startSmooth() {
        for (int i = 0; i < mGalleryList.size(); i++) {
            final int index = i;
            mGalleryList.get(i).postDelayed(new Runnable() {
                @Override
                public void run() {
                    mGalleryList.get(index).startSmooth();
                }
            }, 100 * i);
        }

    }
}
