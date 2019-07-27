package com.example.shomitiapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shomitiapp.Adapter.Adapter;
import com.example.shomitiapp.Adapter.DatabaseConfiguration;
import com.example.shomitiapp.Model.MemberModel;

import java.util.ArrayList;

public class Fee_List extends AppCompatActivity {

    ListView lv;
    DatabaseConfiguration mydatabasehelper;
    Adapter myadapter;
    ArrayList<MemberModel> listdata1;

    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee__list);
        error =findViewById(R.id.error);
        lv = findViewById(R.id.mylistview);
        mydatabasehelper = new DatabaseConfiguration(this);
        customlistcall();
    }
    private void customlistcall() {

        listdata1 = new ArrayList<>();
        final Cursor cursor = mydatabasehelper.displayData();
        if (cursor.getCount() == 0) {
            /// no data found
        } else {
            while (cursor.moveToNext()) {
                listdata1.add(new MemberModel(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                ));

            }
        }

        myadapter = new Adapter(this, listdata1);
        lv.setAdapter(myadapter);
        lv.setEmptyView(error);

    }



    }
