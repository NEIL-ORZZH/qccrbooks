package com.qccr.books.lib.util.realm;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * @author: zhuhuanhuan
 * @time: 16/9/6-下午4:08.
 * @email: zhuhuanhuan@qccr.com
 * @desc:
 */

public final class RealmUtil {

    private static final int CurrentDBVersion = 1;
    private static Realm mRealm;


    public static void init(Application application) {
        RealmConfiguration config = new RealmConfiguration
                .Builder(application)//上下文
                .schemaVersion(CurrentDBVersion)//当前版本号
                .migration(new Migration()).build();//升级相关的
        mRealm = Realm.getInstance(config);
    }

    public static Realm getRealm() {
        return mRealm;
    }


    static class Migration implements RealmMigration {

        @Override
        public void migrate(final DynamicRealm realm, long oldVersion, long newVersion) {

        }
    }
}
