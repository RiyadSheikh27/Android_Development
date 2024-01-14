package com.example.data_com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ipbinary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipbinary);

        EditText in1 = findViewById(R.id.in1);
        EditText in2 = findViewById(R.id.in2);
        EditText in3 = findViewById(R.id.in3);
        EditText in4 = findViewById(R.id.in4);
        Button btn2 = findViewById(R.id.btn2);
        TextView result = findViewById(R.id.result);

  btn2.setOnClickListener(v -> {
      String  binary1  = Integer.toBinaryString( Integer.parseInt(in1.getText().toString()));
      String  binary2  = Integer.toBinaryString( Integer.parseInt(in2.getText().toString()));
      String  binary3 =  Integer.toBinaryString(Integer.parseInt(in3.getText().toString()));
      String  binary4  =  Integer.toBinaryString(Integer.parseInt(in4.getText().toString()));
      String r = binary1+binary2+binary3+binary4;

      result.setText(r);
  });
    }
}