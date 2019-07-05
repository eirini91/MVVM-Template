package com.televantou.template.ui.login

import com.televantou.template.data.model.db.User

interface LoginViewInterface {

    fun handleError(message: String)

    fun login()

    fun openMainActivity(user: User)

}
