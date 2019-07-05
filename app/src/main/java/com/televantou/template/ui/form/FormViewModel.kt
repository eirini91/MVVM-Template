package com.televantou.template.ui.form

import android.databinding.ObservableBoolean
import android.databinding.ObservableField

import com.televantou.template.data.DataManager
import com.televantou.template.data.model.db.visit.Form
import com.televantou.template.ui.base.BaseViewModel
import com.televantou.template.utils.rx.SchedulerProvider


class FormViewModel internal constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<FormViewInterface>(dataManager, schedulerProvider) {

    var formId = ObservableField<String>()

    internal var itemsExist = ObservableBoolean()

    init {
        itemsExist.set(false)
        formId.set("10789")
    }

    fun getItemsExist():Boolean{
        return itemsExist.get()
    }

    fun onBackClick() {
         getViewInterface().goBack()
    }


    fun getFormWithId(formId: Int): Form? {
        val form = dataManager.getFormWithId(formId)
        if (form == null) {
            this.formId.set("-")
            itemsExist.set(false)
        } else {
            this.formId.set(formId.toString() + "")

            itemsExist.set(true)
        }

        return form
    }
}
