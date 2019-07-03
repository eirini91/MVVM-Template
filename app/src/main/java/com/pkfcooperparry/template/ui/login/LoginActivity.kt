package com.pkfcooperparry.template.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle

import com.pkfcooperparry.template.BR
import com.pkfcooperparry.template.R
import com.pkfcooperparry.template.data.model.db.User
import com.pkfcooperparry.template.databinding.ActivityLoginBinding
import com.pkfcooperparry.template.ui.base.BaseActivity
import com.pkfcooperparry.template.ui.custom.CustomDialog
import com.pkfcooperparry.template.utils.Navigator

import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginViewInterface {


    var customDialog: CustomDialog? = null
        @Inject set

 var navigator: Navigator? = null
        @Inject set

    override var viewModel: LoginViewModel? = null
        @Inject set

    internal var activityLoginBinding: ActivityLoginBinding? = null


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_login

    protected override val actionBarTitle: String?
        get() = null

    protected override val actionBarType: Int
        get() = BaseActivity.KEY_NO_ACTION_BAR

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
