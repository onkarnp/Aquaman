package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Order> {
    List<Order> list;
    Context context;
    public MyAdapter(@NonNull Context context, int resource, List<Order> list) {
        super(context, resource);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.list_item,parent,false);
        TextView date = convertView.findViewById(R.id.date);
        TextView name = convertView.findViewById(R.id.name);
        TextView address = convertView.findViewById(R.id.address);
        TextView summary = convertView.findViewById(R.id.summary);
        TextView status = convertView.findViewById(R.id.status);
        TextView price = convertView.findViewById(R.id.price);
        date.setText(list.get(position).getDate());
        name.setText(list.get(position).getName());
        address.setText(list.get(position).getAddress());
        summary.setText(list.get(position).getSummary());
        status.setText(list.get(position).getStatus());
        price.setText(list.get(position).getPrice());
        return convertView;
    }
}
