package com.shubham.susp.applist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.susp.R;
import com.shubham.susp.report;

public class holder extends RecyclerView.ViewHolder {
    TextView appname , category;
    ImageView logo;
    ImageView del;
    public holder(@NonNull View itemView) {
        super(itemView);
    appname = itemView.findViewById(R.id.aname);
    category = itemView.findViewById(R.id.cat);
    logo = itemView.findViewById(R.id.alogo);
    del = itemView.findViewById(R.id.deleteApp);

    }
}
