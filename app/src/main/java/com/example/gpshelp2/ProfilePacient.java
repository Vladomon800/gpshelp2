package com.example.gpshelp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfilePacient extends AppCompatActivity {

    FirebaseAuth auth;

    Button button;
    TextView textView;
    Button mainButton,button_update;
    TextView edName2,edSecondName2,edOtchectvo2,edDaterojden2,edAdress2,edPassport2,edPolice2,edSnils2,edEmail2;
    FirebaseUser user;
    FirebaseDatabase db;
    DatabaseReference users;
    private String USER_KEY = "Users";

    Button button_more2,button_gps2,btn_up,btn_signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_pacient);
        auth = FirebaseAuth.getInstance();

        edName2 = findViewById(R.id.edName2);
        edSecondName2 = findViewById(R.id.edSecondName2);
        edOtchectvo2 = findViewById(R.id.edOtchectvo2);
        edDaterojden2 = findViewById(R.id.edDaterojden2);
        edAdress2 = findViewById(R.id.edAdress2);
        edPassport2 = findViewById(R.id.edPassport2);
        edPolice2 = findViewById(R.id.edPolice2);
        edSnils2 = findViewById(R.id.edSnils2);
        edEmail2 = findViewById(R.id.edEmail2);
        button_more2 = findViewById(R.id.button_more2);
        btn_signOut = findViewById(R.id.btn_signOut);


        user = auth.getCurrentUser();
        if (user == null){
            Intent i = new Intent(ProfilePacient.this, LoginActivity.class);
            startActivity(i);

        } else {

            db = FirebaseDatabase.getInstance();
            users = db.getReference("USER");

            users.child(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    }
                    else {
                        edName2.setText(String.valueOf(task.getResult().child("name").getValue()));
                        edEmail2.setText(String.valueOf(task.getResult().child("email").getValue()));
                        edSecondName2.setText(String.valueOf(task.getResult().child("sec_name").getValue()));
                        edOtchectvo2.setText(String.valueOf(task.getResult().child("otchestvo").getValue()));
                        edDaterojden2.setText(String.valueOf(task.getResult().child("datarojden").getValue()));
                        edAdress2.setText(String.valueOf(task.getResult().child("adress").getValue()));
                        edPassport2.setText(String.valueOf(task.getResult().child("pasport").getValue()));
                        edPolice2.setText(String.valueOf(task.getResult().child("police").getValue()));
                        edSnils2.setText(String.valueOf(task.getResult().child("snils").getValue()));


                        //edSecondName2.setText(String.valueOf(task.getResult().child("sec_name").getValue()));
                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    }
                }
            });

        }

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
        button_update = findViewById(R.id.button_update);
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(  ProfilePacient.this, UpdateProfile.class);
                    intent.putExtra("name",edName2.getText().toString());
                    intent.putExtra("email",edEmail2.getText().toString());
                    intent.putExtra("secondname",edSecondName2.getText().toString());
                    intent.putExtra("otchestvo",edOtchectvo2.getText().toString());
                    intent.putExtra("daterojden",edDaterojden2.getText().toString());
                    intent.putExtra("adress",edAdress2.getText().toString());
                    intent.putExtra("passport",edPassport2.getText().toString());
                    intent.putExtra("police",edPolice2.getText().toString());
                    intent.putExtra("snils",edSnils2.getText().toString());

                    startActivity(intent);
                }
        });
        btn_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(ProfilePacient.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }

    private void GoBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}