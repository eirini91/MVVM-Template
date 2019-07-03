package com.pkfcooperparry.template.ui.form.page

import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.data.model.db.visit.Tab
import com.pkfcooperparry.template.ui.base.BaseViewModel
import com.pkfcooperparry.template.utils.rx.SchedulerProvider


class PageViewModel internal constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<PageViewInterface>(dataManager, schedulerProvider) {

    fun getTabs(pageId: Int): List<Tab>? {
        return dataManager.getPageWithId(pageId)?.tabs
    }

}
