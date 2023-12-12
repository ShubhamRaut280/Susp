package com.shubham.susp.applist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.susp.R;
import com.shubham.susp.report;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<holder> {
    ArrayList<appinfo> applist = new ArrayList<>();
    public adapter(ArrayList<appinfo> aplist)
    {
        this.applist = aplist;
    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.applayout, parent, false);
        return new holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        appinfo app = applist.get(position);
        holder.appname.setText(app.getAppname());
        holder.category.setText(app.getCategory());
        holder.logo.setImageDrawable(app.getApplogo());

    }

    @Override
    public int getItemCount() {
        return applist.size();
    }
}

