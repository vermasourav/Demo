package com.verma.mobile.android.demo.day2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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

public class ServiceActivity extends AppCompatActivity {

    private TextView mTVCurrentTime;
    private ShowTimeReceiver mShowTimeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        mTVCurrentTime = (TextView) findViewById(R.id.id_tv_current_time);

    }

    @Override
    protected void onPause() {
        doUnregisterReceiver();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        doRegisterReceiver();
    }

    public void onButtonClick(View view) {
        int id = view.getId();
        if (id == R.id.id_buttonStart) {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);

        } else if (id == R.id.id_buttonStop) {
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        }
    }

    private void doRegisterReceiver() {
        mShowTimeReceiver = new ShowTimeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyService.ACTION_TIMER);
        registerReceiver(mShowTimeReceiver, intentFilter);


    }

    private void doUnregisterReceiver() {
        unregisterReceiver(mShowTimeReceiver);
    }


    public class ShowTimeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String lCurrentTime = intent.getStringExtra(MyService.PARAM_SERVICE_TIME);
            if (mTVCurrentTime != null) {
                mTVCurrentTime.setText(lCurrentTime);
            }
        }
    }
}
