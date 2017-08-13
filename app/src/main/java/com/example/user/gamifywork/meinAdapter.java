package com.example.user.gamifywork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 11.08.2017.
 */

class meinAdapter extends BaseAdapter {

    Context mcontext;
    List<Task> mTaskList;

    public meinAdapter(Context mcontext, List<Task> mTaskList) {
        this.mcontext = mcontext;
        this.mTaskList = mTaskList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mTaskList.size();
    }

    public String getTitle(int position){
        return mTaskList.get(position).getTitle();
    }

    public String getContent(int position){
        return mTaskList.get(position).getDescription();
    }

    public int getCoins(int position){
        return mTaskList.get(position).getCoins();
    }

    public Boolean getVerified(int position){
        return mTaskList.get(position).getVerified();
    }

    public Boolean getReady(int position){
        return mTaskList.get(position).getFinished();
    }

    public int getID(int position){
        return mTaskList.get(position).getTask_id();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mTaskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v = View.inflate(mcontext, R.layout.taskrowview, null);
        TextView TVName = (TextView)v.findViewById(R.id.header);
        TextView TVCoins = (TextView)v.findViewById(R.id.coins);
        TVName.setText(mTaskList.get(position).getTitle());
        TVCoins.setText(Integer.toString(mTaskList.get(position).getCoins()));

        return v;
    }
}
