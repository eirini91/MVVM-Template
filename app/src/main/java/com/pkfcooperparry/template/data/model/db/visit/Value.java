package com.pkfcooperparry.template.data.model.db.visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import lombok.Getter;
import lombok.Setter;

public class Value extends RealmObject {
    @Getter
    @Setter
    @SerializedName("idValue")
    @Expose
    private Long idValue;
    @Getter
    @Setter
    @SerializedName("flatValue")
    @Expose
    private String flatValue;
    @Getter
    @Setter
    @SerializedName("dataValue")
    @Expose
    private Long dataValue;


    public Value() {
    }
}
