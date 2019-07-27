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

public class DeleteData extends AppCompatActivity {

    EditText editText;
    Button Delete;
    DatabaseConfiguration databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        editText =findViewById(R.id.idNo);
        Delete = findViewById(R.id.deletebutton);
        databaseHelper = new DatabaseConfiguration(this);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = editText.getText().toString();
                int result = databaseHelper.deleteData(id);

                if (result > 0)
                {
                    Toast.makeText(getApplicationContext(),"DATA DELETED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DeleteData.this, MainActivity.class));
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"DATA DELETED FAIL",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
