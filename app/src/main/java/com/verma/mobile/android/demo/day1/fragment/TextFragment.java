package com.verma.mobile.android.demo.day1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class TextFragment extends Fragment {

    private TextView tvName, tvVersion, tvApiLevel;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        tvName = (TextView) view.findViewById(R.id.id_adroid_os);
        tvVersion = (TextView) view.findViewById(R.id.id_version);
        tvApiLevel = (TextView) view.findViewById(R.id.id_api_level);

        return view;

    }

    public void change(String pName, String pVersion, String pApiLevel) {
        tvName.setText(pName);
        tvVersion.setText(pVersion);
        tvApiLevel.setText(pApiLevel);
    }

}
