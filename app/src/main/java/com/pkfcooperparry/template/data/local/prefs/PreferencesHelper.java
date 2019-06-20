package com.pkfcooperparry.template.data.local.prefs;


import com.pkfcooperparry.template.data.DataManager;

public interface PreferencesHelper {

    String getAccessToken();

    void setAccessToken(String accessToken);

    void setAccessTokenAndUserId(String accessToken, long userId);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    boolean isLoggedIn();

}
