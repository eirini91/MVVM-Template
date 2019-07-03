package com.pkfcooperparry.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmObject
import lombok.Getter
import lombok.Setter


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
