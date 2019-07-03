package com.pkfcooperparry.template.data.local.prefs


import com.pkfcooperparry.template.data.DataManager

interface PreferencesHelper {

    var accessToken: String?

    var currentUserEmail: String?

    var currentUserId: Long?

    var currentUserName: String?

    val currentUserLoggedInMode: Int

    val isLoggedIn: Boolean

    fun setAccessTokenAndUserId(accessToken: String, userId: Long)

    fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode)

}
