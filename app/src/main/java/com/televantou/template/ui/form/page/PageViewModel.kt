package com.televantou.template.ui.form.page

import com.televantou.template.data.DataManager
import com.televantou.template.data.model.db.visit.Tab
import com.televantou.template.ui.base.BaseViewModel
import com.televantou.template.utils.rx.SchedulerProvider


class PageViewModel internal constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<PageViewInterface>(dataManager, schedulerProvider) {

    fun getTabs(pageId: Int): List<Tab>? {
        return dataManager.getPageWithId(pageId)?.tabs
    }

}
