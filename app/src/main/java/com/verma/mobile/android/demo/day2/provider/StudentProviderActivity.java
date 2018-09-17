package com.verma.mobile.android.demo.day2.provider;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.verma.mobile.android.demo.R;
import com.verma.mobile.android.demo.day2.ServiceActivity;


/*
 *
 * *
 *  @Copyright	2018 Integra Micro Software Services (IMSS) . All rights reserved.
 *  @author 	Sourav Kumar Verma
 *  @email		sourav.verma@integramicro.com
 *  @version	1.0
 *  Created on 14/9/18 3:38 PM.
 *
 *
 */

public class StudentProviderActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addButton,viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_provider);
        addButton=(Button)findViewById(R.id.addbutton);
        addButton.setOnClickListener(this);
        viewButton=(Button)findViewById(R.id.viewbutton);
        viewButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.addbutton){
           addRecords();
        }else if(v.getId()==R.id.viewbutton){
            startActivity(new Intent(this, StudentProviderViewActivity.class));
        }
    }


    /**
     * method to add the student details to db
     */
    private void addRecords() {
// Add a new student record
        ContentValues values = new ContentValues();
        values.put(StudentsProvider.NAME,
                ((EditText)findViewById(R.id.nameeditText)).getText().toString());

        values.put(StudentsProvider.GRADE,
                ((EditText)findViewById(R.id.gradeeditText)).getText().toString());

        Uri uri = getContentResolver().insert(StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }
}
