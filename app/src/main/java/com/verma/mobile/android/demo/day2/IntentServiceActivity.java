package com.verma.mobile.android.demo.day2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
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

public class IntentServiceActivity extends AppCompatActivity {

    private TextView tv;
    private CashbackReciver cashbackReciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        tv = (TextView) findViewById(R.id.id_tv_results);
        registerCashbackReceiver();
    }

    public void onButtonClick(View view) {
        int id = view.getId();
        if (id == R.id.id_buttonIntentStart) {
            startCashbackService(view);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(cashbackReciver);
    }

    public void startCashbackService(View view) {
        EditText et = (EditText) findViewById(R.id.id_et_cashback);
        Intent cbIntent = new Intent();
        cbIntent.setClass(this, MyIntentService.class);
        cbIntent.putExtra(MyIntentService.PARAM_SERVICE_IN_MSG, et.getText().toString());
        startService(cbIntent);
    }

    private void registerCashbackReceiver() {
        cashbackReciver = new CashbackReciver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MyIntentService.ACTION_CASHBACK);
        registerReceiver(cashbackReciver, intentFilter);

    }

    private class CashbackReciver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String cbinfo = intent.getStringExtra(MyIntentService.PARAM_SERVICE_OUT_MSG);
            tv.setText(cbinfo);
        }
    }

}
