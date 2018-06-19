package com.example.cs2340.marta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class SampleAdapter<T> extends ArrayAdapter {
    private Context context;
    public List<Sample> samples;
    private int resource;



    public SampleAdapter(Context context, int resource, List<Sample> items) {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
        this.samples = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        Sample sample;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.tvlayout, parent, false);
            //sample = new Sample(convertView);
            //convertView.setTag(sample);
        } else {
            sample = (Sample) convertView.getTag();
        }

        TextView tvtp = (TextView)convertView.findViewById(R.id.tvtype);
        TextView tvID = (TextView)convertView.findViewById(R.id.tvid);
        tvtp.setText(samples.get(position).getType());
        tvID.setText(String.valueOf(samples.get(position).getID()));

        return convertView;

    }


}
