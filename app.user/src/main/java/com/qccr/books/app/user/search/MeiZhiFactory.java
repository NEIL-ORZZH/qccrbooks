/*
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of Meizhi
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.qccr.books.app.user.search;

/**
 * Created by drakeet on 8/9/15.
 */
public class MeiZhiFactory {

    public static final int MeiZhiSize = 10;
    public static final int gankSize = 5;
    protected static final Object monitor = new Object();
    static GankApi sGankIOSingleton = null;

    public static GankApi getGankIOSingleton() {
        synchronized (monitor) {
            if (sGankIOSingleton == null) {
                sGankIOSingleton = new MeiZhiRetrofit().getGankService();
            }
            return sGankIOSingleton;
        }
    }

}
