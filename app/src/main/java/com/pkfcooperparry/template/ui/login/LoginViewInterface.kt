package com.pkfcooperparry.template.ui.login

import com.pkfcooperparry.template.data.model.db.User

interface LoginViewInterface {

    fun handleError(message: String)

    fun login()

    fun openMainActivity(user: User)

}
