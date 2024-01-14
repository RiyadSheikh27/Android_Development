package com.example.data_com;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Stuffing extends AppCompatActivity {
    String stuffing = "", destuffing = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuffing);

        EditText edt = findViewById(R.id.edt);
        Button btn = findViewById(R.id.btn);
        TextView txt = findViewById(R.id.txt);

        btn.setOnClickListener(view -> {
            String a = edt.getText().toString();
            if (a.contains("ESC")) {
                stuffing = "STX " + a.replace("ESC", "ESCESC") + " ETX";
                destuffing = a.replace("ESCESC", "ESC");

                txt.setText("Stuffing: "+stuffing + "\n" + "De-Stuffing: "+destuffing);
            }
        });
    }
}