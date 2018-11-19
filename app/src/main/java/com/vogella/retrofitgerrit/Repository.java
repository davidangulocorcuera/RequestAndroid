package com.vogella.retrofitgerrit;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Call;

public class Repository {
    private static Repository instance;
    private Repository() {
    }

    public static Repository getInstance() {
        if (instance == null){
            synchronized (Repository.class){
                if (instance == null){
                    instance = new Repository();
                }
            }
        }

        return instance;
    }


    private ChangeService apiService = ChangeService.create();


    public Flowable<List<Change>> getChangeData(String status) {
        return apiService.loadChanges(status);
    }


}