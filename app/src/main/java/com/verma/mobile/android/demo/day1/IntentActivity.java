package com.verma.mobile.android.demo.day1;

import android.content.Intent;
import android.net.Uri;
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

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

    }

    public void onButtonClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.id_button1:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.msrit.edu"));
                startActivity(intent);
                break;
            case R.id.id_button3:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918095392667"));
                startActivity(intent);
                break;
            case R.id.id_button4:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:13.0288806,77.5645033?z=16"));
                startActivity(intent);
                break;
            case R.id.id_button5:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Integra micro"));
                startActivity(intent);
                break;
            case R.id.id_button6:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(intent, 0);
                break;
            case R.id.id_button7:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;
            case R.id.id_button8:
                intent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
                startActivity(intent);
                break;
        }

    }

}
