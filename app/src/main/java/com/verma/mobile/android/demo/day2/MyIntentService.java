package com.verma.mobile.android.demo.day2;

import android.app.IntentService;
import android.content.Intent;
import android.text.format.DateFormat;

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

public class MyIntentService extends IntentService {
    public static final String PARAM_SERVICE_IN_MSG = "imsg";
    public static final String PARAM_SERVICE_OUT_MSG = "omsg";
    public final static String ACTION_CASHBACK = "cashback_info";

    private final String TAG = this.getClass().getSimpleName();

    public MyIntentService() {
        super("MyIntentService");
    }

    private String getCurrentTime() {
        return (String) DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String cb_category = intent.getStringExtra(PARAM_SERVICE_IN_MSG);

        String cbinfo = getCashbackInfo(cb_category);
        sendCashbackInfoToClient(cbinfo);
    }

    private String getCashbackInfo(String cbcat) {
        String cashback;
        if ("electronics".equals(cbcat)) {
            cashback = "Upto 20% cashback on electronics";
        } else if ("fashion".equals(cbcat)) {
            cashback = "Upto 60% cashbak on all fashion items";
        } else {
            cashback = "All other categories except fashion and electronics, flat 30% cashback";
        }
        return cashback + " - " + getCurrentTime();
    }

    private void sendCashbackInfoToClient(String msg) {
        Intent intent = new Intent();
        intent.setAction(ACTION_CASHBACK);
        intent.putExtra(PARAM_SERVICE_OUT_MSG, msg);
        sendBroadcast(intent);
    }


}

