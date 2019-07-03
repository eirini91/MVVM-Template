package com.pkfcooperparry.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import lombok.Getter
import lombok.Setter

open class Form : RealmObject() {
    @PrimaryKey

    @SerializedName("id")
    @Expose
    var id: Long = 0

    @SerializedName("pages")
    @Expose
    var pages: RealmList<Page>? = null
}
