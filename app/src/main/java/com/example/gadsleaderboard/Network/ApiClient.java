package com.example.gadsleaderboard.Network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "https://gadsapi.herokuapp.com";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(180, TimeUnit.SECONDS);
        builder.connectTimeout(180, TimeUnit.SECONDS);


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);

//        builder.addInterceptor(new UnauthorisedInterceptor(context));
        OkHttpClient client = builder.build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
