package com.televantou.template.ui.main

import android.content.Context
import android.databinding.ObservableBoolean
import com.google.gson.Gson
import com.televantou.template.data.DataManager
import com.televantou.template.data.model.db.visit.Form
import com.televantou.template.data.model.db.visit.FormList
import com.televantou.template.ui.base.BaseViewModel
import com.televantou.template.utils.rx.SchedulerProvider
import lombok.Setter
import java.io.IOException
import java.nio.charset.StandardCharsets


class MainViewModel internal constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainViewInterface>(dataManager, schedulerProvider) {
    @Setter
    internal var itemsExist = ObservableBoolean()


    /* Get File in Assets Folder */
    private val assetsJSON: String?
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
            itemsExist.set(true)
            return forms
        }

    init {
        itemsExist.set(false)
    }

    override fun setViewInterface(context: Context, navigator: MainViewInterface) {
        super.setViewInterface(context, navigator)
        saveData()
    }

    fun getItemsExist(): Boolean {
        return itemsExist.get()
    }

    private fun saveData() {
        val jsonString = assetsJSON
        val gson = Gson()
        val page = gson.fromJson(jsonString, FormList::class.java)
        page.forms?.let { dataManager.addForms(it) }
    }


}
