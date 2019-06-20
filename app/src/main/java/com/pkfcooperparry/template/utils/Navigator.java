package com.pkfcooperparry.template.utils;


import android.content.Context;
import android.support.annotation.NonNull;

import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.ui.base.BaseActivity;
import com.pkfcooperparry.template.ui.form.FormActivity;
import com.pkfcooperparry.template.ui.form.page.PageActivity;
import com.pkfcooperparry.template.ui.login.LoginActivity;
import com.pkfcooperparry.template.ui.main.MainActivity;


public class Navigator {

    public Navigator() {
        //Required empty constructor
    }

    public void navigateToSignInView(@NonNull Context context) {
        context.startActivity(LoginActivity.getCallingIntent(context));
    }

    public void navigateToMainView(@NonNull Context context) {
        context.startActivity(MainActivity.getCallingIntent(context));
        ActivityTransitions.setSlideExitToRightAnimation(context);

    }

    public void navigateToPageView(@NonNull Context context, int pageId) {
        context.startActivity(PageActivity.getCallingIntent(context, pageId));
        ActivityTransitions.setSlideExitToRightAnimation(context);
    }

    public void navigateToFormView(@NonNull Context context, int formId) {
        context.startActivity(FormActivity.getCallingIntent(context, formId));
        ActivityTransitions.setSlideExitToRightAnimation(context);
    }

    private static class ActivityTransitions {

        static void setFadeInOutAnimation(@NonNull Context context) {
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).overridePendingTransition(
                        R.anim.anim_fade_in, R.anim.anim_fade_out);
            }
        }

        static void setSlideExitToRightAnimation(@NonNull Context context) {
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).overridePendingTransition(
                        R.anim.anim_no_change, R.anim.anim_slide_exit_to_right);
            }
        }
    }
}
