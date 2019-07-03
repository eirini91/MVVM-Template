package com.pkfcooperparry.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import lombok.Getter
import lombok.Setter

open class Page : RealmObject() {
    @PrimaryKey

    @SerializedName("pageId")
    @Expose
    var pageId: Long = 0

    @SerializedName("lastModified")
    @Expose
    var lastModified: String? = null

    @SerializedName("version")
    @Expose
    var version: Double? = null

    @SerializedName("pageTitle")
    @Expose
    var pageTitle: String? = null

    @SerializedName("tabs")
    @Expose
    var tabs: RealmList<Tab>? = null

    @SerializedName("image")
    @Expose
    var image: Int = 0
}
