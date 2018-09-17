package com.verma.mobile.android.demo.day1.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

public class VersionListFragment extends ListFragment {
    private String[] ANDROID_OS_NAME = new String[]{
            "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream SandWich",
            "Jelly Bean", "KitKat", "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie"
    };

    private String[] VERSION = new String[]{
            "1.5", "1.6", "2.0 - 2.1", "2.2 - 2.2.3", "2.3 - 2.3.7", "3.0 - 3.2.6", "4.0 - 4.0.4",
            "4.1 - 4.3.1", "4.4 - 4.4.4", "5.0 – 5.1.1", "6.0 – 6.0.1", "7.0 – 7.1.2", "8.0 – 8.1", "9.0"
    };
    private String[] API_LEVEL = new String[]{
            "3", "4", "5-7", "8", "9-10", "11-13", "14-15", "16-18", "19-20", "21-22", "23", "24-25", "26-27", "28"
    };

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, ANDROID_OS_NAME);
        setListAdapter(adapter);

        return view;

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextFragment txt = (TextFragment) getFragmentManager().findFragmentById(R.id.id_fragment_2);
        txt.change(ANDROID_OS_NAME[position], "VERSION : " + VERSION[position], "API Level : " + API_LEVEL[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}
