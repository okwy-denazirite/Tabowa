package com.hellohasan.sqlite_multiple_three_tables_crud.util;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

public class MyApp extends Application {

    public static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        context = getApplicationContext();
    }
}
