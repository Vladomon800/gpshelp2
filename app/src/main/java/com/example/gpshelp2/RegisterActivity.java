package com.example.gpshelp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {
    private EditText email_register;
    private EditText password_register;
    private Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email_register = findViewById(R.id.email_register);
        password_register = findViewById(R.id.password_register);
        btn_register = findViewById(R.id.button_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(email_register.getText());
                password = String.valueOf(password_register.getText());

                if (email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Введите почту", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Введите пароль", Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    Intent intent = new Intent(getApplicationContext(), add_users_profile_iformation.class);
                    intent.putExtra("email",email);
                    intent.putExtra("password",password);
                    startActivity(intent);
                }
            }
        });
    }
}