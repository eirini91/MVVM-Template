package com.televantou.template.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.*

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
