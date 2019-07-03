package com.pkfcooperparry.template.utils


import android.content.Context

import com.pkfcooperparry.template.R
import com.pkfcooperparry.template.ui.base.BaseActivity
import com.pkfcooperparry.template.ui.form.FormActivity
import com.pkfcooperparry.template.ui.form.page.PageActivity
import com.pkfcooperparry.template.ui.login.LoginActivity
import com.pkfcooperparry.template.ui.main.MainActivity


class Navigator {

    fun navigateToSignInView(context: Context) {
        context.startActivity(LoginActivity.getCallingIntent(context))
    }

    fun navigateToMainView(context: Context) {
        context.startActivity(MainActivity.getCallingIntent(context))
        ActivityTransitions.setSlideExitToRightAnimation(context)

    }

    fun navigateToPageView(context: Context, pageId: Int) {
        context.startActivity(PageActivity.getCallingIntent(context, pageId))
        ActivityTransitions.setSlideExitToRightAnimation(context)
    }

    fun navigateToFormView(context: Context, formId: Int) {
        context.startActivity(FormActivity.getCallingIntent(context, formId))
        ActivityTransitions.setSlideExitToRightAnimation(context)
    }

    private object ActivityTransitions {

        internal fun setFadeInOutAnimation(context: Context) {
            if (context is BaseActivity<*, *>) {
                context.overridePendingTransition(
                        R.anim.anim_fade_in, R.anim.anim_fade_out)
            }
        }

        internal fun setSlideExitToRightAnimation(context: Context) {
            if (context is BaseActivity<*, *>) {
                context.overridePendingTransition(
                        R.anim.anim_no_change, R.anim.anim_slide_exit_to_right)
            }
        }
    }
}//Required empty constructor
