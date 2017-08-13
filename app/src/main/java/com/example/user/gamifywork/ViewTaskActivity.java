package com.example.user.gamifywork;

import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewTaskActivity extends AppCompatActivity {

    TextView TV1, TV2, TV3, TV4, TV5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);

        TV1 = (TextView) findViewById(R.id.textView7);
        TV2 = (TextView) findViewById(R.id.textView8);
        TV3 = (TextView) findViewById(R.id.textView9);
        TV4 = (TextView) findViewById(R.id.textView10);
        TV5 = (TextView) findViewById(R.id.textView11);

        String Title, Description;
        int Coins, id;
        Boolean Ready, Verified;

        Title = getIntent().getExtras().getString("Title", "");
        Description = getIntent().getExtras().getString("Description", "");
        Coins = getIntent().getExtras().getInt("Coins", 0);
        id = getIntent().getExtras().getInt("id", 0);
        Ready = getIntent().getExtras().getBoolean("Ready", false);
        Verified = getIntent().getExtras().getBoolean("Verified", false);


        TV1.setText(Title);
        TV2.setText(Description);
        TV3.setText("Gibt " + Integer.toString(Coins) + " Coins");
        if (Ready){TV4.setText("Fertiggestellt");}
        else {TV4.setText("Nicht fertiggestellt");}
        if (Verified){TV5.setText("Verifiziert");}
        else {TV5.setText("Nicht verifiziert");}


        /*neu.putExtra("Title", adapterTodo.getTitle(position));
        neu.putExtra("Description", adapterTodo.getContent(position));
        neu.putExtra("Coins", adapterTodo.getCoins(position));
        neu.putExtra("Ready", adapterTodo.getReady(position));
        neu.putExtra("Verified", adapterTodo.getVerified(position));
        neu.putExtra("id", adapterTodo.getID(position));*/
    }
}
