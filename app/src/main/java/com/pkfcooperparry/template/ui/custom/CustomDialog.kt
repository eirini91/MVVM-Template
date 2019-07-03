package com.pkfcooperparry.template.ui.custom

import android.app.Activity
import android.app.Dialog
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

import com.pkfcooperparry.template.R

import java.util.Objects

class CustomDialog {

    var dialogInteractionListener: DialogInteractionListener? = null

    fun showDialog(activity: Activity, dialogInteractionListener: DialogInteractionListener, type: Int, title: String, msg: String) {
        this.dialogInteractionListener = dialogInteractionListener
        showDialog(activity, type, title, msg)

    }

    fun showDialog(activity: Activity, type: Int, title: String, msg: String) {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)

        dialog.setContentView(R.layout.view_custom_dialog)
        val window = dialog.window
        Objects.requireNonNull(window).setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        window!!.setBackgroundDrawableResource(android.R.color.transparent)
        window.setGravity(Gravity.CENTER)
        val txtTitle = dialog.findViewById<TextView>(R.id.title)
        txtTitle.text = title

        val subtitle = dialog.findViewById<TextView>(R.id.subtitle)
        subtitle.text = msg

        val btnContinue = dialog.findViewById<Button>(R.id.btnContinue)
        val btnCancel = dialog.findViewById<Button>(R.id.btnCancel)

        if (type == ONE_BUTTON_DIALOG_STYLE) {
            btnCancel.visibility = View.GONE
            btnContinue.text = activity.getString(R.string.okay)
        }

        btnContinue.setOnClickListener { _ ->
            if (dialogInteractionListener != null) {
                dialogInteractionListener!!.onContinue()
            } else
                dialog.dismiss()
        }

        btnCancel.setOnClickListener { _ ->
            if (dialogInteractionListener != null) {
                dialogInteractionListener!!.onCancel()
            } else
                dialog.dismiss()
        }

        dialog.show()

    }

    interface DialogInteractionListener {
        fun onCancel()

        fun onContinue()

    }

    companion object {
        val ONE_BUTTON_DIALOG_STYLE = 0
        val TWO_BUTTON_DIALOG_STYLE = 1
    }

}
