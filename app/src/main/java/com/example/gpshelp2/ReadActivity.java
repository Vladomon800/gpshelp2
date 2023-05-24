package com.example.gpshelp2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<user_informathion> listTemp;

    private DatabaseReference mDataBase;
    private String USER_KEY = "USER";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_layout);
        init();
        getDataFromDB();
        setOnClickItem();
    }
    private void init()
    {
        listView = findViewById(R.id.listView);
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);
        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }
    private void getDataFromDB()
    {
        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(listData.size() > 0)listData.clear();
                if(listTemp.size() > 0)listTemp.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    user_informathion USER = ds.getValue(user_informathion.class);
                    assert USER != null;
                    listData.add(USER.name);
                    listTemp.add(USER);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDataBase.addValueEventListener(vListener);
    }
    private void setOnClickItem()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                user_informathion USER = listTemp.get(position);
                Intent i = new Intent(ReadActivity.this, ShowActivity.class);
                i.putExtra(Constant.USER_NAME,USER.name);
                i.putExtra(Constant.USER_SEC_NAME,USER.sec_name);
                i.putExtra(Constant.USER_OTCHESTVO,USER.otchestvo);
                i.putExtra(Constant.USER_DATAROJDEN,USER.datarojden);
                i.putExtra(Constant.USER_ADRESS,USER.adress);
                i.putExtra(Constant.USER_PASPORT,USER.pasport);
                i.putExtra(Constant.USER_SNILS,USER.snils);
                i.putExtra(Constant.USER_POLICE,USER.police);
                startActivity(i);

            }
        });
    }

}