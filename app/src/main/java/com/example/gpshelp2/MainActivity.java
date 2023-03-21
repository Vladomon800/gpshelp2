package com.example.gpshelp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Профиль"));
        categoryList.add(new Category(2, "GPS"));
        categoryList.add(new Category(3, "Подробнее"));
        categoryList.add(new Category(4, "Документы"));

        setCategoryRecycler(categoryList);

       List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "free_icon_user_profile_2734847","\nf","1 января","начальный","#FFFFFFFF"));
        Course a = new Course(1, "free_icon_user_profile_2734847","\nf","1 января","начальный","#FFFFFFFF");

        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Course> courseList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this,courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }
}