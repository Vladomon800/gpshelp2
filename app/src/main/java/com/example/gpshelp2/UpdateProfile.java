package com.example.gpshelp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.appsearch.AppSearchSchema;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class UpdateProfile extends AppCompatActivity {

    private Button btn_up;
    private EditText upName,upSecondName,upOtchectvo,upDaterojden,upAdress,upPasport,upSnils,upPolice;
    private String currentUserID;
    FirebaseAuth mAuth;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        btn_up = findViewById(R.id.btn_up);
        upName = findViewById(R.id.upName);
        upSecondName = findViewById(R.id.upSecondName);
        upOtchectvo = findViewById(R.id.upOtchectvo);
        upDaterojden = findViewById(R.id.upDaterojden);
        upAdress = findViewById(R.id.upAdress);
        upPasport = findViewById(R.id.upPasport);
        upSnils = findViewById(R.id.upSnils);
        upPolice = findViewById(R.id.upPolice);

        String Name,SecondName,Otchectvo,Daterojden,Adress,Pasport,Snils,Police;
        Name = getIntent().getStringExtra("name");
        SecondName = getIntent().getStringExtra("secondname");
        Otchectvo = getIntent().getStringExtra("otchestvo");
        Daterojden = getIntent().getStringExtra("daterojden");
        Adress = getIntent().getStringExtra("adress");
        Pasport = getIntent().getStringExtra("passport");
        Snils = getIntent().getStringExtra("police");
        Police = getIntent().getStringExtra("snils");
        upName.setText(Name);
        upSecondName.setText(SecondName);
        upOtchectvo.setText(Otchectvo);
        upDaterojden.setText(Daterojden);
        upAdress.setText(Adress);
        upPasport.setText(Pasport);
        upSnils.setText(Snils);
        upPolice.setText(Police);

        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        rootRef = FirebaseDatabase.getInstance().getReference();

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateInformation();
            }



    });
}

    private void UpdateInformation() {

        String name = upName.getText().toString();
        String sec_name = upSecondName.getText().toString();
        String otchestvo = upOtchectvo.getText().toString();
        String datarojden = upDaterojden.getText().toString();
        String adress = upAdress.getText().toString();
        String pasport = upPasport.getText().toString();
        String police = upPolice.getText().toString();
        String snils = upSnils.getText().toString();


        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(sec_name)||TextUtils.isEmpty(otchestvo)|| TextUtils.isEmpty(datarojden)||TextUtils.isEmpty(adress)||TextUtils.isEmpty(pasport)||TextUtils.isEmpty(police)||TextUtils.isEmpty(snils)){
            Toast.makeText(this, "вы не заполнили все поля", Toast.LENGTH_SHORT).show();
        }
        else {
            HashMap<String,Object> profileMap = new HashMap<>();
            profileMap.put("uid",currentUserID);
            profileMap.put("name",name);
            profileMap.put("sec_name",sec_name);
            profileMap.put("otchestvo",otchestvo);
            profileMap.put("datarojden",datarojden);
            profileMap.put("adress",adress);
            profileMap.put("pasport",pasport);
            profileMap.put("police",police);
            profileMap.put("snils",snils);

            rootRef.child("USER").child(currentUserID).setValue(profileMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(UpdateProfile.this, "Информация обновлена", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateProfile.this, ProfilePacient.class);
                        startActivity(intent);
                    }
                    else {
                        String messege = task.getException().toString();
                        Toast.makeText(UpdateProfile.this, "Произошла ошибка " + messege, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

