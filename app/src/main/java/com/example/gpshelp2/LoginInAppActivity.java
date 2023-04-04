package com.example.gpshelp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginInAppActivity extends AppCompatActivity {

    Button button_vhod,button_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_in_app);

        button_vhod = findViewById(R.id.button_vhod);
        button_vhod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginInAppActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void GoBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
