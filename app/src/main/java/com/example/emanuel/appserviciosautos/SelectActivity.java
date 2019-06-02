package com.example.emanuel.appserviciosautos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SelectActivity extends AppCompatActivity {

    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Intent intent = getIntent();
        type = intent.getIntExtra("type");
    }
}
