package com.qccr.books.app.message;

import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.List;

/**
 * @author: zhuhuanhuan
 * @time: 17:24
 * @email: zhuhuanhuan@qccr.com
 * @version: 1.0.0
 * @desc:
 */
public class MessageAdapter extends BaseQuickAdapter<Message> {

    public MessageAdapter(List<Message> messages) {
        super(R.layout.message_recyclerview_item, messages);
    }


    @Override
    protected void convert(BaseViewHolder baseViewHolder, Message message) {
        baseViewHolder.setText(R.id.tv_message_content, message.content)
                .setText(R.id.tv_title, message.title)
                .setText(R.id.tv_date, message.date)
                .setText(R.id.tv_message_like_count, String.valueOf(message.likeCount))
                .setText(R.id.tv_message_comment_count, String.valueOf(message.commentCount));

        ((LikeButton) baseViewHolder.getView(R.id.btn_message_like)).setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                Toast.makeText(mContext, "you like the paper", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                Toast.makeText(mContext, "you don't like the paper", Toast.LENGTH_SHORT).show();

            }
        });


        Glide.with(mContext).load(message.titlePic).into((ImageView) baseViewHolder.getView(R.id.iv_title_pic));


    }
}
