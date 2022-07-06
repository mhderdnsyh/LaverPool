package org.xhin.laverpool.rest;

import org.xhin.laverpool.response.ResponseLogin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseLogin> login(
      @Field("username") String username,
      @Field("password") String password
    );

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> register(
//            @Field("id_users") String id_users,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );
}
