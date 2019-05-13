package com.example.appbasedonexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    String[] coursenames;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] coursenames) {
        this.context = context;
        this.coursenames = coursenames;
    }

    @Override
    public int getCount() {
        return coursenames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
           inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.course_sampleview,parent,false);
        }
        TextView textView;
        textView = convertView.findViewById(R.id.coursenameID);

        textView.setText(coursenames[position]);
            return convertView;

    }
}
