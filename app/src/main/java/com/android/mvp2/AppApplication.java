package com.android.mvp2;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.android.mvp2.http.HttpClient;

public class AppApplication extends Application {

    private static AppApplication instance;

    public static AppApplication getInstance() {
        return instance;
    }

//    public static AppApplication get(@NonNull  Context context) {
//        return (AppApplication) context.getApplicationContext();
//    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

    }

}
