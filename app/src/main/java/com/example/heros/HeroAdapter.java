package com.example.heros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HeroAdapter extends ArrayAdapter<Hero> {
    private Context mContext;
    private int mResource;
    private List<Hero> objects;
    public HeroAdapter(Context context, int resource, List<Hero> objects) {
        super(context, -1, objects);
        this.mContext = context;
        this.mResource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        ImageView ivMugshot = (ImageView) convertView.findViewById(R.id.ivMugshot);

        // setting
        Hero hero = objects.get(position);
        tvName.setText(hero.getName());

        return convertView;
    }
}
