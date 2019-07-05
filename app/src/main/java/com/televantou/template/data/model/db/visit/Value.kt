package com.televantou.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmObject


open class Value : RealmObject() {

    @SerializedName("idValue")
    @Expose
    var idValue: Long? = null

    @SerializedName("flatValue")
    @Expose
    var flatValue: String? = null

    @SerializedName("dataValue")
    @Expose
    var dataValue: Long? = null
}
