package com.example.user.gamifywork;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 12.08.2017.
 */

public class gridAdapter extends BaseAdapter {

    Context mcontext;
    List<Profile> mTaskList;

    public gridAdapter(Context mcontext, List<Profile> mTaskList) {
        this.mcontext = mcontext;
        this.mTaskList = mTaskList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mTaskList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mTaskList.get(position);
    }

    public String getName(int position){
        return mTaskList.get(position).getName();
    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v = View.inflate(mcontext, R.layout.usergridview, null);
        Button myBtn = (Button)v.findViewById(R.id.buttonuser);
        myBtn.setText(mTaskList.get(position).getName());

        return v;
    }
}

