package com.pkfcooperparry.template.data.remote

import com.pkfcooperparry.template.data.remote.ApiClient.Companion.BASE_URL


object ApiEndPoint {

    const val ENDPOINT_LOGIN = """${BASE_URL}login"""
    const val ENDPOINT_USER = """${BASE_URL}user"""
    const val ENDPOINT_LOGOUT = """${BASE_URL}logout"""
}//This class is not publicly instantiable
