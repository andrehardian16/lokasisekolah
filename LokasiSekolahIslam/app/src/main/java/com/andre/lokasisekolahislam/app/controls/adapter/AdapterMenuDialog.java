package com.andre.lokasisekolahislam.app.controls.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.utils.ReadFont;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

/**
 * Created by Andre on 3/18/2015.
 */
public class AdapterMenuDialog extends BaseAdapter {
    private final ArrayList<String> listSpinner;
    private final Context context;

    public AdapterMenuDialog(ArrayList<String> listSpinner, Context context) {
        this.listSpinner = listSpinner;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listSpinner.size();
    }

    @Override
    public Object getItem(int position) {
        return listSpinner.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public LayoutSpinner getView(int position, View convertView, ViewGroup parent) {
        LayoutSpinner layoutSpinner = LayoutSpinner_.build(parent.getContext());
        layoutSpinner.setTextSpinner(listSpinner.get(position));
        return layoutSpinner;
    }
}

@EViewGroup(R.layout.adapter_menu_dialog)
class LayoutSpinner extends LinearLayout {
    ReadFont readFont;
    @ViewById
    TextView textSpinner;

    public LayoutSpinner(Context context) {
        super(context);
        readFont = new ReadFont(context);
    }

    public void setTextSpinner(String institusi) {
        textSpinner.setTypeface(readFont.fontHelvLight());
        textSpinner.setText(institusi);
    }
}