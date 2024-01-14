package com.example.data_com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout btn = findViewById(R.id.stf);
        LinearLayout btn1 = findViewById(R.id.iptobinary);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Stuffing.class);
            startActivity(intent);
        });
        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(this, ipbinary.class);


            // Start the SecondActivity
            startActivity(intent);
        });
    }
}