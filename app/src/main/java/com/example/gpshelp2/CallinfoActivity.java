package com.example.gpshelp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class CallinfoActivity extends AppCompatActivity {
    EditText textadress, textinfo;
    Button buttonsend, buttonback;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callinfo);
        textadress = findViewById(R.id.adress);
        textinfo = findViewById(R.id.info);
        buttonsend = findViewById(R.id.send);
        buttonback = findViewById(R.id.back);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallinfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}