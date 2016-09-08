package com.qccr.books.app.user.meizhi;

import com.qccr.books.app.user.meizhi.modle.Meizhi;

import java.util.List;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/2-上午10:53.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

interface MeiZhiView {

    void loadDataSuccess(List<Meizhi> meizhis);

    void loadDataFailed(String msg);
}
