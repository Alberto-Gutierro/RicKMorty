package com.example.rickmorty;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RymAPIModule {
    static RymAPI rymAPI;

    public static RymAPI getAPI(){
        if(rymAPI == null){
            final OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    //.addInterceptor(new ApiKeyInterceptor()) Introduce la key
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15,TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://rickandmortyapi.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            rymAPI = retrofit.create(RymAPI.class);
        }
        return rymAPI;
    }
}

// añidir el siguiente metodo si tu Api requiere key

//class ApiKeyInterceptor implements Interceptor {
//    @Override
//    public okhttp3.Response intercept(Chain chain) throws IOException {
//        Request original = chain.request();
//        HttpUrl originalHttpUrl = original.url();
//
//        HttpUrl url = originalHttpUrl.newBuilder()
//                .addQueryParameter("api_key", "783d7821b7371463534c4e5a1543551e")
//                .build();
//
//        Request.Builder requestBuilder = original.newBuilder()
//                .url(url);
//
//        Request request = requestBuilder.build();
//        return chain.proceed(request);
//    }
//}

class LoggingInterceptor implements Interceptor {
    @Override public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
        Log.e("INTERCEPTOR", String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        okhttp3.Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        Log.e("INTERCEPTOR---", String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}

