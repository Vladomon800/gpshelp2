package com.example.gpshelp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class add_users_profile_iformation extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseDatabase db;
    DatabaseReference users;



    private Button button4;


    private EditText edName,edSecondName,edOtchectvo,edDaterojden,edPasport,edPolice,edAdress,edSnils;
    private DatabaseReference mDataBace;
    private String USER_KEY = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users_profile_iformation);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference(USER_KEY);
        button4 = findViewById(R.id.button4);

        edName = findViewById(R.id.upName);
        edSecondName = findViewById(R.id.upSecondName);
        edOtchectvo = findViewById(R.id.upOtchectvo);
        edDaterojden = findViewById(R.id.upDaterojden);
        edPasport = findViewById(R.id.upPasport);
        edPolice = findViewById(R.id.upPolice);
        edAdress = findViewById(R.id.upAdress);
        edSnils = findViewById(R.id.upSnils);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sedName,sedSecondName,sedOtchectvo,sedDaterojden,sedPasport,sedPolice,sedAdress,sedSnils;
                sedName = String.valueOf(edName.getText());
                sedSecondName = String.valueOf(edSecondName.getText());
                sedOtchectvo = String.valueOf(edOtchectvo.getText());
                sedDaterojden = String.valueOf(edDaterojden.getText());
                sedPasport = String.valueOf(edPasport.getText());
                sedPolice = String.valueOf(edPolice.getText());
                sedAdress = String.valueOf(edAdress.getText());
                sedSnils = String.valueOf(edSnils.getText());
                mDataBace = FirebaseDatabase.getInstance().getReference(USER_KEY);

                if (edName.getText().toString().isEmpty() &&
                        edSecondName.getText().toString().isEmpty() &&
                        edOtchectvo.getText().toString().isEmpty() &&
                        edDaterojden.getText().toString().isEmpty() &&
                        edPasport.getText().toString().isEmpty() &&
                        edPolice.getText().toString().isEmpty() &&
                        edAdress.getText().toString().isEmpty()
                        && edSnils.getText().toString().isEmpty()) {

                    Toast.makeText(add_users_profile_iformation.this, "Не все поля заполнены!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String email, password;
                email = getIntent().getStringExtra("email");
                password = getIntent().getStringExtra("password");

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                user_informathion user = new user_informathion();
                                user.setName(sedName);
                                user.setEmail(email);
                                user.setSec_name(sedSecondName);
                                user.setOtchestvo(sedOtchectvo);
                                user.setDatarojden(sedDaterojden);
                                user.setAdress(sedAdress);
                                user.setPasport(sedPasport);
                                user.setSnils(sedSnils);
                                user.setPolice(sedPolice);
                                users.child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).setValue(user);

                                if (task.isSuccessful()) {
                                    Toast.makeText(add_users_profile_iformation.this, "Учетная запись создана.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(add_users_profile_iformation.this, "Ошибка при регистрации.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
