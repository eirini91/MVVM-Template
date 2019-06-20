package com.pkfcooperparry.template.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Objects;

/**
 * Created by Eirini Televantou on 10/26/2018.
 * televantou91@gmail.com
 */
public class DataBindingUtils {

    public static int lastVisibleItemPosition(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        return Objects.requireNonNull(layoutManager).findLastVisibleItemPosition();
    }
}
