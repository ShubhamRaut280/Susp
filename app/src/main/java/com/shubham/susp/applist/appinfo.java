package com.shubham.susp.applist;

import android.graphics.drawable.Drawable;

public class appinfo {
    private String appname;
    Drawable applogo;
     String category;

    public appinfo(String appname, Drawable applogo, String category) {
        this.appname = appname;
        this.applogo = applogo;
        this.category = category;
    }


    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public Drawable getApplogo() {
        return applogo;
    }

    public void setApplogo(Drawable applogo) {
        this.applogo = applogo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
