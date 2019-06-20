package com.pkfcooperparry.template.data.remote;

import com.pkfcooperparry.template.data.model.api.BaseResponse;
import com.pkfcooperparry.template.data.model.api.LoginResponse;
import com.pkfcooperparry.template.data.model.db.User;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.pkfcooperparry.template.data.remote.ApiEndPoint.ENDPOINT_LOGIN;
import static com.pkfcooperparry.template.data.remote.ApiEndPoint.ENDPOINT_LOGOUT;
import static com.pkfcooperparry.template.data.remote.ApiEndPoint.ENDPOINT_USER;


public interface ApiHelper {

    @Headers({ApiClient.HEADER_ACCEPT_JSON, ApiClient.HEADER_CONTENT_TYPE_JSON})
    @POST(ENDPOINT_LOGIN)
    Single<LoginResponse> signIn(@Query("email") String email, @Query("password") String password);

    @Headers({ApiClient.HEADER_ACCEPT_JSON, ApiClient.HEADER_CONTENT_TYPE_JSON})
    @GET(ENDPOINT_USER)
    Single<User> getUserData(@Header("Authorization") String token, @Query("userId") long userId);

    @Headers({ApiClient.HEADER_ACCEPT_JSON, ApiClient.HEADER_CONTENT_TYPE_JSON})
    @GET(ENDPOINT_LOGOUT + "/{userId}")
    Single<BaseResponse> logout(@Header("Authorization") String token, @Path("userId") long userId);

}
