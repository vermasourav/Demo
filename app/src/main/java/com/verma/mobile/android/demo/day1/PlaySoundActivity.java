package com.verma.mobile.android.demo.day1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class PlaySoundActivity extends AppCompatActivity {
    private TextView mTVSoundURL;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_play_sound);
        mTVSoundURL = (TextView) findViewById(R.id.id_sound_url);
        Intent i = getIntent();
        Uri uri = i.getData();
        if (uri != null) {
            mTVSoundURL.setText(uri.getPath());
            MediaPlayer mp = MediaPlayer.create(this, i.getData());
            mp.start();
        }
    }


}
