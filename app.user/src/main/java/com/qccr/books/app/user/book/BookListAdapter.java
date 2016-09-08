package com.qccr.books.app.user.book;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qccr.books.app.user.R;
import com.qccr.books.lib.util.realm.Book;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/6-上午11:13.
 * @email: zhuhuanhuan@qccr.com
 * @desc: 发现界面的Adapter
 */

final class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    Context mContent;
    List<Book> mBooks;

    public BookListAdapter(Context context, List<Book> books) {
        mContent = context;
        mBooks = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_books, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mBooks.get(position);

        holder.tvBookTitle.setText(book.getTitle());
        holder.tvBookSubtitle.setText(book.getOrginTitle());
        holder.tvBookPingJia.setText(book.getRating());
        holder.tvBookDesc.setText(book.getSummary());
        holder.tvBookPrice.setText(book.getPrice());
        holder.rbBookRating.setRating(Float.valueOf(book.getRating()));
        holder.rbBookRating.setDrawingCacheBackgroundColor(mContent.getResources().getColor(android.R.color.holo_red_light));


        Glide.with(mContent)
                .load(book.getMediumPic())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.ivBook);

    }

    @Override
    public int getItemCount() {
        return mBooks == null ? 0 : mBooks.size();
    }

    public void addItems(List<Book> data) {
        if (data != null && data.size() > 0) {
            mBooks.addAll(data);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_book)
        ImageView ivBook;
        @Bind(R.id.rb_bookrating)
        RatingBar rbBookRating;
        @Bind(R.id.tv_booktitle)
        TextView tvBookTitle;
        @Bind(R.id.tv_booksubtitle)
        TextView tvBookSubtitle;
        @Bind(R.id.tv_bookpingjia)
        TextView tvBookPingJia;
        @Bind(R.id.tv_bookdesc)
        TextView tvBookDesc;
        @Bind(R.id.tv_bookprice)
        TextView tvBookPrice;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
