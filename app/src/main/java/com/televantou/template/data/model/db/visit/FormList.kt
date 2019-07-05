package com.televantou.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class FormList {


    @SerializedName("forms")
    @Expose
    var forms: ArrayList<Form>? = null
}
