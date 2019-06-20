package com.pkfcooperparry.template.data.model.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pkfcooperparry.template.data.model.db.User;


public final class UserRequest {

    @Expose
    @SerializedName("user")
    private User user;

    public UserRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
