package com.pkfcooperparry.template.ui.form.page.tab;


import android.content.Context;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.ui.base.BaseViewModel;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

public class TabFragmentViewModel extends BaseViewModel<TabFragmentViewInterface> {

    public TabFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

    }

    @Override
    public void setViewInterface(Context context, TabFragmentViewInterface navigator) {
        super.setViewInterface(context, navigator);
    }


}
