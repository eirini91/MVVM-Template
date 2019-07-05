package com.televantou.template.data.model.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class LoginRequest {

    @Expose
    @SerializedName("email")
    var email: String? = null
        private set

    @Expose
    @SerializedName("password")
    var password: String? = null

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    constructor(email: String) {
        this.email = email
    }

}
