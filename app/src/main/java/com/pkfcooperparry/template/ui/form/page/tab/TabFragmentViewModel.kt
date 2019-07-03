package com.pkfcooperparry.template.ui.form.page.tab


import android.content.Context

import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.ui.base.BaseViewModel
import com.pkfcooperparry.template.ui.login.LoginActivity
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

class TabFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<TabFragmentViewInterface>(dataManager, schedulerProvider) {

    override fun setViewInterface(context: Context, navigator: TabFragmentViewInterface) {
        super.setViewInterface(context, navigator)
    }


}
