package com.pkfcooperparry.template.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import java.util.Objects

/**
 * Created by Eirini Televantou on 10/26/2018.
 * televantou91@gmail.com
 */
object DataBindingUtils {

    fun lastVisibleItemPosition(recyclerView: RecyclerView): Int {
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        return Objects.requireNonNull(layoutManager).findLastVisibleItemPosition()
    }
}
