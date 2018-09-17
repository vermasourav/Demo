package com.verma.mobile.android.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.verma.mobile.android.demo.day1.FragmentDemoActivity;
import com.verma.mobile.android.demo.day1.GettingResultsBackActivity;
import com.verma.mobile.android.demo.day1.IntentActivity;
import com.verma.mobile.android.demo.day1.LifeCycleActivity;
import com.verma.mobile.android.demo.day1.SendDataActivity;
import com.verma.mobile.android.demo.day2.AsyncActivity;
import com.verma.mobile.android.demo.day2.BroadCastReceiverActivity;
import com.verma.mobile.android.demo.day2.IntentServiceActivity;
import com.verma.mobile.android.demo.day2.ServiceActivity;
import com.verma.mobile.android.demo.day2.provider.StudentProviderActivity;
import com.verma.mobile.android.demo.day3.AlertActivity;
import com.verma.mobile.android.demo.day3.NotificationActivity;


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

public class StartActivity extends AppCompatActivity {

    // Array of strings...
    String[] mDemoArray = {
            "DAY -1 Life Cycle Demo",
            "DAY -1 Sending the data",
            "DAY -1 Getting results Back",
            "DAY -1 Play Sound",
            "DAY -1 Intent",
            "DAY -1 Fragment",

            "DAY -2 Service",
            "DAY -2 Intent Service",
            "DAY -2 Broad Cast Receiver",
            "DAY -2 Provider",
            "DAY -2 Async Task",

            "DAY -3 Alert",
            "DAY -3 Notification"
    };
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.contant_listview, mDemoArray);

        mListView = (ListView) findViewById(R.id.id_demo_list);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pPosition, long arg3) {
                Object o = mListView.getItemAtPosition(pPosition);
                String str = (String) o;//As you are using Default String Adapter
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                performListClick(pPosition);
            }
        });
        //mListView.addFooterView();
    }

    void performListClick(int pos) {
        switch (pos) {
            case 0:
                startActivity(new Intent(this, LifeCycleActivity.class));
                break;

            case 1:
                startActivity(new Intent(this, SendDataActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, GettingResultsBackActivity.class));
                break;
            case 3:
                Intent intent = new Intent("com.verma.mobile.android.demo.PLAYSOUND",
                        Uri.parse("http://www.moviesoundclips.net/tv1/drwho/tardis.mp3"));
                startActivity(intent);
                break;
            case 4:
                startActivity(new Intent(this, IntentActivity.class));
                break;
            case 5:
                startActivity(new Intent(this, FragmentDemoActivity.class));
                break;

            case 6:
                startActivity(new Intent(this, ServiceActivity.class));
                break;
            case 7:
                startActivity(new Intent(this, IntentServiceActivity.class));
                break;
            case 8:
                startActivity(new Intent(this, BroadCastReceiverActivity.class));
                break;
            case 9:
                startActivity(new Intent(this, StudentProviderActivity.class));
                break;
            case 10:
                startActivity(new Intent(this, AsyncActivity.class));
                break;

            case 11:
                startActivity(new Intent(this, AlertActivity.class));
                break;
            case 12:
                startActivity(new Intent(this, NotificationActivity.class));
                break;
        }
    }
}
