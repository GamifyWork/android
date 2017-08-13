package com.example.user.gamifywork;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button BtnLogin;
    EditText EtName, EtPword;
    TextView TvNewAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TvNewAcc = (TextView) findViewById(R.id.textViewregister);
        BtnLogin = (Button) findViewById(R.id.buttonLogin);
        EtName = (EditText) findViewById(R.id.editText);
        EtPword = (EditText) findViewById(R.id.editText2);


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EtName.getText().toString().isEmpty() || EtPword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Gib etwas ein!", Toast.LENGTH_LONG).show();
                } else {
                    User user = new User();
                    user.email = EtName.getText().toString();
                    user.password = EtPword.getText().toString();

                    Call<ResponseToken> call = ApiManager.api.loginData(user.email, user.password);
                    call.enqueue(new Callback<ResponseToken>() {
                        @Override
                        public void onResponse(Call<ResponseToken> call, Response<ResponseToken> response) {
                            String myError = response.body().error;
                            if (myError == null) {
                                int myID = response.body().id;
                                //Toast.makeText(getApplicationContext(), Integer.toString(myID), Toast.LENGTH_LONG).show();
                                SharedPreferences jsonToken = getSharedPreferences("mySettings", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = jsonToken.edit();
                                editor.putInt("mykey", myID);
                                editor.apply();
                                Intent getOnline = new Intent(getApplicationContext(), StartActivity.class);
                                startActivity(getOnline);
                                finish();
                            } else {
                                if (myError.equals("NO_MATCH")) {
                                    Toast.makeText(getApplicationContext(), "Nutzername oder Passwort falsch", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Erstellen des Accounts fehlgeschlagen", Toast.LENGTH_LONG).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseToken> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Netzwerkfehler", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                ;
            }
        });

        TvNewAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register);
                finish();
            }
        });
    }


}