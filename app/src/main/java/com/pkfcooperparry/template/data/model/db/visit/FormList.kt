package com.pkfcooperparry.template.data.model.db.visit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

import lombok.Getter
import lombok.Setter

class FormList {


    @SerializedName("forms")
    @Expose
    var forms: ArrayList<Form>? = null
}
