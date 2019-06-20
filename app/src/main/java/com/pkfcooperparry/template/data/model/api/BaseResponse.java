package com.pkfcooperparry.template.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class BaseResponse {

    @Getter
    @Setter
    @Expose
    @SerializedName("Error")
    private String message;


    public BaseResponse() {
    }


}
