package com.pkfcooperparry.template.data.model.db.visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class Form extends RealmObject {
    @PrimaryKey
    @Getter
    @Setter
    @SerializedName("id")
    @Expose
    private long id;


    @Getter
    @Setter
    @SerializedName("pages")
    @Expose
    private RealmList<Page> pages = null;

    public Form() {
    }
}
