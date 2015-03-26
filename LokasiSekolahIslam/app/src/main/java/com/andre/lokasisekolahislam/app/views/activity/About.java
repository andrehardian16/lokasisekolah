package com.andre.lokasisekolahislam.app.views.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.utils.ReadFont;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_about)
public class About extends ActionBarActivity {
    private ReadFont readFont;
    @ViewById
    TextView titleAbout;
    @ViewById
    TextView aboutApp;
    @ViewById
    Toolbar toolAbout;
    @ViewById
    TextView titleAboutBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        readFont = new ReadFont(this);

    }

    @AfterViews
    protected void about(){
        titleAbout.setTypeface(readFont.fontBungehuis());
        aboutApp.setTypeface(readFont.fontSorsod());
        titleAboutBar.setTypeface(readFont.fontHelvLight());
        setSupportActionBar(toolAbout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent main = new Intent(this,MainActivity_.class);
        startActivity(main);
        finish();
    }
}
