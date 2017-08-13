package com.example.user.gamifywork;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemplateActivity extends AppCompatActivity {

    EditText templateName, templatedescr, templateCoins;
    Button BtnSend;
    int myToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        templateCoins = (EditText)findViewById(R.id.editTexttemplcoins);
        templateName = (EditText)findViewById(R.id.editTexttemplname);
        templatedescr = (EditText)findViewById(R.id.editTexttemplcont);
        BtnSend = (Button)findViewById(R.id.buttontemplsend);

        SharedPreferences jsonToken = getSharedPreferences("mySettings", 0);
        myToken = jsonToken.getInt("mykey", 0);

        BtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Template newTemplate = new Template(templateName.getText().toString(),
                        templatedescr.getText().toString(),
                        Integer.parseInt(templateCoins.getText().toString()),
                        myToken
                );
                Call<okhttp3.ResponseBody> call = ApiManager.api.setTemplate(newTemplate.getTitle(),
                        newTemplate.getDescription(),
                        newTemplate.getCoins(),
                        newTemplate.getAccount_id());
                call.enqueue(new Callback<okhttp3.ResponseBody>() {
                    @Override
                    public void onResponse(Call<okhttp3.ResponseBody> call, Response<okhttp3.ResponseBody> response) {
                        if (response.message().equals("OK"))
                        {Toast.makeText(getApplicationContext(),"Erstellt", Toast.LENGTH_LONG).show();
                    }}

                    @Override
                    public void onFailure(Call<okhttp3.ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
