package com.andre.lokasisekolahislam.app.controls.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Andre on 3/18/2015.
 */
public class ReadFont {
    private final Context context;
    String font;

    public ReadFont(Context context) {
        this.context = context;
    }

    public Typeface fontAwesome() {
        font = "fontawesome.ttf";
        return font(font);
    }

    public Typeface fontHelvLight() {
        font = "HelvLight.ttf";
        return font(font);
    }

    public Typeface fontBungehuis(){
        font = "Bungehuis.otf";
        return font(font);
    }
    public Typeface fontSorsod(){
        font = "Sorsod.ttf";
        return font(font);
    }

    private Typeface font(String name) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/" + name);
        return font;
    }

}
