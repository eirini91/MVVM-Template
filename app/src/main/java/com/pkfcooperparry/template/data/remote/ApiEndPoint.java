package com.pkfcooperparry.template.data.remote;


public final class ApiEndPoint {

    public static final String ENDPOINT_LOGIN = ApiClient.BASE_URL + "login";
    public static final String ENDPOINT_USER = ApiClient.BASE_URL + "user";
    public static final String ENDPOINT_LOGOUT = ApiClient.BASE_URL + "logout";

    private ApiEndPoint() {
        //This class is not publicly instantiable
    }
}
