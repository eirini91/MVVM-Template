package com.pkfcooperparry.template.ui.main

import android.content.Context
import android.databinding.ObservableBoolean

import com.google.gson.Gson
import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.data.model.db.visit.Form
import com.pkfcooperparry.template.data.model.db.visit.FormList
import com.pkfcooperparry.template.ui.base.BaseViewModel
import com.pkfcooperparry.template.ui.login.LoginActivity
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

import java.io.IOException
import java.nio.charset.StandardCharsets

import lombok.Getter
import lombok.Setter


class MainViewModel internal constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainViewInterface>(dataManager, schedulerProvider) {
    @Setter
    internal var itemsExist = ObservableBoolean()



    /* Get File in Assets Folder */
    val assetsJSON: String?
        get() {
            var json: String? = null
            try {
                val inputStream = context!!.assets.open("example_json.json")
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, StandardCharsets.UTF_8)

            } catch (e: IOException) {
                e.printStackTrace()
            }

            return json
        }

    val forms: List<Form>?
        get() {
            val forms = dataManager.forms
            if (forms != null) {
                itemsExist.set(true)
            }
            return forms
        }

    init {
        itemsExist.set(false)
    }

    override fun setViewInterface(context: Context, navigator: MainViewInterface) {
        super.setViewInterface(context, navigator)
        saveData()
    }

    fun  getItemsExist():Boolean{
        return itemsExist.get()
    }

    fun saveData() {
        val jsonString = assetsJSON
        val gson = Gson()
        val page = gson.fromJson<FormList>(jsonString, FormList::class.java)
        page.forms?.let { dataManager.addForms(it) }
    }


}
