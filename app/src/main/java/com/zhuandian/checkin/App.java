package com.zhuandian.checkin;

import android.app.Application;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * desc :
 * author：xiedong
 * date：2020/02/29
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=572c49e9");
    }
}
