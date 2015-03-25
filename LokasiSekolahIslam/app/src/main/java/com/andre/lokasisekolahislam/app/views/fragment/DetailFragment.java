package com.andre.lokasisekolahislam.app.views.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.adapter.AdapterDetail;
import com.andre.lokasisekolahislam.app.controls.interfaceClass.OnCallDetail;
import com.andre.lokasisekolahislam.app.models.BaseModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements ViewPager.OnPageChangeListener {
    public OnCallDetail listener;
    private static int pos = 0;
    public ViewPager pager;
    private static ArrayList<BaseModel> dataDetail;
    private AdapterDetail adapterDetail;

    public static DetailFragment instance(ArrayList<BaseModel> data){
        DetailFragment detailFragment = new DetailFragment();
        dataDetail = (ArrayList<BaseModel>) data;
        return detailFragment;
    }
    public static DetailFragment newInstance(int idField){
        DetailFragment detailFragment = new DetailFragment();
        pos = idField;
        return detailFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        pager = (ViewPager)view.findViewById(R.id.pager);
//        adapterDetail = new AdapterDetail(getActivity().getApplicationContext(),dataDetail,DetailFragment.this);
//        pager.setAdapter(adapterDetail);
//        pager.setCurrentItem(pos);
        pager.setOnPageChangeListener(this);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnCallDetail){
            listener = (OnCallDetail) activity;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        listener.onCallDetail(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
