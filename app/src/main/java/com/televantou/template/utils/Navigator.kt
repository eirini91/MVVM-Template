package com.televantou.template.utils


import android.content.Context

import com.televantou.template.R
import com.televantou.template.ui.base.BaseActivity
import com.televantou.template.ui.form.FormActivity
import com.televantou.template.ui.form.page.PageActivity
import com.televantou.template.ui.login.LoginActivity
import com.televantou.template.ui.main.MainActivity


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
