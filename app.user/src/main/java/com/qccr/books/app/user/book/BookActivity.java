package com.qccr.books.app.user.book;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.qccr.books.app.user.R;
import com.qccr.books.lib.util.realm.Book;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity implements BookView {

    RecyclerView mRvBooks;
    BookListAdapter mAdapter;
    BookPresentor mPresentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        mPresentor = new BookPresentor(this);
        initView();
        initData();
    }

    void initView() {
        mRvBooks = (RecyclerView) findViewById(R.id.rv_books);
        mRvBooks.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BookListAdapter(this, new ArrayList<Book>());
        mRvBooks.setAdapter(mAdapter);
    }

    void initData() {
        mPresentor.loadBooks();
    }

    @Override
    public void loadBooksSuccess(List<Book> books) {
        mAdapter.addItems(books);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadBooksFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
