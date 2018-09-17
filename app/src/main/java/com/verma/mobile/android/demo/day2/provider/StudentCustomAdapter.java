package com.verma.mobile.android.demo.day2.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.verma.mobile.android.demo.R;

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

public class StudentCustomAdapter extends BaseAdapter {
 private List<StudentModel> modelList;
 private Context mContext;
    public StudentCustomAdapter(Context context, List<StudentModel> studentModelList) {
        this.mContext=context;
        this.modelList=studentModelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return modelList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater mInflater = (LayoutInflater)
                mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_student_detail, null);
            holder = new ViewHolder();
            holder.studentNameTextView = (TextView) convertView.findViewById(R.id.studentName);
            holder.studentGradeTextView = (TextView) convertView.findViewById(R.id.studentGrade);
            holder.studentIdTextView = (TextView) convertView.findViewById(R.id.studentid);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        StudentModel studentModel = (StudentModel) getItem(position);

        holder.studentIdTextView.setText(studentModel.get_ID());
        holder.studentNameTextView.setText(studentModel.getNAME());
        holder.studentGradeTextView.setText(studentModel.getGRADE());

        return convertView;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView studentNameTextView;
        TextView studentGradeTextView;
        TextView studentIdTextView;

    }
}
