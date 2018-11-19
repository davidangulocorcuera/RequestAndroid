package com.example.biolizard.request;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vogella.retrofitgerrit.Change;
import com.vogella.retrofitgerrit.Controller;
import com.vogella.retrofitgerrit.MainViewModel;
import com.vogella.retrofitgerrit.Repository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getServiceDataMutableLiveData().observe(this, changes -> {
            if (changes != null) {
                
            }
        });

        mainViewModel.getData();

    }
}
/*       ClassroomRoomDatabase.getDatabase(this).classroomDao().getAllClassrooms().observe(this, new Observer<List<Classroom>>() {
            @Override
            public void onChanged(@Nullable List<Classroom> classrooms) {
                if (classrooms !=null) {
                    Log.v("LISTA", String.valueOf(classrooms));
                }
                else {
                    Log.v("LISTA", "no hay datos");
                }
            }
});*/