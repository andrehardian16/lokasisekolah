package com.andre.lokasisekolahislam.app.controls.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.models.BaseModel;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Andre on 3/25/2015.
 */
public class CustomAdatpter extends BaseAdapter {
    private final ArrayList<BaseModel> baseModels;
    private final Context context;

    public CustomAdatpter(ArrayList<BaseModel> baseModels, Context context) {
        this.baseModels = baseModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return baseModels.size();
    }

    @Override
    public Object getItem(int position) {
        return baseModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_list,parent,false);
        TextView textView = (TextView)view.findViewById(R.id.textList);
        textView.setText(baseModels.get(position).getNamaInstitusi());
        return view;
    }
}
