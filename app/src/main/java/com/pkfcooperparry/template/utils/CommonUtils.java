package com.pkfcooperparry.template.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Patterns;

import com.pkfcooperparry.template.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public final class CommonUtils {

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static String getPrettyDateSimple(Context context, Date date) {
        Boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(context);

        if (is24HourFormat) {
            DateFormat dateFormat = new SimpleDateFormat("E dd/MM HH:mm", Locale.UK);
            return dateFormat.format(date);
        } else {
            DateFormat dateFormat = new SimpleDateFormat("E dd/MM h:mm a", Locale.UK);
            return dateFormat.format(date);
        }
    }

    public static String getPrettyDateFull(Context context, Date date) {
        Boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(context);
        if (is24HourFormat) {
            DateFormat dateFormat = new SimpleDateFormat("E dd/MM/yy HH:mm", Locale.UK);
            return dateFormat.format(date);
        } else {
            DateFormat dateFormat = new SimpleDateFormat("E dd/MM/yy h:mm a", Locale.UK);
            return dateFormat.format(date);
        }
    }

    public static String getPrettyDate(Context context, Date date) {
        Boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(context);
        if (is24HourFormat) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
            return dateFormat.format(date);
        } else {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy a", Locale.UK);
            return dateFormat.format(date);
        }
    }

    public static String getYear() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.UK);
        //to convert Date to String, use format method of SimpleDateFormat class.

        return dateFormat.format(new Date());
    }

    public static String getPrettyTime(Context context, Date date) {
        Boolean is24HourFormat = android.text.format.DateFormat.is24HourFormat(context);
        if (is24HourFormat) {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.UK);
            return dateFormat.format(date);
        } else {
            DateFormat dateFormat = new SimpleDateFormat("h:mm a", Locale.UK);
            return dateFormat.format(date);
        }
    }

    public static String formatMonth(String month) {
        SimpleDateFormat monthParse = new SimpleDateFormat("MM", Locale.UK);
        SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM", Locale.UK);
        try {
            return monthDisplay.format(monthParse.parse(month));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static float convertPixelsToDp(float px, Context context) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static float convertPdToPx(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

}
