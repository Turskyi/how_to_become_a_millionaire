package com.example.myfirstmillion;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    // Настраиваем запросы
                    Request request = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Authorization", "auth-token")
                            .method(original.method(), original.body())
                            .build();

                    Response response = chain.proceed(request);

                    return response;
                }
            })
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pastebin.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    public ApiInterface apiInterface = retrofit.create(ApiInterface.class);
}
