package com.example.shomitiapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shomitiapp.Adapter.DatabaseConfiguration;

public class Update_Fee extends AppCompatActivity {

    EditText Id,Name,Fee,Fine;
    Button Update;
    DatabaseConfiguration configuration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__fee);

        configuration = new DatabaseConfiguration(this);
        final SQLiteDatabase database = configuration.getWritableDatabase();

        Id = findViewById(R.id.id);
        Name = findViewById(R.id.name);
        Fee = findViewById(R.id.fee);
        Fine = findViewById(R.id.fine);
        Update = findViewById(R.id.update);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String fee = Fee.getText().toString();
                String fine = Fine.getText().toString();

                Boolean isUpdated = configuration.UpdateData(id,name,fee,fine);
                if (isUpdated == true)
                {
                    Toast.makeText(getApplicationContext(),"DATA UPDATED SUCCEFULLY",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Update_Fee.this, Month_Fee.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"DATA NOT UPDATED",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
