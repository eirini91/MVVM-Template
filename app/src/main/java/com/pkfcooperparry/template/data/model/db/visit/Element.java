package com.pkfcooperparry.template.data.model.db.visit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class Element extends RealmObject {
    @Getter
    @Setter
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private long id;
    @Getter
    @Setter
    @SerializedName("elementType")
    @Expose
    private String elementType;
    @Getter
    @Setter
    @SerializedName("name")
    @Expose
    private String name;
    @Getter
    @Setter
    @SerializedName("enabled")
    @Expose
    private Boolean enabled = false;
    @Getter
    @Setter
    @SerializedName("hint")
    @Expose
    private String hint;
    @Getter
    @Setter
    @SerializedName("choices")
    @Expose
    private RealmList<Choice> choices = null;
    @Getter
    @Setter
    @SerializedName("defaultValue")
    @Expose
    private Value defaultValue;
    @Getter
    @Setter
    @SerializedName("enabledWhen")
    @Expose
    private Condition enabledWhen;
    @Getter
    @Setter
    @SerializedName("showWhen")
    @Expose
    private Condition showWhen;
    @Getter
    @Setter
    @SerializedName("moreInfoElement")
    @Expose
    private Element moreInfoElement;
    @Getter
    @Setter
    @SerializedName("autoSelectCheckboxes")
    @Expose
    private RealmList<Long> autoSelectCheckboxes = null;
    @Getter
    @Setter
    @SerializedName("updateGroup")
    @Expose
    private RealmList<Long> updateGroup;
    @Getter
    @Setter
    @SerializedName("autoSelectDropdown")
    @Expose
    private Long autoSelectDropdown;

    public Element() {
    }
}
