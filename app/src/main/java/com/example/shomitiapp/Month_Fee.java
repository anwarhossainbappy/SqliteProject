package com.example.shomitiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Month_Fee extends AppCompatActivity implements View.OnClickListener {

    Button AddFee,View,Update,Delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month__fee);

        AddFee = findViewById(R.id.insert);
        View = findViewById(R.id.viewData);
        Update = findViewById(R.id.update);
        Delete = findViewById(R.id.delete);

        AddFee.setOnClickListener(this);
        View.setOnClickListener(this);
        Update.setOnClickListener(this);
        Delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.insert)
        {
            startActivity(new Intent(Month_Fee.this,Add_fee.class));
        } if (id == R.id.viewData)
        {
            startActivity(new Intent(Month_Fee.this,Fee_List.class));
        }if (id==R.id.update)
        {
            startActivity(new Intent(Month_Fee.this,Update_Fee.class));
        }if (id==R.id.delete)
        {
            startActivity(new Intent(Month_Fee.this,DeleteData.class));
        }
    }
}
