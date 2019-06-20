package com.pkfcooperparry.template.data.model.db.visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class Tab extends RealmObject {
    @PrimaryKey
    @Getter
    @Setter
    @SerializedName("tabId")
    @Expose
    private long tabId;
    @Getter
    @Setter
    @SerializedName("tabOrder ")
    @Expose
    private Long tabOrder;
    @Getter
    @Setter
    @SerializedName("tabName ")
    @Expose
    private String tabName;
    @Getter
    @Setter
    @SerializedName("elements")
    @Expose
    private RealmList<Element> elements = null;

    public Tab() {
    }
}
