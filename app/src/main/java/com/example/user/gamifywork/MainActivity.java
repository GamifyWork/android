package com.example.user.gamifywork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Retrofit.Builder builder = new Retrofit.Builder()
                //.baseUrl("https://my-json-server.typicode.com/GamifyWork/mock_server/")
                .baseUrl("http://172.17.10.32:5000/")
                //.baseUrl("http://192.168.1.130:3001/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        ApiManager.api = retrofit.create(DataClient.class);




        SharedPreferences jsonToken = getSharedPreferences("mySettings", 0);
        int myToken = jsonToken.getInt("mykey", 0);

        if (myToken > 0){
            Intent userExists = new Intent(this, StartActivity.class);
            startActivity(userExists);
            finish();
        }
        else {
            Intent userNew = new Intent(this, LoginActivity.class);
            startActivity(userNew);
            finish();

        }
    }
}
