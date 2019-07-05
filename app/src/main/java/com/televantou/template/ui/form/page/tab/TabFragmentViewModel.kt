package com.televantou.template.ui.form.page.tab


import android.content.Context

import com.televantou.template.data.DataManager
import com.televantou.template.ui.base.BaseViewModel
import com.televantou.template.utils.rx.SchedulerProvider

class TabFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<TabFragmentViewInterface>(dataManager, schedulerProvider) {

    override fun setViewInterface(context: Context, navigator: TabFragmentViewInterface) {
        super.setViewInterface(context, navigator)
    }


}
