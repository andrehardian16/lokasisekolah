package com.andre.lokasisekolahislam.app.views.activity;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.adapter.CustomAdatpter;
import com.andre.lokasisekolahislam.app.controls.dbGetData.AllData;
import com.andre.lokasisekolahislam.app.controls.helperDb.DbHelper;
import com.andre.lokasisekolahislam.app.controls.interfaceClass.OnCallDetail;
import com.andre.lokasisekolahislam.app.controls.interfaceClass.OnCallList;
import com.andre.lokasisekolahislam.app.controls.utils.ReadFont;
import com.andre.lokasisekolahislam.app.models.BaseModel;
import com.andre.lokasisekolahislam.app.views.dialog.DialogSearch;
import com.andre.lokasisekolahislam.app.views.fragment.DetailFragment;
import com.andre.lokasisekolahislam.app.views.fragment.ListDataSchool;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_location)
public class Location extends ActionBarActivity implements OnCallList, OnCallDetail {
    @ViewById
    Toolbar tool_bar_location;
    @ViewById(R.id.btn_search)
    Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
    }

    @AfterViews
    protected void location() {
        ReadFont readFont = new ReadFont(this);
        tool_bar_location.setTitle("");
        tool_bar_location.inflateMenu(R.menu.menu_location);
        setSupportActionBar(tool_bar_location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnSearch.setTypeface(readFont.fontAwesome());
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
        getSupportFragmentManager().beginTransaction().replace(R.id.detailSchool, new DetailFragment().newInstance(pos))
                .commit();
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
                    progressDialog = new ProgressDialog(Location.this);
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
                    progressDialog = new ProgressDialog(Location.this);
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
                    progressDialog = new ProgressDialog(Location.this);
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
                    progressDialog = new ProgressDialog(Location.this);
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
                    progressDialog = new ProgressDialog(Location.this);
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
                    progressDialog = new ProgressDialog(Location.this);
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

        getSupportFragmentManager().beginTransaction().replace(R.id.detailSchool, new DetailFragment().
                instance(baseModels)).commit();
    }

    @Click(R.id.btn_search)
    protected void search(){
        DialogSearch dialogSearch = new DialogSearch(this,Location.this);
        dialogSearch.dialogSearch();
    }
}
