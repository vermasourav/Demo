package com.verma.mobile.android.demo.day2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.util.TimeUtils;
import android.text.TextUtils;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *
 * *
 *  @Copyright	2018 Integra Micro Software Services (IMSS) . All rights reserved.
 *  @author 	Sourav Kumar Verma
 *  @email		sourav.verma@integramicro.com
 *  @version	1.0
 *  Created on 14/9/18 1:04 PM.
 *
 *
 */

public class MyService extends Service implements Runnable {

    private final static String TAG = "MyService";
    public static final String ACTION_TIMER ="ACTION_TIMER";
    public static String PARAM_SERVICE_TIME= "CURRENT_TIME";
    private boolean isRunning;
    private Thread thread;
    private String mCurrentTime = "";

    /*
    If client is binded to service, this method is called.
    Your implementation must return an object that implements IBinder interface.
    If you don't need this, just return null.
    */

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onDestroy() {
        isRunning = false;
    }

    /*
        When Activity calls startService(..),
        this method is invoked. Service is started and it's running until
        stopService or stopSelf() is called
    */

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand - "+isRunning);
        if (!isRunning) {
            thread = new Thread(this);
            thread.start();
        }
        return START_STICKY;
    }

    @Override
    public void onCreate() {
    }


    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            try {
                setCurrentTime();
                Log.i(TAG, "Service  running..." + mCurrentTime);
                sendToClient(mCurrentTime);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendToClient(String pMessage) {
        Intent intent = new Intent();
        intent.setAction(ACTION_TIMER);
        intent.putExtra(PARAM_SERVICE_TIME, pMessage);
        sendBroadcast(intent);
    }
    private void setCurrentTime(){
        mCurrentTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

}