package com.televantou.template.data.remote

import com.televantou.template.data.model.api.BaseResponse
import com.televantou.template.data.model.api.LoginResponse
import com.televantou.template.data.model.db.User
import com.televantou.template.data.remote.ApiClient.Companion.HEADER_ACCEPT_JSON
import com.televantou.template.data.remote.ApiClient.Companion.HEADER_CONTENT_TYPE_JSON
import com.televantou.template.data.remote.ApiEndPoint.ENDPOINT_LOGIN
import com.televantou.template.data.remote.ApiEndPoint.ENDPOINT_LOGOUT
import com.televantou.template.data.remote.ApiEndPoint.ENDPOINT_USER
import io.reactivex.Single
import retrofit2.http.*


interface ApiHelper {

    @Headers(HEADER_ACCEPT_JSON, HEADER_CONTENT_TYPE_JSON)
    @POST(ENDPOINT_LOGIN)
    fun signIn(@Query("email") email: String, @Query("password") password: String): Single<LoginResponse>

    @Headers(HEADER_ACCEPT_JSON, HEADER_CONTENT_TYPE_JSON)
    @GET(ENDPOINT_USER)
    fun getUserData(@Header("Authorization") token: String?, @Query("userId") userId: Long): Single<User>

    @Headers(HEADER_ACCEPT_JSON, HEADER_CONTENT_TYPE_JSON)
    @GET("$ENDPOINT_LOGOUT/{userId}")
    fun logout(@Header("Authorization") token: String, @Path("userId") userId: Long): Single<BaseResponse>

}
