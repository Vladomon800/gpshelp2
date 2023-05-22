package com.example.gpshelp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class GpsMapActivity extends FragmentActivity implements OnMapReadyCallback {

    Button button_more3, button_profile3;
    GoogleMap gMap;
    FrameLayout map;

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
        map = findViewById(R.id.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        this.gMap = googleMap;
        LatLng mapRussia = new LatLng(60.00, 100.00);
        this.gMap.addMarker(new MarkerOptions().position(mapRussia).title("Marker in Russia"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapRussia));

    }

    private void GoBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}