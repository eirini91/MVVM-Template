package com.pkfcooperparry.template.ui.form.page;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.data.model.db.visit.Tab;
import com.pkfcooperparry.template.ui.base.BaseViewModel;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import java.util.List;


public class PageViewModel extends BaseViewModel<PageViewInterface> {

    PageViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public List<Tab> getTabs(int pageId) {
        return getDataManager().getPageWithId(pageId).getTabs();
    }

}
