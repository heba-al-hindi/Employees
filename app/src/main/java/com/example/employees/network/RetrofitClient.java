package com.example.employees.network;

/*
   RetrofitClient Class to get retrofit instance for managing network calls
 */

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            // build okHttp client
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();


            // create retrofit Instance and build it
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build() ;
        }
        // return the instance of Retrofit
        return retrofit;

    }
}
