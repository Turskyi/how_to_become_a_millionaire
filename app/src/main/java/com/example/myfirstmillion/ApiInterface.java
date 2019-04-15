package com.example.myfirstmillion;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Brainacad4 on 26.03.2019.
 */

public interface ApiInterface {

    @GET("raw/0cQWwbWh")
    Call<PasteBinData> getData();

    @FormUrlEncoded
    @POST("___")
    Call<Response> sendData(@Field("value") String value);

    @FormUrlEncoded
    @PUT("___")
    Call<Response> updateData(@Field("value") String value); // @FieldMap

    @FormUrlEncoded
    @PATCH("___")
    Call<Response> updateAnothetrData(@Field("value") String value); // @FieldMap

    @DELETE("___")
    Call<Response> deleteData();

    @GET
    Call<Response> getAnotherData(@Url String url);

    @GET("users/{id}")
    Call<Response> getUserById(@Path("id") long id);

    @GET("__")
    Call<Response> getDataWithQuery(@Query("value") String value); // @QueryMap

    @Multipart
    @PUT("user/photo")
    Call<Response> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);
}
