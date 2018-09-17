package com.verma.mobile.android.demo.day2;

import android.content.Intent;
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

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
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
}
