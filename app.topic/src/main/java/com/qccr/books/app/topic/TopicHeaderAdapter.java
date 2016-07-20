package com.qccr.books.app.topic;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author: zhuhuanhuan
 * @time: 2016/7/20-16:09
 * @email: zhuhuanhuan@qccr.com
 * @version: 1.0.0
 * @desc:
 */
public class TopicHeaderAdapter extends BaseQuickAdapter<TopicHeader> {

    public TopicHeaderAdapter(List<TopicHeader> headers) {
        super(R.layout.topic_header_item, headers);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, TopicHeader topicHeader) {
        baseViewHolder.setText(R.id.tv_banner_name, topicHeader.name)
                .setText(R.id.tv_banner_intro, topicHeader.intro);

        Glide.with(mContext).load(topicHeader.picUrl).into((ImageView) baseViewHolder.getView(R.id.iv_banner_picture));
    }
}
