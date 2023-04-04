package com.example.gpshelp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MoreInformafionActivity extends AppCompatActivity {

    Button button_profile4,button_gps4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_informafion);

        button_profile4 = findViewById(R.id.button_profile4);
        button_profile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInformafionActivity.this, ProfilePacient.class);
                startActivity(intent);
            }
        });
        button_gps4 = findViewById(R.id.button_gps4);
        button_gps4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreInformafionActivity.this, GpsMapActivity.class);
                startActivity(intent);
            }
        });
    }
    private void GoBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}