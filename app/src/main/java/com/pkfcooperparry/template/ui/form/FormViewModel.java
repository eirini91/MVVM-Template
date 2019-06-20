package com.pkfcooperparry.template.ui.form;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.data.model.db.visit.Form;
import com.pkfcooperparry.template.ui.base.BaseViewModel;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import lombok.Getter;
import lombok.Setter;


public class FormViewModel extends BaseViewModel<FormViewInterface> {
    @Getter
    @Setter
    public ObservableField<String> formId = new ObservableField<>();
    @Getter
    @Setter
    ObservableBoolean itemsExist = new ObservableBoolean();


    FormViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        itemsExist.set(false);
        formId.set("10789");
    }

    public void onBackClick() {
        getViewInterface().goBack();
    }


    public Form getFormWithId(int formId) {
        Form form = getDataManager().getFormWithId(formId);
        if (form == null) {
            this.formId.set("-");
            itemsExist.set(false);
        } else {
            this.formId.set(formId + "");

            itemsExist.set(true);
        }

        return form;
    }
}
