package com.example.administrator.myretrofit;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Gson mGson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","oncreate()");
        /*HashMap<String,String> map = new HashMap<>();

        List<String> returnResult2 = new LinkedList<String>();
        Collection<String> values =  map.values();
        Iterator<String> it2 = values.iterator();
        while(it2.hasNext()) {
            returnResult2.add(it2.next());
        }*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        GitHubService api = retrofit.create(GitHubService.class);

        api.getRespos().enqueue(new Callback<List<Repro>>() {
            @Override
            public void onResponse(Call<List<Repro>> call, Response<List<Repro>> response) {

            }

            @Override
            public void onFailure(Call<List<Repro>> call, Throwable t) {

            }
        });



    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStar()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","Resume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy()");
    }

}
