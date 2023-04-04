package com.example.gpshelp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfilePacient extends AppCompatActivity {

    Button button_more2,button_gps2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_pacient);

        button_more2 = findViewById(R.id.button_more2);
        button_more2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePacient.this, MoreInformafionActivity.class);
                startActivity(intent);
            }
        });
        button_gps2 = findViewById(R.id.button_gps2);
        button_gps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePacient.this, GpsMapActivity.class);
                startActivity(intent);
            }
        });

    }

    private void GoBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}