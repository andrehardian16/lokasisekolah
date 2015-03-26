package com.andre.lokasisekolahislam.app.controls.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class AdapterDetail extends FragmentStatePagerAdapter {
    private final Context context;
    private final ArrayList<BaseModel> detailData;
    private final ArrayList<BaseModel> listFilter;


    public AdapterDetail(FragmentManager fragmentManager, Context context, ArrayList<BaseModel> detailData) {
        super(fragmentManager);
        this.context = context;
        this.detailData = detailData;
        listFilter = new ArrayList<BaseModel>();
        listFilter.addAll(detailData);
    }


    @Override
    public int getCount() {
        return detailData.size();
    }


    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Fragment getItem(int position) {
        DetailFragment detailFragment = DetailFragment.instance(detailData.get(position));
        return detailFragment;
    }

    public BaseModel getItemData(int position) {
        return detailData.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        DetailFragment detailFragment = (DetailFragment) super.instantiateItem(container, position);
        return detailFragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    public void filter(String charSequence) {
        detailData.clear();
        if (charSequence == null && charSequence.length() == 0) {
            detailData.addAll(listFilter);
            notifyDataSetChanged();
        } else if (charSequence != null && charSequence.length() != 0) {
            for (BaseModel baseModel : listFilter) {
                if (baseModel.getNamaInstitusi().toLowerCase().equals(charSequence.toLowerCase())) ;
                detailData.add(baseModel);
                notifyDataSetChanged();
            }
        }
    }

    /*private void setupMapIfNeed(int pos) {
        if (mMap == null) {
            mMap = ((SupportMapFragment) detailFragment.getActivity().getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (mMap != null) {
                setupMap(pos);
            }
        }
    }*/


}
