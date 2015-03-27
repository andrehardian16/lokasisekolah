package com.andre.lokasisekolahislam.app.views.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.utils.ReadFont;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @ViewById
    TextView titleApp;
    @ViewById(R.id.btn_start)
    Button btnStart;
    @ViewById(R.id.btn_about)
    Button btnAbout;
    @ViewById(R.id.btn_guide)
    Button btnGuide;
    @ViewById
    LinearLayout menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    protected void main() {
        ReadFont readFont = new ReadFont(this);
        titleApp.setTypeface(readFont.fontBungehuis());
        btnStart.setTypeface(readFont.fontSorsod());
        btnGuide.setTypeface(readFont.fontSorsod());
        btnAbout.setTypeface(readFont.fontSorsod());
        animationStart();
    }

    private void animationMenu(){
        Animation menuApp = AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
        menuApp.reset();
        menu.clearAnimation();
        menu.startAnimation(menuApp);
        menu.setVisibility(View.VISIBLE);
    }

    private void animationStart() {
        final Animation animationTitle = new TranslateAnimation(0, 0, -100, 0);
        animationTitle.setDuration(3000);
        animationTitle.setFillAfter(true);

        final Animation animMenu = new TranslateAnimation(0, 0, 500, 0);
        animMenu.setDuration(500);
        animMenu.setFillAfter(true);

        titleApp.startAnimation(animationTitle);
        new CountDownTimer(4000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
               animationMenu();
            }
        }.start();

    }

    @Click(R.id.btn_start)
    protected void btnStart() {
        Intent location = new Intent(this, LocationSchool_.class);
        startActivity(location);
        finish();
    }

    @Click(R.id.btn_about)
    protected void about(){
        Intent about = new Intent(this,About_.class);
        startActivity(about);
        finish();
    }

    @Click(R.id.btn_guide)
    protected void guide(){
        Intent guide = new Intent(this,Guide_.class);
        startActivity(guide);
        finish();
    }
}
