package com.pkfcooperparry.template.data


import com.pkfcooperparry.template.data.local.db.DbHelper
import com.pkfcooperparry.template.data.local.prefs.PreferencesHelper
import com.pkfcooperparry.template.data.remote.ApiHelper

interface DataManager : DbHelper, PreferencesHelper, ApiHelper {

    fun setUserAsLoggedOut()

    fun updateApiHeader(userId: Long?, accessToken: String)

    fun updateUserInfo(
            accessToken: String?,
            userId: Long?,
            loggedInMode: LoggedInMode,
            userName: String?,
            email: String?,
            profilePicPath: String?)

    enum class LoggedInMode private constructor(val type: Int) {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(3)
    }
}
