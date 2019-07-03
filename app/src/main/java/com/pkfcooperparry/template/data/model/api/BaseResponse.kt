package com.pkfcooperparry.template.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import lombok.Getter
import lombok.Setter


open class BaseResponse {


    @Expose
    @SerializedName("Error")
    var message: String? = null


}
