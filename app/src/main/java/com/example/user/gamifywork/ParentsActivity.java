package com.example.user.gamifywork;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ParentsActivity extends AppCompatActivity {

    ListView parentL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        parentL = (ListView)findViewById(R.id.parentlist);
        meinAdapter adapterfertig;
        Task fertig = new Task("Aufräumen - Leon", "Räum doch mal dein Zimmer auf", 1, 1, 20, false, true);
        Task nichtfertig = new Task("Putzen - Leon", "Putz doch mal", 1, 1, 20, false, false);
        Task fertig2 = new Task("Spülmaschine - Nina", "Räum doch mal die Spülmaschine aus", 1, 1, 20, false, true);
        Task nichtfertig2 = new Task("Müll - Nina", "Bring mal den Müll raus", 1, 1, 20, false, false);


        List<Task> listKidsFertig = new ArrayList<>();


        listKidsFertig.add(nichtfertig);
        listKidsFertig.add(nichtfertig2);
        listKidsFertig.add(fertig);
        listKidsFertig.add(fertig2);
        adapterfertig = new meinAdapter(getApplicationContext(), listKidsFertig);
        parentL.setAdapter(adapterfertig);
        
    }

}
