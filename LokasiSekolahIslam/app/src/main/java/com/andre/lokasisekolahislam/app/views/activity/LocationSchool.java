package com.andre.lokasisekolahislam.app.views.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.adapter.AdapterDetail;
import com.andre.lokasisekolahislam.app.controls.adapter.AdapterList;
import com.andre.lokasisekolahislam.app.controls.dbGetData.AllData;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;
import com.andre.lokasisekolahislam.app.controls.interfaceClass.OnCallDetail;
import com.andre.lokasisekolahislam.app.controls.interfaceClass.OnCallList;
import com.andre.lokasisekolahislam.app.controls.utils.ReadFont;
import com.andre.lokasisekolahislam.app.models.BaseModel;
import com.andre.lokasisekolahislam.app.views.dialog.DialogSearch;
import com.andre.lokasisekolahislam.app.views.fragment.ListDataSchool;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_location_school)
public class LocationSchool extends ActionBarActivity implements ViewPager.OnPageChangeListener,OnCallDetail,OnCallList, TextWatcher {
    private int pos;
    private OnCallDetail listener;
    @ViewById
    Toolbar tool_bar_location;
    @ViewById(R.id.btn_search)
    Button btnSearch;
    @ViewById
    ViewPager detailSchool;
    @ViewById
    EditText sortir;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @AfterViews
    protected void location() {
        ReadFont readFont = new ReadFont(this);
        tool_bar_location.setTitle("");
        tool_bar_location.inflateMenu(R.menu.menu_location);
        setSupportActionBar(tool_bar_location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSearch.setTypeface(readFont.fontAwesome());
        sortir.setTypeface(readFont.fontHelvLight());
        sortir.addTextChangedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent backMenu = new Intent(this, MainActivity_.class);
        startActivity(backMenu);
        finish();
        super.onBackPressed();
    }


    @Override
    public void onCallDetail(int pos) {
        getSupportFragmentManager().beginTransaction().replace(R.id.listSchool, new ListDataSchool().newInstance(pos))
                .commit();
    }

    @Override
    public void onCallList(int pos) {
        detailSchool.setCurrentItem(pos);
        AdapterDetail adapterDetail1 = (AdapterDetail) detailSchool.getAdapter();
        setUpMap(adapterDetail1.getItemData(pos));
    }

    public void getData(String option) {
        DbHelper dbHelper = new DbHelper(this);
        final AllData allData = new AllData(this, dbHelper);
        String[] menu = getResources().getStringArray(R.array.menu);
        if (option.equals(menu[0])) {
            new AsyncTask<Void, Void, ArrayList<BaseModel>>() {
                ProgressDialog progressDialog;

                @Override
                protected ArrayList<BaseModel> doInBackground(Void... params) {
                    return allData.allDataMadrasahAliyah();
                }

                @Override
                protected void onPreExecute() {
                    progressDialog = new ProgressDialog(LocationSchool.this);
                    progressDialog.show();
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(ArrayList<BaseModel> baseModels) {
                    progressDialog.dismiss();
                    if (baseModels != null && baseModels.size() != 0) {
                        setSchool(baseModels);
                    }
                }
            }.execute();
        } else if (option.equals(menu[1])) {
            new AsyncTask<Void, Void, ArrayList<BaseModel>>() {
                ProgressDialog progressDialog;

                @Override
                protected ArrayList<BaseModel> doInBackground(Void... params) {
                    return allData.allDataMadrasahDiniyahTakmiliya();
                }

                @Override
                protected void onPreExecute() {
                    progressDialog = new ProgressDialog(LocationSchool.this);
                    progressDialog.show();
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(ArrayList<BaseModel> baseModels) {
                    progressDialog.dismiss();
                    if (baseModels != null && baseModels.size() != 0) {
                        setSchool(baseModels);
                    }
                }
            }.execute();

        } else if (option.equals(menu[2])) {
            new AsyncTask<Void, Void, ArrayList<BaseModel>>() {
                ProgressDialog progressDialog;

                @Override
                protected ArrayList<BaseModel> doInBackground(Void... params) {
                    return allData.allDataMadrasahIbtidaiyah();
                }

                @Override
                protected void onPreExecute() {
                    progressDialog = new ProgressDialog(LocationSchool.this);
                    progressDialog.show();
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(ArrayList<BaseModel> baseModels) {
                    progressDialog.dismiss();
                    if (baseModels != null && baseModels.size() != 0) {
                        setSchool(baseModels);
                    }
                }
            }.execute();

        } else if (option.equals(menu[3])) {
            new AsyncTask<Void, Void, ArrayList<BaseModel>>() {
                ProgressDialog progressDialog;

                @Override
                protected ArrayList<BaseModel> doInBackground(Void... params) {
                    return allData.allDataPerguruanTinggiAgamaIslam();
                }

                @Override
                protected void onPreExecute() {
                    progressDialog = new ProgressDialog(LocationSchool.this);
                    progressDialog.show();
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(ArrayList<BaseModel> baseModels) {
                    progressDialog.dismiss();
                    if (baseModels != null && baseModels.size() != 0) {
                        setSchool(baseModels);
                    }
                }
            }.execute();

        } else if (option.equals(menu[4])) {
            new AsyncTask<Void, Void, ArrayList<BaseModel>>() {
                ProgressDialog progressDialog;

                @Override
                protected ArrayList<BaseModel> doInBackground(Void... params) {
                    return allData.allDataPondokPesantren();
                }

                @Override
                protected void onPreExecute() {
                    progressDialog = new ProgressDialog(LocationSchool.this);
                    progressDialog.show();
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(ArrayList<BaseModel> baseModels) {
                    progressDialog.dismiss();
                    if (baseModels != null && baseModels.size() != 0) {
                        setSchool(baseModels);
                    }
                }
            }.execute();

        } else if (option.equals(menu[5])) {
            new AsyncTask<Void, Void, ArrayList<BaseModel>>() {
                ProgressDialog progressDialog;

                @Override
                protected ArrayList<BaseModel> doInBackground(Void... params) {
                    return allData.allDataRaudathulAtfal();
                }

                @Override
                protected void onPreExecute() {
                    progressDialog = new ProgressDialog(LocationSchool.this);
                    progressDialog.show();
                    super.onPreExecute();
                }

                @Override
                protected void onPostExecute(ArrayList<BaseModel> baseModels) {
                    progressDialog.dismiss();
                    if (baseModels != null && baseModels.size() != 0) {
                        setSchool(baseModels);
                    }
                }
            }.execute();
        }
    }

    private void setSchool(ArrayList<BaseModel> baseModels) {
        getSupportFragmentManager().beginTransaction().replace(R.id.listSchool, new ListDataSchool().
                instance(baseModels)).commit();
        AdapterDetail adapterDetail = new AdapterDetail(getSupportFragmentManager(),this,baseModels);
        detailSchool.setAdapter(adapterDetail);
        detailSchool.setCurrentItem(pos);
        detailSchool.setOnPageChangeListener(this);
        setUpMapIfNeeded(baseModels.get(pos));
        /*getSupportFragmentManager().beginTransaction().replace(R.id.detailSchool, new DetailFragment().
                instance(baseModels)).commit();*/
    }

    @Click(R.id.btn_search)
    protected void search(){
        DialogSearch dialogSearch = new DialogSearch(this,LocationSchool.this);
        dialogSearch.dialogSearch();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        listener = (OnCallDetail) LocationSchool.this;
        listener.onCallDetail(position);
        AdapterDetail adapterDetail1 = (AdapterDetail)detailSchool.getAdapter();
        setUpMap(adapterDetail1.getItemData(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded(BaseModel baseModel) {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap(baseModel);
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap(BaseModel baseModel) {
        mMap.clear();
        LatLng latLng = new LatLng(baseModel.getLatitude(),baseModel.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        mMap.addMarker(new MarkerOptions().position(latLng).title(baseModel.getNamaInstitusi()));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
       /* if (detailSchool.getAdapter() != null && detailSchool.getAdapter().getCount() != 0) {
            AdapterDetail adapterDetail1 = (AdapterDetail) detailSchool.getAdapter();
            adapterDetail1.filter(s.toString());
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.listSchool, new ListDataSchool().filter(s))
                .commit();*/
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
