package com.qccr.books.app.user.book;

import com.qccr.books.lib.util.greendao.Book;

import java.util.List;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/7-下午2:10.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

interface BookView {

    void loadBooksSuccess(List<Book> books);

    void loadBooksFailed(String msg);
}
