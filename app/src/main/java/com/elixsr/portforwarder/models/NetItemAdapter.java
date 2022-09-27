package com.elixsr.portforwarder.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.elixsr.portforwarder.R;
import com.elixsr.portforwarder.util.InterfaceHelper;

import java.util.List;

public class NetItemAdapter extends ArrayAdapter<InterfaceHelper.InterfaceModel> {

    private int layoutId;

    public NetItemAdapter(Context context, int layoutId, List<InterfaceHelper.InterfaceModel> list){
        super(context,layoutId,list);
        this.layoutId = layoutId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        InterfaceHelper.InterfaceModel item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(layoutId,parent,false);
        TextView  nameView = (TextView)view.findViewById(R.id.netName);
        TextView ipView = (TextView) view.findViewById(R.id.ipAddr);
        nameView.setText(item.getName());
        ipView.setText(item.getInetAddress().getHostAddress());
        return view;
    }

}