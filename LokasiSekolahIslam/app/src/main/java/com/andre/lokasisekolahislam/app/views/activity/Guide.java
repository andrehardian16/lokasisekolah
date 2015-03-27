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

@EActivity(R.layout.activity_guide)
public class Guide extends ActionBarActivity {
    private ReadFont readFont;
    @ViewById
    TextView titleGuideBar;
    @ViewById
    Toolbar toolGuide;
    @ViewById
    TextView textGuideTitle;
    @ViewById
    TextView textGuide1;
    @ViewById
    TextView textGuide2;
    @ViewById
    TextView textGuide3;
    @ViewById
    TextView textGuide4;
    @ViewById
    TextView textGuide5;
    @ViewById
    TextView textGuide6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    protected void guide(){
        readFont = new ReadFont(this);
        textGuideTitle.setTypeface(readFont.fontBungehuis());
        textGuide1.setTypeface(readFont.fontSorsod());
        textGuide2.setTypeface(readFont.fontSorsod());
        textGuide3.setTypeface(readFont.fontSorsod());
        textGuide4.setTypeface(readFont.fontSorsod());
        textGuide5.setTypeface(readFont.fontSorsod());
        textGuide6.setTypeface(readFont.fontSorsod());
        titleGuideBar.setTypeface(readFont.fontHelvLight());

        setSupportActionBar(toolGuide);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
