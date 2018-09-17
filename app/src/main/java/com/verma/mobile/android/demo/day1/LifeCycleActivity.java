

package com.verma.mobile.android.demo.day1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

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

public class LifeCycleActivity extends AppCompatActivity {

    private Button buttonOpenFragment;

    /**
     * Called when the activity is first created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        showToast("ON CREATE");
    }

    /**
     * Called when the activity becomes visible to the user
     */

    @Override
    protected void onStart() {
        super.onStart();
        showToast("ON START");
    }

    /**
     * Called when the activity starts interacting with the user
     */

    @Override
    protected void onResume() {
        super.onResume();
        showToast("ON RESUME");
    }

    /**
     * Called when the current activity is being paused and the previous activity is being resumed
     */

    @Override
    protected void onPause() {
        super.onPause();
        showToast("ON PAUSE");
    }


    /**
     * Called when the activity has been stopped and is restarting again
     */


    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("ON RESTART");
    }

    /**
     * Called when the activity is no longer visible to the user
     */


    @Override
    protected void onStop() {
        super.onStop();
        showToast("ON STOP");
    }

    /**
     * Called before the activity is destroyed by the system
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "ON DESTROY", Toast.LENGTH_SHORT).show();
    }


    /**
     * This Method is used for show the Toast
     */

    private void showToast(String pMessage) {
        Toast.makeText(this, pMessage, Toast.LENGTH_SHORT).show();
    }
}


