package com.pkfcooperparry.template.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class LoginResponse extends BaseResponse {

    @Expose
    @SerializedName("access_token")
    private String accessToken;

    @Expose
    @SerializedName("UserID")
    private Long userId;

    @Expose
    @SerializedName("SessionID")
    private String sessionID;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
