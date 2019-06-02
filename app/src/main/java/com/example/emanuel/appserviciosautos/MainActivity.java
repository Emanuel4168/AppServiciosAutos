package com.example.emanuel.appserviciosautos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnPerson,btnCar,btnService,btnQuerry;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnPerson = findViewById(R.id.btnPerson);
        this.btnCar = findViewById(R.id.btnCar);
        this.btnService = findViewById(R.id.btnService);
        this.btnQuerry = findViewById(R.id.btnQuerry);
    }

    @Override
    public void onClick(View view) {

        if(view == this.btnPerson){
            openSelectActivity("person",0);
            return;
        }
        if(view == this.btnCar){
            openSelectActivity("car",1);
            return;
        }
        if(view == this.btnService){
            openSelectActivity("service",2);
            return;
        }
        if(view == this.btnQuerry){
            openSelectActivity("querry",3);
            return;
        }

    }

    private void openSelectActivity(String key, int value){
        intent = new Intent(this, ConsultActivity.class);
        intent.putExtra(key,value);
        startActivity(intent);
    }
}
