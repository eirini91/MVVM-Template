package com.televantou.template.data.local.db

import com.televantou.template.data.model.db.User
import com.televantou.template.data.model.db.visit.Form
import com.televantou.template.data.model.db.visit.Page
import com.televantou.template.data.model.db.visit.Tab

import io.reactivex.Observable

/**
 * Interface that will include all the DB methods
 */

interface DbHelper {
    val allUsers: Observable<List<User>>

    val user: User?

    val forms: List<Form>

    fun addUser(user: User)

    fun updateUser(user: User, firstName: String, surname: String, sex: Int, age: Int,
                   hometown: String, positionId: Int, phone: String)

    fun deleteAll()

    fun getTab(tabId: Long): Tab?

    fun getFormWithId(formId: Int): Form?

    fun getPageWithId(pageId: Int): Page?

    fun addForms(forms: List<Form>)

}
