package com.example.gpshelp2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity
{
    private TextView tvName, tvSecName, tvPasport, tvSnils, tvPolice, tvOtchestvo, tvDatarojden, tvAdress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_layout);
        init();
        getIntentMain();
    }
    private void init()
    {
        tvName = findViewById(R.id.tvName);
        tvSecName = findViewById(R.id.tvSecName);
        tvPasport = findViewById(R.id.tvPasport);
        tvSnils = findViewById(R.id.tvSnils);
        tvPolice = findViewById(R.id.tvPolice);
        tvOtchestvo = findViewById(R.id.tvOtchestvo);
        tvDatarojden = findViewById(R.id.tvDatarojden);
        tvAdress = findViewById(R.id.tvAdress);

    }
    private void getIntentMain()
    {
        Intent i = getIntent();
        if(i != null)
        {
            tvName.setText(i.getStringExtra(Constant.USER_NAME));
            tvSecName.setText(i.getStringExtra(Constant.USER_SEC_NAME));
            tvOtchestvo.setText(i.getStringExtra(Constant.USER_OTCHESTVO));
            tvDatarojden.setText(i.getStringExtra(Constant.USER_DATAROJDEN));
            tvAdress.setText(i.getStringExtra(Constant.USER_ADRESS));
            tvPasport.setText(i.getStringExtra(Constant.USER_PASPORT));
            tvSnils.setText(i.getStringExtra(Constant.USER_SNILS));
            tvPolice.setText(i.getStringExtra(Constant.USER_POLICE));

        }
    }
}

