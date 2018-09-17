package com.verma.mobile.android.demo.day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class ReceivedDataActivity extends AppCompatActivity {

    private TextView mTVStudentName, mTVStudentDepartment;
    private EditText mETStudentPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_data);

        mTVStudentName = (TextView) findViewById(R.id.id_received_student_name);
        mTVStudentDepartment = (TextView) findViewById(R.id.id_received_student_department);
        mETStudentPhoneNumber = (EditText) findViewById(R.id.id_student_phone_number);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String lStudentName = extras.getString("student_name");
            String lStudentDepartment = extras.getString("student_department");
            String lStudentPhoneNumber = extras.getString("student_phone_number");


            mTVStudentName.setText("Name:" + lStudentName);
            mTVStudentDepartment.setText("Department:" + lStudentDepartment);
            mETStudentPhoneNumber.setText(lStudentPhoneNumber);
        }


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        String number = mETStudentPhoneNumber.getText().toString();
        intent.putExtra("student_phone_number", number);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }


}
