package com.televantou.template.ui.form

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager

import com.televantou.template.BR
import com.televantou.template.R
import com.televantou.template.databinding.ActivityFormBinding
import com.televantou.template.ui.base.BaseActivity
import com.televantou.template.ui.custom.CustomDialog
import com.televantou.template.utils.Navigator

import javax.inject.Inject

class FormActivity : BaseActivity<ActivityFormBinding, FormViewModel>(), FormViewInterface {

   var customDialog: CustomDialog? = null
        @Inject   set
     var navigator: Navigator? = null
        @Inject   set

    override var viewModel: FormViewModel? = null
        @Inject   set

    internal var activityFormBinding: ActivityFormBinding? = null


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_form

    protected override val actionBarTitle: String?
        get() = null

    protected override val actionBarType: Int
        get() = BaseActivity.KEY_NO_ACTION_BAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel!!.setViewInterface(this, this)
        activityFormBinding = viewDataBinding

        activityFormBinding!!.recyclerView.layoutManager = GridLayoutManager(this, 5)
//        val pageAdapter = viewModel!!.getFormWithId(intent.getIntExtra("formId", -1))!!.pages?.let {
//            PageAdapter(this, PageAdapter.ItemClickListener {
//            override fun onItemClick(page: Page) {
//                navigator!!.navigateToPageView(this@FormActivity, page.pageId.toInt())
//            }
//        }, it)
//        }
//        activityFormBinding!!.recyclerView.adapter = pageAdapter
    }

    override fun handleError(message: String) {
        customDialog!!.showDialog(this, CustomDialog.ONE_BUTTON_DIALOG_STYLE, getString(R.string.something_went_wrong), message)

    }

    override fun goBack() {
        finish()
    }

    override fun openRequests() {

    }

    override fun openActionPlan() {

    }

    companion object {

        fun getCallingIntent(context: Context, formId: Int): Intent {
            val intent = Intent(context, FormActivity::class.java)
            intent.putExtra("formId", formId)
            return intent
        }
    }

}
