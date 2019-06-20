package com.pkfcooperparry.template.data.model.others;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;

public class SideMenuItem {
    @IdRes
    int id;
    String name;
    @DrawableRes
    int icon;

    public SideMenuItem(int id, String name, int icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
