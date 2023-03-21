package com.example.gpshelp2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import  androidx.recyclerview.widget.RecyclerView;

import com.example.gpshelp2.R;
import com.example.gpshelp2.model.Course;
import com.example.gpshelp2.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View profileItems = LayoutInflater.from(context).inflate(R.layout.course_item,parent, false);
        return new CourseAdapter.CourseViewHolder(profileItems);

    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {

        holder.profileBg.setBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_"+ courses.get(position).getImg(),"drawable", context.getPackageName());
        holder.profileImage.setImageResource(imageId);

        holder.familiya_user_profile.setText(courses.get(position).getTitle());
        holder.name_user_profile.setText(courses.get(position).getDate());
        holder.otchestvo_user_profile.setText(courses.get(position).getLevel());

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        LinearLayout profileBg;
        ImageView profileImage;
        TextView familiya_user_profile,name_user_profile,otchestvo_user_profile;

        public CourseViewHolder(@NonNull View itemView) {

            super(itemView);

            profileBg = itemView.findViewById(R.id.profileBg);
            familiya_user_profile = itemView.findViewById(R.id.familiya_user_profile);
            name_user_profile = itemView.findViewById(R.id.name_user_profile);
            otchestvo_user_profile = itemView.findViewById(R.id.otchestvo_user_profile);
            profileImage = itemView.findViewById(R.id.profileimage);

        }
    }
}