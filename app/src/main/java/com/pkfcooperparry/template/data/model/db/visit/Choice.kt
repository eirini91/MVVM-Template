package com.pkfcooperparry.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import lombok.Getter
import lombok.Setter

open class Choice : RealmObject() {
    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: Long? = null
    @SerializedName("value")
    @Expose
    var value: String? = null
}