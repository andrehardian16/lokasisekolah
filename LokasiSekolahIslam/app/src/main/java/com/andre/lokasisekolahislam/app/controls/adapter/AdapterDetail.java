package com.andre.lokasisekolahislam.app.controls.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.models.BaseModel;
import com.andre.lokasisekolahislam.app.views.fragment.DetailFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Andre on 3/17/2015.
 */
public class AdapterDetail extends PagerAdapter{
    private final Context context;
    private final ArrayList<BaseModel> detailData;
    private final DetailFragment detailFragment;
    private GoogleMap mMap;

    public AdapterDetail(Context context, ArrayList<BaseModel> detailData, DetailFragment detailFragment) {
        this.context = context;
        this.detailData = detailData;
        this.detailFragment = detailFragment;
    }


    @Override
    public int getCount() {
        return detailData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==(LinearLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_maps,container,false);
        setupMapIfNeed(position);
        ((ViewPager)container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((FrameLayout)object);
    }

    private void setupMapIfNeed(int pos) {
        if (mMap == null) {
            mMap = ((SupportMapFragment) detailFragment.getActivity().getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (mMap != null) {
                setupMap(pos);
            }
        }
    }

    private void setupMap(int position) {
        LatLng latLng = new LatLng(detailData.get(position).getLatitude(),detailData.get(position).getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
        mMap.addMarker(new MarkerOptions().position(latLng).title(detailData.get(position).getNamaInstitusi()));

    }


}
