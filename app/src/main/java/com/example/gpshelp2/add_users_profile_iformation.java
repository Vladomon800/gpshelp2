package com.example.gpshelp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_users_profile_iformation extends AppCompatActivity {
    private Button button_vhod;
    private Button button4;
    private Button button_vhodmain;
    private EditText edName,edSecondName,edOtchectvo,edDaterojden,edPasport,edPolice,edAdress,edSnils;
    private DatabaseReference mDataBace;
    private String USER_KEY = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users_profile_iformation);
        init();
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edName.getText().toString().isEmpty() && edSecondName.getText().toString().isEmpty()){
                    Toast.makeText(add_users_profile_iformation.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(add_users_profile_iformation.this,MainActivity.class );
                    startActivity(intent);
                    onClickSave(v);
                }
            }
        });
    }
    public void init()
    {
        edName = findViewById(R.id.edName);
        edSecondName = findViewById(R.id.edSecondName);
        edOtchectvo = findViewById(R.id.edOtchectvo);
        edDaterojden = findViewById(R.id.edDaterojden);
        edPasport = findViewById(R.id.edPasport);
        edPolice = findViewById(R.id.edPolice);
        edAdress = findViewById(R.id.edAdress);
        edSnils = findViewById(R.id.edSnils);
        button4 = findViewById(R.id.button4);
        mDataBace = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }
    public void onClickSave(View view)
    {
        String id = mDataBace.getKey();
        String name = edName.getText().toString();
        String sec_name = edSecondName.getText().toString();
        String otchestvo = edOtchectvo.getText().toString();
        String datarojden = edDaterojden.getText().toString();
        String adress = edAdress.getText().toString();
        String pasport = edPasport.getText().toString();
        String snils = edSnils.getText().toString();
        String police = edPolice.getText().toString();
        user_informathion newuser_informathion = new user_informathion(id,name,sec_name,otchestvo,datarojden,adress,pasport,snils,police);
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(sec_name) && !TextUtils.isEmpty(sec_name) && !TextUtils.isEmpty(otchestvo) && !TextUtils.isEmpty(datarojden) && !TextUtils.isEmpty(adress) && !TextUtils.isEmpty(pasport) && !TextUtils.isEmpty(snils)&& !TextUtils.isEmpty(police)  )
        {
            mDataBace.push().setValue(newuser_informathion);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
        }
    }

}