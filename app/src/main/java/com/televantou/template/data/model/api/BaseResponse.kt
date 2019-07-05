package com.televantou.template.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class BaseResponse {


    @Expose
    @SerializedName("Error")
    var message: String? = null


}
