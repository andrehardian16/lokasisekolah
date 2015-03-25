package com.andre.lokasisekolahislam.app.controls.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.models.BaseModel;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Andre on 3/17/2015.
 */
public class AdapterList extends BaseAdapter {
    private final Context context;
    private final ArrayList<BaseModel> dataList;

    public AdapterList(Context context, ArrayList<BaseModel> dataList) {

        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.adapter_list, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.textList = (TextView) convertView.findViewById(R.id.textList);
            if (dataList != null && dataList.size() != 0) {
                holder.textList.setText(dataList.get(position).getNamaInstitusi());
            }
        return convertView;

    }

    private static class ViewHolder {
        TextView textList;
    }

}

/*@EViewGroup(R.layout.adapter_list)
class LayoutAdapter extends LinearLayout {
    @ViewById
    protected TextView textList;

    public LayoutAdapter(Context context) {
        super(context);
    }

    public void setTextList(String name) {
        textList.setText(name);
    }
}*/
