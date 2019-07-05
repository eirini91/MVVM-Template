package com.televantou.template.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse(@field:Expose
                    @field:SerializedName("access_token")
                    var accessToken: String?) : BaseResponse() {

    @Expose
    @SerializedName("UserID")
    var userId: Long? = null

    @Expose
    @SerializedName("SessionID")
    var sessionID: String? = null
}
