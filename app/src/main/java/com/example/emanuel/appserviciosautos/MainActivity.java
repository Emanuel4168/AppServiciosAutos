package com.example.emanuel.appserviciosautos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton btnPerson,btnCar,btnService,btnQuerry;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnPerson = findViewById(R.id.btnPerson);
        this.btnCar = findViewById(R.id.btnCar);
        this.btnService = findViewById(R.id.btnService);
        this.btnQuerry = findViewById(R.id.btnQuerry);

        btnPerson.setOnClickListener(this);
        btnCar.setOnClickListener(this);
        btnService.setOnClickListener(this);
        btnQuerry.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == this.btnPerson){
            openSelectActivity(0);
            return;
        }
        if(view == this.btnCar){
            openSelectActivity(1);
            return;
        }
        if(view == this.btnService){
            openSelectActivity(2);
            return;
        }
        if(view == this.btnQuerry){

            return;
        }

    }

    private void openSelectActivity( int value){
        intent = new Intent(this, SelectActivity.class);
        intent.putExtra("type",value);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
