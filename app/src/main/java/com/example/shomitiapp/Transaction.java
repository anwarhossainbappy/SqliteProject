package com.example.shomitiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Transaction extends AppCompatActivity {

    Button Monthly_fee,Borrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Monthly_fee = findViewById(R.id.monthlyfee);
        Borrow = findViewById(R.id.borrow);

        Monthly_fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Transaction.this,Month_Fee.class));
            }
        });
    }
}
