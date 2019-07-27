package com.example.shomitiapp;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shomitiapp.Adapter.DatabaseConfiguration;

import java.util.Calendar;

public class Add_fee extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button DatePick,AddData;
    DatePickerDialog.OnDateSetListener mDateSelect;
    String date;
    String[] monthname = {"January", "February", "March", "April", "May","June","July","August","September","October","November","December"};
    Spinner month_name;
    String item;
    EditText Name,Fee,Fine;
    String Date,name,fee,fine;
    TextView SetDate;
    DatabaseConfiguration databaseConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fee);

    DatePick = findViewById(R.id.datepick);
    Fee = findViewById(R.id.monthfee);
    Fine = findViewById(R.id.fine);
    Name = findViewById(R.id.name);
    SetDate =findViewById(R.id.setDate);
    AddData = findViewById(R.id.add_data);
        month_name = findViewById(R.id.month_sp);
        month_name.setOnItemSelectedListener(this);

        databaseConfiguration = new DatabaseConfiguration(this);
        SQLiteDatabase database = databaseConfiguration.getWritableDatabase();

        ArrayAdapter aa = new ArrayAdapter(Add_fee.this,android.R.layout.simple_spinner_item,monthname);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
        month_name.setAdapter(aa);


        DatePick.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Calendar cal1 = Calendar.getInstance();
            int year = cal1.get(Calendar.YEAR);
            int month = cal1.get(Calendar.MONTH);
            int day = cal1.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(Add_fee.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSelect, year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        }

    });
        mDateSelect = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                date = dayOfMonth + "/" + month + "/" + year;
                SetDate.setText(date);
            }
        };



       AddData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               name = Name.getText().toString();
               fee = Fee.getText().toString();
               fine = Fine.getText().toString();
               Date = SetDate.getText().toString();

               if (name.isEmpty() || fee.isEmpty() || fine.isEmpty() || Date.isEmpty())
               {
                   Toast.makeText(Add_fee.this, "All Field Must be Complete", Toast.LENGTH_SHORT).show();
               }else
               {
                   long rowId=  databaseConfiguration.insertData(name,item,fee,fine,date);
                   if (rowId == -1) {
                       Toast.makeText(getApplicationContext(), "Data Not Inserted", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(getApplicationContext(), "Fee Inserted Successfuly", Toast.LENGTH_SHORT).show();
                        Name.setText(" ");
                        Fee.setText(" ");
                        Fine.setText(" ");
                        SetDate.setText(" ");
                   }
               }
           }
       });
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
