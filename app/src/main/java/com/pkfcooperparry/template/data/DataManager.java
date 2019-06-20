package com.pkfcooperparry.template.data;


import com.pkfcooperparry.template.data.local.db.DbHelper;
import com.pkfcooperparry.template.data.local.prefs.PreferencesHelper;
import com.pkfcooperparry.template.data.remote.ApiHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void setUserAsLoggedOut();

    void updateApiHeader(Long userId, String accessToken);

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(3);

        private final int type;

        LoggedInMode(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
}
