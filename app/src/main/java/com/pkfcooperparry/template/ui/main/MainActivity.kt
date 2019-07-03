package com.pkfcooperparry.template.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.pkfcooperparry.template.BR
import com.pkfcooperparry.template.R
import com.pkfcooperparry.template.databinding.ActivityMainBinding
import com.pkfcooperparry.template.ui.base.BaseActivity
import com.pkfcooperparry.template.utils.Navigator
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainViewInterface {

    var navigator: Navigator? = null
        @Inject set

    override var viewModel: MainViewModel? = null
        @Inject set

    internal var activityMainBinding: ActivityMainBinding? = null


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    protected override val actionBarTitle: String?
        get() = null

    protected override val actionBarType: Int
        get() = BaseActivity.KEY_NO_ACTION_BAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.setViewInterface(this, this)
        activityMainBinding = viewDataBinding
        activityMainBinding!!.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun handleError(message: String) {

    }

    override fun openVisitPage(visitId: Int) {}

    companion object {

        fun getCallingIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }


}
