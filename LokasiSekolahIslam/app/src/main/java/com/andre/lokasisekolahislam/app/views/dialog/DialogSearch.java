package com.andre.lokasisekolahislam.app.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import com.andre.lokasisekolahislam.app.R;
import com.andre.lokasisekolahislam.app.controls.adapter.AdapterMenuDialog;
import com.andre.lokasisekolahislam.app.controls.utils.ReadFont;
import com.andre.lokasisekolahislam.app.views.activity.Location;
import com.andre.lokasisekolahislam.app.views.activity.LocationSchool;

import java.util.ArrayList;

/**
 * Created by Andre on 3/17/2015.
 */
public class DialogSearch {
    private final Context context;
    private final LocationSchool activity;

    public DialogSearch(Context context, LocationSchool activity) {
        this.context = context;
        this.activity = activity;
    }

    public void dialogSearch() {
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        ReadFont readFont = new ReadFont(context);
        View view = layoutInflater.inflate(R.layout.dialog_search, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        TextView cancel = (TextView) view.findViewById(R.id.cancel);
        Button ok = (Button) view.findViewById(R.id.button_search);
        final EditText input = (EditText)view.findViewById(R.id.inputDialog);
        ok.setTypeface(readFont.fontSorsod());
        cancel.setTypeface(readFont.fontAwesome());
        title.setTypeface(readFont.fontBungehuis());

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater1 = LayoutInflater.from(context);
                View view1 = layoutInflater1.inflate(R.layout.dialog_list,null);
                final ListView listSchool = (ListView)view1.findViewById(R.id.listDialogOption);
                String[] dataListDialog = context.getResources().getStringArray(R.array.menu);
                ArrayList<String> stringArrayList = new ArrayList<String>();
                for (int pos = 0; pos < dataListDialog.length; pos++) {
                    stringArrayList.add(dataListDialog[pos]);
                }
                AdapterMenuDialog adapterMenuDialog = new AdapterMenuDialog(stringArrayList,context);
                listSchool.setAdapter(adapterMenuDialog);
                final Dialog dialog1 = new Dialog(context);
                listSchool.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        input.setText((String) listSchool.getAdapter().getItem(position));
                        dialog1.dismiss();
                    }
                });

                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(view1);
                dialog1.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.
                        custom_layout_dialog));
                WindowManager.LayoutParams params = dialog1.getWindow().getAttributes();
                params.dimAmount = 5.0f;
                dialog1.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog1.show();
            }
        });




        final Dialog dialog = new Dialog(context);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getData(input.getText().toString().trim());
                dialog.dismiss();
            }
        });
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R.drawable.custom_layout_dialog));
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.dimAmount = 5.0f;
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.show();
    }
}
