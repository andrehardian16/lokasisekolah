package com.andre.lokasisekolahislam.app.views.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.adapter.AdapterList;
import com.andre.lokasisekolahislam.app.controls.dbGetData.AllData;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;
import com.andre.lokasisekolahislam.app.controls.interfaceClass.OnCallList;
import com.andre.lokasisekolahislam.app.models.BaseModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDataSchool extends Fragment implements AdapterView.OnItemClickListener {
    private OnCallList listener;
    private ListView listData;
    private static ArrayList<BaseModel> listSchoolData;
    private AdapterList adapterList;
    private static int pos;
    private static CharSequence sort;

    public static ListDataSchool instance(ArrayList<BaseModel> list) {
        ListDataSchool listDataSchool = new ListDataSchool();
        listSchoolData = list;
        return listDataSchool;
    }

    public static ListDataSchool newInstance(int idField) {
        ListDataSchool listDataSchool = new ListDataSchool();
        pos = idField;
        return listDataSchool;
    }

    public static ListDataSchool filter(CharSequence charSequence) {
        ListDataSchool listDataSchool = new ListDataSchool();
        sort = charSequence;
        return listDataSchool;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_data_school, container, false);
        listData = (ListView) view.findViewById(R.id.listData);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterList = new AdapterList(getActivity(), listSchoolData);
        adapterList.notifyDataSetChanged();
//        if (adapterList != null) {
            listData.setAdapter(adapterList);
            listData.setSelection(pos);
            listData.setOnItemClickListener(this);
            adapterList.filter(sort);
//        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        BaseModel baseModel = (BaseModel) listData.getAdapter().getItem(position);
        listener.onCallList(position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnCallList) {
            listener = (OnCallList) activity;
        }
    }
}
