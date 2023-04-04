package com.example.gpshelp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GpsMapActivity extends AppCompatActivity {

    Button button_more3,button_profile3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gps_map);

        button_more3 = findViewById(R.id.button_more3);
        button_more3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GpsMapActivity.this, MoreInformafionActivity.class);
                startActivity(intent);
            }
        });
        button_profile3 = findViewById(R.id.button_profile3);
        button_profile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GpsMapActivity.this, ProfilePacient.class);
                startActivity(intent);
            }
        });
    }
    private void GoBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}