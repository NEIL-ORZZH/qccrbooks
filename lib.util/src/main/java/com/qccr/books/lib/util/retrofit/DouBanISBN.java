package com.qccr.books.lib.util.retrofit;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/6-下午2:04.
 * @email: zhuhuanhuan@qccr.com
 * @desc: 通过ISBN号查询书籍信息
 */

public interface DouBanISBN {

    @GET("v2/book/isbn/{isbn}")
    Observable<DouBanBook> getMeizhiData(@Path("isbn") String isbn);
}
