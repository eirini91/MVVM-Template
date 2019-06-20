package com.pkfcooperparry.template.ui.custom;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.pkfcooperparry.template.R;

import java.util.Objects;

public class CustomDialog {
    public static final int ONE_BUTTON_DIALOG_STYLE = 0;
    public static final int TWO_BUTTON_DIALOG_STYLE = 1;

    DialogInteractionListener dialogInteractionListener;

    public void showDialog(Activity activity, DialogInteractionListener dialogInteractionListener, int type, String title, String msg) {
        setDialogInteractionListener(dialogInteractionListener);
        showDialog(activity, type, title, msg);

    }

    public void showDialog(Activity activity, int type, String title, String msg) {

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.view_custom_dialog);
        Window window = dialog.getWindow();
        Objects.requireNonNull(window).setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.CENTER);
        TextView txtTitle = dialog.findViewById(R.id.title);
        txtTitle.setText(title);

        TextView subtitle = dialog.findViewById(R.id.subtitle);
        subtitle.setText(msg);

        Button btnContinue = dialog.findViewById(R.id.btnContinue);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        if (type == ONE_BUTTON_DIALOG_STYLE) {
            btnCancel.setVisibility(View.GONE);
            btnContinue.setText(activity.getString(R.string.okay));
        }

        btnContinue.setOnClickListener(v -> {
            if (dialogInteractionListener != null) {
                dialogInteractionListener.onContinue();
            } else
                dialog.dismiss();
        });

        btnCancel.setOnClickListener(v -> {
            if (dialogInteractionListener != null) {
                dialogInteractionListener.onCancel();
            } else
                dialog.dismiss();
        });

        dialog.show();

    }

    public DialogInteractionListener getDialogInteractionListener() {
        return dialogInteractionListener;
    }

    public void setDialogInteractionListener(DialogInteractionListener dialogInteractionListener) {
        this.dialogInteractionListener = dialogInteractionListener;
    }

    public interface DialogInteractionListener {
        void onCancel();

        void onContinue();

    }

}
