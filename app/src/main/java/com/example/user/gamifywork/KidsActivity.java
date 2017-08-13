package com.example.user.gamifywork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KidsActivity extends AppCompatActivity {

    ListView listviewtodo, listviewfertig;
    meinAdapter adapterfertig, adapterTodo;
    public List<Task> listKidsTodo;
    public List<Task> listKidsFertig;
    public List<Task> b;
    public int profile;

    TextView coins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);

        SharedPreferences jsonToken = getSharedPreferences("mySettings", 0);
        int myToken = jsonToken.getInt("mykey", 0);

        coins = (TextView)findViewById(R.id.textView4);

        String eins;
        eins = getIntent().getExtras().getString("Name", "");
        listKidsFertig = new ArrayList<>();
        listKidsTodo = new ArrayList<>();
        Task fertig = new Task("Aufräumen", "Räum doch mal dein Zimmer auf", 1, 1, 20, false, true);
        Task nichtfertig = new Task("Putzen", "Putz doch mal", 1, 1, 20, false, false);
        Task fertig2 = new Task("Spülmaschine", "Räum doch mal die Spülmaschine aus", 1, 1, 20, false, true);
        Task nichtfertig2 = new Task("Müll", "Bring mal den Müll raus", 1, 1, 20, false, false);

        if (eins.equals("Leon")){
        listKidsFertig.add(fertig);
        listKidsTodo.add(nichtfertig);
        coins.setText("Du hast 45 Coins");}
        else{listKidsFertig.add(fertig2);
            listKidsTodo.add(nichtfertig2);
            coins.setText("Du hast 75 Coins");}



        /*Call<List<Task>> call = ApiManager.api.getTask(myToken);

        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                List<Task> a = response.body();

                for (int o = 0; o < a.size(); o++) {
                    if (a.get(o).getTask_id() == profile) {
                        b.add(a.get(o));
                    }
                }

                for (int i = 0; i < b.size(); i++) {
                    if (a.get(i).finished) {
                        listKidsFertig.add(b.get(i));
                    } else {
                        listKidsTodo.add(b.get(i));
                    }
                }*/
                listviewtodo = (ListView) findViewById(R.id.listviewkidstodo);
                listviewfertig = (ListView) findViewById(R.id.listviewkisfertig);
                adapterfertig = new meinAdapter(getApplicationContext(), listKidsFertig);
                adapterTodo = new meinAdapter(getApplicationContext(), listKidsTodo);
                listviewfertig.setAdapter(adapterfertig);
                listviewtodo.setAdapter(adapterTodo);

                listviewtodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent neu = new Intent(KidsActivity.this, ViewTaskActivity.class);
                        neu.putExtra("Title", adapterTodo.getTitle(position));
                        neu.putExtra("Description", adapterTodo.getContent(position));
                        neu.putExtra("Coins", adapterTodo.getCoins(position));
                        neu.putExtra("Ready", adapterTodo.getReady(position));
                        neu.putExtra("Verified", adapterTodo.getVerified(position));
                        neu.putExtra("id", adapterTodo.getID(position));
                        startActivity(neu);
                    }
                });

                listviewfertig.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                });

            //}

           /* @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                t.printStackTrace();
            }
        });
*/

    }
}
