package com.andre.lokasisekolahislam.app.controls.adapter;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.utils.ReadFont;
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
public class AdapterDetail extends PagerAdapter {
    private final Context context;
    private final ArrayList<BaseModel> detailData;
    private final ArrayList<BaseModel> listFilter;
    private DetailFragment detailFragment;
    private TextView title;
    private TextView address;


    public AdapterDetail(/*FragmentManager fragmentManager,*/ Context context, ArrayList<BaseModel> detailData) {
//        super(fragmentManager);
        this.context = context;
        this.detailData = detailData;
        listFilter = new ArrayList<BaseModel>();
        listFilter.addAll(detailData);
    }


    @Override
    public int getCount() {
        if (detailData != null) {
            return detailData.size();
        } else {
            return 0;
        }
    }


    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

   /* @Override
    public Fragment getItem(int position) {
        DetailFragment detailFragment = DetailFragment.instance(detailData.get(position));
        return detailFragment;
    }*/

    public BaseModel getItemData(int position) {
        return detailData.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        /*detailFragment = (DetailFragment) super.instantiateItem(container, position);
        return detailFragment;*/
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_detail,container,false);
        title = (TextView) view.findViewById(R.id.nameInstance);
        address = (TextView) view.findViewById(R.id.address);
        createTypeFace();
        insertData(detailData.get(position));
        ((ViewPager)container).addView(view);
        return view;
    }

    private void createTypeFace(){
        ReadFont readFont = new ReadFont(context);
        title.setTypeface(readFont.fontSorsod());
        address.setTypeface(readFont.fontSorsod());
    }

    private void insertData(BaseModel baseModel){
        title.setText(baseModel.getNamaInstitusi());
        address.setText(baseModel.getAlamat());
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((FrameLayout)object);    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==(FrameLayout)o;
    }

    public void filter(final CharSequence charSequence) {
        Log.v("FILTER", "Filtering " + charSequence);
        if (detailData != null) {
            Log.v("FILTER", "DetailData clear");
            detailData.clear();
            notifyDataSetChanged();
        }

        if (listFilter != null) {
            Log.v("FILTER", "ListFilter not null");
            if (charSequence != null && charSequence.length() != 0) {
                new AsyncTask<Void, Void, ArrayList<BaseModel>>() {
                    @Override
                    protected ArrayList<BaseModel> doInBackground(Void... params) {
                        Log.v("FILTER", "Start background filter task");
                        ArrayList<BaseModel> baseModels = new ArrayList<BaseModel>();

                        for (BaseModel baseModel : listFilter) {
                            if (baseModel.getNamaInstitusi().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                                baseModels.add(baseModel);
                            }
                        }

                        Log.v("FILTER", "Background filter task done");
                        return baseModels;
                    }

                    @Override
                    protected void onPostExecute(ArrayList<BaseModel> baseModels) {
                        Log.v("FILTER", "Filter task done, received " + baseModels.size() + "results");
                        if (baseModels != null && baseModels.size() != 0) {
                            Log.v("FILTER", "Adding all data to detailData");
                            detailData.addAll(baseModels);
                            notifyDataSetChanged();
                        }
                    }
                }.execute();
            } else {
                Log.v("FILTER", "Empty search query");
                detailData.addAll(listFilter);
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
