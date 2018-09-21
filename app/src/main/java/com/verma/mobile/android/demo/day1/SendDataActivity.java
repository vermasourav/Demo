

package com.verma.mobile.android.demo.day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class SendDataActivity extends AppCompatActivity {

    private EditText mETStudentName;
    private EditText mETStudentDepartment;
    private EditText mETStudentPhoneNumber;
    private Button mBTSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        mETStudentName = (EditText) findViewById(R.id.id_student_name);
        mETStudentDepartment = (EditText) findViewById(R.id.id_student_department);
        mETStudentPhoneNumber = (EditText) findViewById(R.id.id_student_phone_number);

//TODO need to impliment button click
        mBTSubmit = (Button) findViewById(R.id.id_submit_button);


        mBTSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SendDataActivity.this, ReceivedDataActivity.class);
                intent.putExtra("student_name", mETStudentName.getText().toString());
                intent.putExtra("student_department", mETStudentDepartment.getText().toString());
                intent.putExtra("student_phone_number", mETStudentPhoneNumber.getText().toString());
                startActivity(intent);
            }
        });
    }
}


