package com.vogella.retrofitgerrit;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends AndroidViewModel {
    static final String BASE_URL = "https://git.eclipse.org/r/";
    private MutableLiveData<List<Change>> serviceDataMutableLiveData = new MutableLiveData<>();
    private Repository repository = Repository.getInstance();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    // fun getServiceDataMutableLiveData() = serviceDataMutableLiveData
    public MutableLiveData<List<Change>> getServiceDataMutableLiveData() {
        return serviceDataMutableLiveData;
    }

    public void getData() {
        repository.getChangeData("status:open")
                .subscribeOn(Schedulers.io())
                .subscribe(response -> serviceDataMutableLiveData.postValue(response),
                           error -> Log.d("SERVICE RESPONSE", error.getLocalizedMessage()));
    }


}
