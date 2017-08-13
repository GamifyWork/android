package com.example.user.gamifywork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartActivity extends AppCompatActivity {

    Button BtnKids, Btndel;
    GridView gw1, gw2;
    gridAdapter adapter1, adapter2;
    List<Profile> a = new ArrayList<>();
    List<Profile> b;
    List<Profile> c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        SharedPreferences jsonToken = getSharedPreferences("mySettings", 0);
        int myToken = jsonToken.getInt("mykey", 0);


        Btndel = (Button) findViewById(R.id.buttondel);
        Btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplicationContext().getSharedPreferences("mySettings", 0).edit().clear().apply();
                finish();
            }
        });



        //Kinder anzeigen


        Profile p1 = new Profile("Leon", "CHILD", 1, 20, 20);
        Profile p2 = new Profile("Nina", "CHILD", 2, 20, 20);
        Profile p3 = new Profile("Tim", "CHILD", 3, 20, 20);
        Profile p4 = new Profile("Tina", "CHILD", 4, 20, 20);
        a.add(p1);
        a.add(p2);
        b = new ArrayList<>();
        b.add(p3);
        b.add(p4);
        gw1 = (GridView) findViewById(R.id.gw1);
        adapter1 = new gridAdapter(getApplicationContext(), a);
        gw1.setAdapter(adapter1);

        gw1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.print("Klappt");
                Intent j = new Intent(StartActivity.this, KidsActivity.class);
                j.putExtra("Name", adapter1.getName(position));
                startActivity(j);
            }
        });

        gw2 = (GridView) findViewById(R.id.gw2);
        adapter2 = new gridAdapter(getApplicationContext(), b);
        gw2.setAdapter(adapter2);

        gw2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ParentsActivity.class);
                i.putExtra("AnzahlKinder", a.size());
                startActivity(i);
            }
        });

/*
        Call<List<Profile>> call = ApiManager.api.getProfiles(myToken);

        call.enqueue(new Callback<List<Profile>>() {
            @Override
            public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {
                a = response.body();
                b = new ArrayList<>();
                c = new ArrayList<>();
                if (a != null) {
                    for (int u = 0; u < a.size(); u++) {
                        if (a.get(u).getRole().equals("CHILD")) {
                            b.add(a.get(u));
                        }
                        if (a.get(u).getRole().equals("PARENT")) {
                            c.add(a.get(u));
                        }
                    }
                    gw1 = (GridView) findViewById(R.id.gw1);
                    adapter1 = new gridAdapter(getApplicationContext(), b);
                    gw1.setAdapter(adapter1);

                    gw1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent j = new Intent(getApplicationContext(), KidsActivity.class);
                            j.putExtra("Name", adapter1.getName(position));
                            startActivity(j);
                        }
                    });

                    gw2 = (GridView) findViewById(R.id.gw2);
                    adapter2 = new gridAdapter(getApplicationContext(), c);
                    gw2.setAdapter(adapter2);

                    gw2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent i = new Intent(getApplicationContext(), ParentsActivity.class);
                            i.putExtra("AnzahlKinder", b.size());
                            startActivity(i);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Profile>> call, Throwable t) {
                t.printStackTrace();
            }
        });*/




        /*//Eltern anzeigen
        Call<List<Task>> call = ApiManager.api.getTask();

        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                List<Task> a = response.body();
                a = response.body();
                listview = (ListView) findViewById(R.id.listviewkids);
                adapter = new meinAdapter(getApplicationContext(), a);
                listview.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                t.printStackTrace();
            }
        });*/
    }
}
