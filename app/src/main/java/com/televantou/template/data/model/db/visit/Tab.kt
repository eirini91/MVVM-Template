package com.televantou.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Tab : RealmObject() {
    @PrimaryKey

    @SerializedName("tabId")
    @Expose
    var tabId: Long = 0

    @SerializedName("tabOrder ")
    @Expose
    var tabOrder: Long? = null

    @SerializedName("tabName ")
    @Expose
    var tabName: String? = null

    @SerializedName("elements")
    @Expose
    var elements: RealmList<Element>? = null
}
