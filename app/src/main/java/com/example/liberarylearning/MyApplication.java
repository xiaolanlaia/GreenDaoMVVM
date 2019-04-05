package com.example.liberarylearning;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.liberarylearning.greenDao.DaoMaster;
import com.example.liberarylearning.greenDao.DaoSession;

public class MyApplication extends Application {
    /**
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    private static MyApplication myApplication = new MyApplication();

    public static MyApplication getApplication() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        initGreenDao();
    }

    public  void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "aserbao.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private DaoSession daoSession;

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
