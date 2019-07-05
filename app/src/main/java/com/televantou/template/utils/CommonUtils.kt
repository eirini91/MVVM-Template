package com.televantou.template.utils

import android.app.AlertDialog
import android.content.Context
import android.util.DisplayMetrics
import android.util.Patterns
import android.view.LayoutInflater
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object CommonUtils {

    //to convert Date to String, use format method of SimpleDateFormat class.
    val year: String
        get() {
            val dateFormat = SimpleDateFormat("yyyy", Locale.UK)

            return dateFormat.format(Date())
        }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun showLoadingDialog(context: Context): AlertDialog {
        val inflate = LayoutInflater.from(context).inflate(com.televantou.template.R.layout.progress_dialog, null)

        val builder = AlertDialog.Builder(context)
        builder.setCancelable(false) // if you want user to wait for some process to finish,
        builder.setView(inflate)

        return builder.create()
    }

    fun getPrettyDateSimple(context: Context, date: Date): String {
        val is24HourFormat = android.text.format.DateFormat.is24HourFormat(context)

        return if (is24HourFormat) {
            val dateFormat = SimpleDateFormat("E dd/MM HH:mm", Locale.UK)
            dateFormat.format(date)
        } else {
            val dateFormat = SimpleDateFormat("E dd/MM h:mm a", Locale.UK)
            dateFormat.format(date)
        }
    }

    fun getPrettyDateFull(context: Context, date: Date): String {
        val is24HourFormat = android.text.format.DateFormat.is24HourFormat(context)
        if (is24HourFormat) {
            val dateFormat = SimpleDateFormat("E dd/MM/yy HH:mm", Locale.UK)
            return dateFormat.format(date)
        } else {
            val dateFormat = SimpleDateFormat("E dd/MM/yy h:mm a", Locale.UK)
            return dateFormat.format(date)
        }
    }

    fun getPrettyDate(context: Context, date: Date): String {
        val is24HourFormat = android.text.format.DateFormat.is24HourFormat(context)
        if (is24HourFormat) {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.UK)
            return dateFormat.format(date)
        } else {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy a", Locale.UK)
            return dateFormat.format(date)
        }
    }

    fun getPrettyTime(context: Context, date: Date): String {
        val is24HourFormat = android.text.format.DateFormat.is24HourFormat(context)
        if (is24HourFormat) {
            val dateFormat = SimpleDateFormat("HH:mm", Locale.UK)
            return dateFormat.format(date)
        } else {
            val dateFormat = SimpleDateFormat("h:mm a", Locale.UK)
            return dateFormat.format(date)
        }
    }

    fun formatMonth(month: String): String? {
        val monthParse = SimpleDateFormat("MM", Locale.UK)
        val monthDisplay = SimpleDateFormat("MMMM", Locale.UK)
        try {
            return monthDisplay.format(monthParse.parse(month))
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return null
    }


    fun convertPixelsToDp(px: Float, context: Context): Float {
        return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun convertPdToPx(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

}// This utility class is not publicly instantiable
