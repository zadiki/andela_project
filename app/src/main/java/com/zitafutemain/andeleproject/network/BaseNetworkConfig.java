package com.zitafutemain.andeleproject.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseNetworkConfig {

    private Gson gson;
    private HttpLoggingInterceptor httpLoggingInterceptor;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private static BaseNetworkConfig baseNetworkConfig;
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    private static LeadersApiCall leadersApiCall;


    public BaseNetworkConfig() {
        gson = new GsonBuilder().serializeNulls().create();
        httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request newRequest = originalRequest.newBuilder()
                                .build();

                        return chain.proceed(newRequest);
                    }
                })
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

    }

    public static BaseNetworkConfig getInstance() {
        if (baseNetworkConfig == null) {
            baseNetworkConfig = new BaseNetworkConfig();
        }
        return baseNetworkConfig;
    }

    private Retrofit getRetrofit() {
        return retrofit;
    }

    public static LeadersApiCall getLeadersApiCall() {
        leadersApiCall = BaseNetworkConfig.getInstance().getRetrofit().create(LeadersApiCall.class);
        return leadersApiCall;
    }


}

