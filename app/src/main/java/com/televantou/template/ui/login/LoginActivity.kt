package com.televantou.template.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle

import com.televantou.template.BR
import com.televantou.template.R
import com.televantou.template.data.model.db.User
import com.televantou.template.databinding.ActivityLoginBinding
import com.televantou.template.ui.base.BaseActivity
import com.televantou.template.ui.custom.CustomDialog
import com.televantou.template.utils.Navigator

import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginViewInterface {


    private var customDialog: CustomDialog? = null
        @Inject set

    private var navigator: Navigator? = null
        @Inject set

    override var viewModel: LoginViewModel? = null
        @Inject set

    private var activityLoginBinding: ActivityLoginBinding? = null


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_login

    override val actionBarTitle: String?
        get() = null

    override val actionBarType: Int
        get() = KEY_NO_ACTION_BAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = viewDataBinding
        viewModel!!.setViewInterface(this, this)

    }

    override fun handleError(message: String) {
        customDialog!!.showDialog(this, CustomDialog.ONE_BUTTON_DIALOG_STYLE, getString(R.string.something_went_wrong), message)
    }

    override fun login() {
        viewModel!!.login()
    }

    override fun openMainActivity(user: User) {
        navigator!!.navigateToMainView(this)
    }

    companion object {

        fun getCallingIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

}
