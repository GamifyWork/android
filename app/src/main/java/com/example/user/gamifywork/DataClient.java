package com.example.user.gamifywork;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by user on 10.08.2017.
 */

public interface DataClient {

    @GET("{user}")
    Call<DataObject> reposForUser(@Path("user")String user);

    @FormUrlEncoded
    @GET("task")
    Call<List<Task>> getTask(@Query("account_id") int id);

    @FormUrlEncoded
    @POST("register")
    Call<ResponseToken> registerData(@Field("email")String name, @Field("password")String password);

    @FormUrlEncoded
    @POST("login")
    Call<ResponseToken> loginData(@Field("email")String name, @Field("password")String password);

    //@FormUrlEncoded
    @GET("profiles")
    Call<List<Profile>> getProfiles(@Query("account_id") int id);

    @FormUrlEncoded
    @POST("template")
    Call<ResponseBody> setTemplate(@Field("title")String title, @Field("description")String description, @Field("coins")int coins, @Field("account_id")int accId);

}
