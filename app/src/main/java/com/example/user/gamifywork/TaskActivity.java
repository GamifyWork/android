package com.example.user.gamifywork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.Spinner;

public class TaskActivity extends AppCompatActivity {

    Spinner mySpinner;
    CheckBox myCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }
}
