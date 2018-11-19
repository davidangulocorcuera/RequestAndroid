package com.vogella.retrofitgerrit;


import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChangeService {

    @GET("changes/")
    Flowable<List<Change>> loadChanges(@Query("q") String status);

    static ChangeService create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.example.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ChangeService.class);
    }

}


