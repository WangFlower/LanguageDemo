package com.example.sam.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Sam on 2015/2/5.
 */
public class LanguageAdapter extends BaseAdapter {

    private ArrayList<String> mData;
    private Context mContext;


    public LanguageAdapter(Context context,ArrayList<String> data){
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);


        return convertView;
    }


}
