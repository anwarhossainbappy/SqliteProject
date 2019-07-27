package com.example.shomitiapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shomitiapp.Model.MemberModel;
import com.example.shomitiapp.R;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<MemberModel> {
    private Context context;
    private ArrayList<MemberModel> person;

    public Adapter(Context context, ArrayList<MemberModel> person)  {
        super(context, R.layout.custom_layout_custom, person);
        this.context = context;
        this.person = person;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.custom_layout_custom,parent,false);
        TextView t0 = convertView.findViewById(R.id.mytextviews0);
        TextView t1 = convertView.findViewById(R.id.mytextviews1);
        TextView t2 = convertView.findViewById(R.id.mytextviews2);
        TextView t3 = convertView.findViewById(R.id.mytextviews3);
        TextView t4 = convertView.findViewById(R.id.mytextviews4);
        TextView t5 = convertView.findViewById(R.id.mytextviews5);

        t0.setText(person.get(position).getId());
        t1.setText("Name: "+person.get(position).getName());
        t2.setText("Month: "+person.get(position).getMonth());
        t3.setText("Fee: "+person.get(position).getFee());
        t4.setText("Fine: "+person.get(position).getFine());
        t5.setText("Date: "+person.get(position).getDate());

        return convertView;
    }
}
