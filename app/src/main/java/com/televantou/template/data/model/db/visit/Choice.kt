package com.televantou.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Choice : RealmObject() {
    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: Long? = null
    @SerializedName("value")
    @Expose
    var value: String? = null
}