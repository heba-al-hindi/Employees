package com.example.employees.network;

/*
   RetrofitClient Class to get retrofit instance for managing network calls
 */

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            // create okHttp client and build it
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
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
