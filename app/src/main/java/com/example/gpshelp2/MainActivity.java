package com.example.gpshelp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gpshelp2.adapter.CategoryAdapter;
import com.example.gpshelp2.adapter.CourseAdapter;
import com.example.gpshelp2.model.Category;
import com.example.gpshelp2.model.Course;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler,courseRecycler;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;
    Button button_profile,button_gps,button_more,button_more2,button_vhod,button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_profile = findViewById(R.id.button_profile);
        button_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReadActivity.class);
                startActivity(intent);
            }

        });
        button_gps = findViewById(R.id.button_gps);
        button_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GpsMapActivity.class);
                startActivity(intent);
            }
        });
        button_more = findViewById(R.id.button_more);
        button_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoreInformafionActivity.class);
                startActivity(intent);
            }
        });

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Профиль"));
        categoryList.add(new Category(2, "GPS"));
        categoryList.add(new Category(3, "Подробнее"));
        categoryList.add(new Category(4, "Документы"));

        setCategoryRecycler(categoryList);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}