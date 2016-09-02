package com.qccr.books.app.user.search;

import com.qccr.books.app.user.search.modle.Meizhi;

import java.util.List;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/2-上午10:53.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

interface SearchView {

    void loadDataSuccess(List<Meizhi> meizhis);

    void loadDataFailed(String msg);
}
