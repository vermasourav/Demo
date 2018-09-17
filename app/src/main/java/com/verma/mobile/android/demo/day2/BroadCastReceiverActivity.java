package com.verma.mobile.android.demo.day2;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.verma.mobile.android.demo.R;

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

public class BroadCastReceiverActivity extends AppCompatActivity {

    private MyBroadCastReceiver s;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver);
    }


    @Override
    public void onResume() {
        super.onResume();
        filter = new IntentFilter("android.intent.action.TIME_TICK");
        s = new MyBroadCastReceiver();
        registerReceiver(s, filter);
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(s);
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent("com.verma.mobile.android.demo.DETECTION");
        sendBroadcast(intent);
    }


}
