package com.zhuandian.checkin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.util.Log;

public class ScreenBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = ScreenBroadcastReceiver.class.getSimpleName();
    private boolean isRegisterReceiver = false;
    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context =context;
        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
            // 开屏
            Log.i(TAG, "onReceive: 1");
            context.startActivity(new Intent(context,MainActivity.class));
            startLocalApp("com.zhuandian.checkin");
            SystemHelper.setTopApp(context);

        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            // 锁屏
            Log.i(TAG, "onReceive: 2");
        } else if (Intent.ACTION_USER_PRESENT.equals(action)) {
            // 解锁
            Log.i(TAG, "onReceive: 3");
            context.startActivity(new Intent(context,MainActivity.class));
            startLocalApp("com.zhuandian.checkin");
            SystemHelper.setTopApp(context);

        }
    }

    private void startLocalApp(String packageNameTarget) {

        Log.i("Wmx logs::", "-----------------------开始启动第三方 APP=" + packageNameTarget);

        if (SystemHelper.appIsExist(context, packageNameTarget)) {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = packageManager.getLaunchIntentForPackage(packageNameTarget);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED | Intent.FLAG_ACTIVITY_NEW_TASK);

            /**android.intent.action.MAIN：打开另一程序
             */
            intent.setAction("android.intent.action.MAIN");
            /**
             * FLAG_ACTIVITY_SINGLE_TOP:
             * 如果当前栈顶的activity就是要启动的activity,则不会再启动一个新的activity
             */
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            context.startActivity(intent);
        } else {

        }
    }


    public void registerScreenBroadcastReceiver(Context mContext) {
        if (!isRegisterReceiver) {
            isRegisterReceiver = true;
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_SCREEN_OFF);
            filter.addAction(Intent.ACTION_SCREEN_ON);
            filter.addAction(Intent.ACTION_USER_PRESENT);
            mContext.registerReceiver(ScreenBroadcastReceiver.this, filter);
        }
    }

    public void unRegisterScreenBroadcastReceiver(Context mContext) {
        if (isRegisterReceiver) {
            isRegisterReceiver = false;
            mContext.unregisterReceiver(ScreenBroadcastReceiver.this);
        }
    }
}
