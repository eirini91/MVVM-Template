package com.pkfcooperparry.template.ui.form.page

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.pkfcooperparry.template.BR
import com.pkfcooperparry.template.R
import com.pkfcooperparry.template.databinding.ActivityPageBinding
import com.pkfcooperparry.template.ui.base.BaseActivity
import com.pkfcooperparry.template.utils.Navigator
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class PageActivity : BaseActivity<ActivityPageBinding, PageViewModel>(), PageViewInterface, HasSupportFragmentInjector {
    var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null
        @Inject set

    var navigator: Navigator? = null
        @Inject set

    override var viewModel: PageViewModel? = null
        @Inject set

    internal var activityPageBinding: ActivityPageBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_page

    protected override val actionBarTitle: String?
        get() = null

    protected override val actionBarType: Int
        get() = BaseActivity.KEY_NO_ACTION_BAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.setViewInterface(this, this)
        activityPageBinding = viewDataBinding
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        activityPageBinding!!.tabLayout.layoutManager = layoutManager
        val adapterViewPager = viewModel!!.getTabs(intent.getIntExtra("pageId", -1))?.let { TabPagerAdapter(supportFragmentManager, it) }
        activityPageBinding!!.viewPager.adapter = adapterViewPager

//        val tabPagerAdapter = viewModel!!.getTabs(intent.getIntExtra("pageId", -1))?.let { TabTitlesPagerAdapter(this, { view, position -> activityPageBinding!!.viewPager.currentItem = position }, it) }
//
//        activityPageBinding!!.tabLayout.adapter = tabPagerAdapter
//        activityPageBinding!!.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrolled(i: Int, v: Float, i1: Int) {}
//
//            override fun onPageSelected(i: Int) {
//                if (tabPagerAdapter != null) {
//                    tabPagerAdapter.updateSelected(i)
//                }
//
//            }
//
//            override fun onPageScrollStateChanged(i: Int) {
//
//            }
//        })
    }

    override fun handleError(message: String) {

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {

        fun getCallingIntent(context: Context, pageId: Int): Intent {
            val intent = Intent(context, PageActivity::class.java)
            intent.putExtra("pageId", pageId)
            return intent
        }
    }
}
