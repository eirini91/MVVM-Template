package com.pkfcooperparry.template.data.model.db.visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class Choice extends RealmObject {
    @Getter
    @Setter
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Long id;
    @Getter
    @Setter
    @SerializedName("value")
    @Expose
    private String value;

    public Choice() {
    }
}