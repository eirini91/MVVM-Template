package com.pkfcooperparry.template.data.model.db.visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class Page extends RealmObject {
    @PrimaryKey
    @Getter
    @Setter
    @SerializedName("pageId")
    @Expose
    private long pageId;
    @Getter
    @Setter
    @SerializedName("lastModified")
    @Expose
    private String lastModified;
    @Getter
    @Setter
    @SerializedName("version")
    @Expose
    private Double version;
    @Getter
    @Setter
    @SerializedName("pageTitle")
    @Expose
    private String pageTitle;
    @Getter
    @Setter
    @SerializedName("tabs")
    @Expose
    private RealmList<Tab> tabs = null;
    @Getter
    @Setter
    @SerializedName("image")
    @Expose
    private int image;

    public Page() {
    }
}
