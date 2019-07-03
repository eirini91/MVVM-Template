package com.pkfcooperparry.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import lombok.Getter
import lombok.Setter

open class Element : RealmObject() {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    var id: Long = 0

    @SerializedName("elementType")
    @Expose
    var elementType: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("enabled")
    @Expose
    var enabled: Boolean? = false

    @SerializedName("hint")
    @Expose
    var hint: String? = null

    @SerializedName("choices")
    @Expose
    var choices: RealmList<Choice>? = null

    @SerializedName("defaultValue")
    @Expose
    var defaultValue: Value? = null
    @SerializedName("enabledWhen")
    @Expose
    var enabledWhen: Condition? = null
    @SerializedName("showWhen")
    @Expose
    var showWhen: Condition? = null
    @SerializedName("moreInfoElement")
    @Expose
    var moreInfoElement: Element? = null
    @SerializedName("autoSelectCheckboxes")
    @Expose
    var autoSelectCheckboxes: RealmList<Long>? = null
    @SerializedName("updateGroup")
    @Expose
    var updateGroup: RealmList<Long>? = null
    @SerializedName("autoSelectDropdown")
    @Expose
    var autoSelectDropdown: Long? = null
}
