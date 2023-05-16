package com.example.gpshelp2;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gpshelp2.server.LaptopServer;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class CallinfoActivity extends AppCompatActivity {
    EditText textadress, textinfo;
    Button  buttonback;
    private Button buttonsend = null;
    private LaptopServer mServer = null;//экземпляр класса LaptopServer

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callinfo);
        textadress = findViewById(R.id.adress);
        textinfo = findViewById(R.id.info);
        buttonsend = findViewById(R.id.send);
        buttonback = findViewById(R.id.back);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CallinfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                /* создаем объект для работы с сервером*/
                mServer = new LaptopServer(); /* Открываем соединение. Открытие должно происходить в отдельном потоке от ui */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mServer.openConnection(); /* устанавливаем активные кнопки для отправки данных и закрытия соедиения. Все данные по обновлению интерфеса должны обрабатывается в Ui потоке, а так как мы сейчас находимся в отдельном потоке, нам необходимо вызвать метод runOnUiThread() */
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    buttonsend.setEnabled(true);
                                }
                            });
                        } catch (Exception e) {
                            Log.e(LOG_TAG, e.getMessage());
                            mServer = null;
                        }
                    }
                }).start();
        if (mServer == null) {
            Log.e(LOG_TAG, "Сервер не создан");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (textadress.getText().toString().isEmpty() ||  textinfo.getText().toString().isEmpty()){
                        Toast.makeText(CallinfoActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                    } else { mServer.sendData(textadress.getText().toString().getBytes());
                        mServer.sendData( textinfo.getText().toString().getBytes());
                    /* отправляем на сервер данные */
                   // mServer.sendData("Send text to server".getBytes());
                    }
                } catch (Exception e) {
                    Log.e(LOG_TAG, e.getMessage());
                }
            }
        }).start();
    }
});
        }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mServer.closeConnection();
    }
        }