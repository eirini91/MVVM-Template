package com.pkfcooperparry.template.data.model.db.visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class Condition extends RealmObject {
    @Getter
    @Setter
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Long id;
    @Getter
    @Setter
    @SerializedName("elementId")
    @Expose
    private Long elementId;
    @Getter
    @Setter
    @SerializedName("type")
    @Expose
    private String type;
    @Getter
    @Setter
    @SerializedName("value")
    @Expose
    private Value value;

    public Condition() {
    }
}
