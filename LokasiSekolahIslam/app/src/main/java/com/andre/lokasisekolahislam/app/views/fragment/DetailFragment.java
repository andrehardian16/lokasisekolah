package com.andre.lokasisekolahislam.app.views.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.adapter.AdapterDetail;
import com.andre.lokasisekolahislam.app.controls.interfaceClass.OnCallDetail;
import com.andre.lokasisekolahislam.app.controls.utils.ReadFont;
import com.andre.lokasisekolahislam.app.models.BaseModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    private static BaseModel baseModel;
    private TextView title;
    private TextView address;

    public static DetailFragment instance(BaseModel bm) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data",bm);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        baseModel = (BaseModel)getArguments().getSerializable("data");
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        title = (TextView) view.findViewById(R.id.nameInstance);
        address = (TextView) view.findViewById(R.id.address);
        createTypeFace();
        insertData();
        return view;
    }

    private void createTypeFace(){
        ReadFont readFont = new ReadFont(getActivity());
        title.setTypeface(readFont.fontSorsod());
        address.setTypeface(readFont.fontSorsod());
    }

    private void insertData(){
        title.setText(baseModel.getNamaInstitusi());
        address.setText(baseModel.getAlamat());
    }

}
