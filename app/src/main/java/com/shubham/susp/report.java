package com.shubham.susp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.shubham.susp.applist.adapter;
import com.shubham.susp.applist.appinfo;

import java.util.ArrayList;
import java.util.List;

public class report extends AppCompatActivity {
ImageView back;
    ArrayList<appinfo> list = new ArrayList<>();

    RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_report);

        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.recyclerView);


                list = getapps(list);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goback = new Intent(report.this, MainActivity.class);
                startActivity(goback);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new adapter(list));



    }


    public ArrayList<appinfo> getapps(ArrayList<appinfo> list)
    {
        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> packages = packageManager.getInstalledApplications(packageManager.GET_META_DATA);

        for (ApplicationInfo packageinfo :
                packages) {
          if ((packageinfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0)
              continue;
             else
          {
                appinfo app  = new appinfo((String) packageManager.getApplicationLabel(packageinfo), packageManager.getApplicationIcon(packageinfo),packageinfo.packageName);
                list.add(app);
            }

        }

        return list;

    }

    public void onDeleteClick(int position )
    {
        appinfo apptodelte = list.get(position);
        String packageTodelete = apptodelte.getAppname();

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(pm.GET_META_DATA);
        for (ApplicationInfo packaeinfo: packages) {
            if(packaeinfo.packageName.equals(packageTodelete))
            {
                deleteApp(packaeinfo);


            }

        }
    }

    public void deleteApp(ApplicationInfo app)
    {
        Intent delete = new Intent(Intent.ACTION_DELETE);
        delete.setData(Uri.parse("Package name : "+ app.packageName));
        startActivity(delete);
    }
}