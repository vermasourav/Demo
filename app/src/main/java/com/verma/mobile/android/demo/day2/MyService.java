package com.verma.mobile.android.demo.day2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

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
    private boolean isRunning;
    private Thread thread;

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
                Log.i(TAG, "Service  running...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}