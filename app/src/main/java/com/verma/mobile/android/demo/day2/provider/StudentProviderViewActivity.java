package com.verma.mobile.android.demo.day2.provider;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.verma.mobile.android.demo.R;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * *
 *  @Copyright	2018 Integra Micro Software Services (IMSS) . All rights reserved.
 *  @author 	Sourav Kumar Verma
 *  @email		sourav.verma@integramicro.com
 *  @version	1.0
 *  Created on 14/9/18 3:46 PM.
 *
 *
 */

public class StudentProviderViewActivity extends AppCompatActivity {

    private List<StudentModel> studentModels=new ArrayList<>();
    private ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_provider_view);
        studentListView=(ListView)findViewById(R.id.listview);
        retriveRecords();
        setListAdapter();
    }

    /**
     * set the listview adapter
     */
    private void setListAdapter() {
        StudentCustomAdapter studentCustomAdapter=new StudentCustomAdapter(this,studentModels);
        studentListView.setAdapter(studentCustomAdapter);
    }

    /**
     * to retreive all the student records
     */
    private void retriveRecords() {
// Retrieve student records
        String _ID = "_id";
        String NAME = "name";
        String GRADE = "grade";
        String URL = "content://com.verma.mobile.android.demo.day2.provider.StudentsProvider";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");
        Log.i("Cursor count ","" + c.getCount());


        if (c.moveToFirst()) {
            do{
                StudentModel studentModel=new StudentModel();
                studentModel.set_ID(c.getString(c.getColumnIndex(_ID)));
                studentModel.setNAME(c.getString(c.getColumnIndex(NAME)));
                studentModel.setGRADE("-" + c.getString(c.getColumnIndex(GRADE)));
                studentModels.add(studentModel);
            } while (c.moveToNext());
        }
    }
}
