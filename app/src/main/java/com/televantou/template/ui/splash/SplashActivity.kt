package com.televantou.template.ui.splash

import android.os.Bundle
import android.os.Handler

import com.televantou.template.BR
import com.televantou.template.R
import com.televantou.template.databinding.ActivitySplashBinding
import com.televantou.template.ui.base.BaseActivity
import com.televantou.template.utils.Navigator

import javax.inject.Inject


class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(), SplashViewInterface {

    override var viewModel: SplashViewModel? = null
        @Inject set

    private var navigator: Navigator? = null
        @Inject set

    override val bindingVariable: Int
        get() = BR.viewModel

    override val actionBarTitle: String?
        get() = null

    override val actionBarType: Int
        get() = KEY_NO_ACTION_BAR

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
        private const val SPLASH_DISPLAY_LENGTH = 1000
    }
}
