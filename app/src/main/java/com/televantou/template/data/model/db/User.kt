package com.televantou.template.data.model.db

import com.google.gson.annotations.SerializedName

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Eirini Televantou on 10/19/2018.
 * televantou91@gmail.com
 */
open class User : RealmObject() {
    @PrimaryKey
    @SerializedName("ID")
    var id: Long = 0
    @SerializedName("Name")
    lateinit var name: String
    @SerializedName("Surname")
    lateinit var surname: String
    @SerializedName("Email")
    lateinit var email: String
    @SerializedName("Password")
    lateinit var password: String
    @SerializedName("Avatar")
    lateinit var avatar: String
    @SerializedName("Gender")
    var gender: Int = 0
    @SerializedName("Age")
    var age: Int = 0
    @SerializedName("Phone")
    lateinit var phone: String
    @SerializedName("MainTeam")
    var mainTeam: Int = 0
    @SerializedName("HomeTown")
    lateinit var homeTown: String
    @SerializedName("UsualPosition")
    var usualPosition: Int = 0
    @SerializedName("Error")
    lateinit var error: String
    @SerializedName("dob")
    lateinit var dob: String

    enum class Gender {
        MALE,
        FEMALE
    }
}
