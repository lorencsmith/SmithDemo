package com.example.lorensmith.smithdemo;

import android.app.Application;

import com.example.lorensmith.smithdemo.util.UtilLog;

/**
 * Created by Loren Smith on 2/6/2017.
 */

public class SmithApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        UtilLog.setDebug(true);

    }
}
