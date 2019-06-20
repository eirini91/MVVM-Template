package com.pkfcooperparry.template.data.model.db.visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class FormList {

    @Getter
    @Setter
    @SerializedName("forms")
    @Expose
    private ArrayList<Form> forms;
}
