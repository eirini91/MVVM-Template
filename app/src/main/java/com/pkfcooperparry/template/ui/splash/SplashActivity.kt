package com.pkfcooperparry.template.ui.splash

import android.os.Bundle
import android.os.Handler

import com.pkfcooperparry.template.BR
import com.pkfcooperparry.template.R
import com.pkfcooperparry.template.databinding.ActivitySplashBinding
import com.pkfcooperparry.template.ui.base.BaseActivity
import com.pkfcooperparry.template.utils.Navigator

import javax.inject.Inject


class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashViewInterface {

    override var viewModel: SplashViewModel? = null
        @Inject set

    var navigator: Navigator? = null
        @Inject set

    override val bindingVariable: Int
        get() = BR.viewModel

    protected override val actionBarTitle: String?
        get() = null

    protected override val actionBarType: Int
        get() = BaseActivity.KEY_NO_ACTION_BAR

    override val layoutId: Int
        get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.setViewInterface(this, this)
        val handler = Handler()
        handler.postDelayed({ viewModel!!.decideNextActivity() }, SPLASH_DISPLAY_LENGTH.toLong())
    }


    override fun openLoginActivity() {
        navigator!!.navigateToSignInView(this)
    }

    override fun openMainActivity() {
        navigator!!.navigateToMainView(this)
    }

    companion object {
        private val SPLASH_DISPLAY_LENGTH = 1000
    }
}
