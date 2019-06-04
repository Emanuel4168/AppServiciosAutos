package com.example.emanuel.appserviciosautos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuerryActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnIngresos, btnServicios, btnPersonas, btnIngresos2, btnServicios2, btnPersonas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_querry);

        this.btnIngresos = findViewById(R.id.btnIngresos);
        this.btnIngresos2 = findViewById(R.id.btnIngresos2);
        this.btnServicios = findViewById(R.id.btnServicios);
        this.btnServicios2 = findViewById(R.id.btnServicios2);
        this.btnPersonas = findViewById(R.id.btnPersonas);
        this.btnPersonas2 = findViewById(R.id.btnPersonas2);

        this.btnIngresos.setOnClickListener(this);
        this.btnIngresos2.setOnClickListener(this);
        this.btnServicios.setOnClickListener(this);
        this.btnServicios2.setOnClickListener(this);
        this.btnPersonas.setOnClickListener(this);
        this.btnPersonas2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        if(view == btnIngresos || view == btnIngresos2)
            intent = new Intent(this, CarRegistryActivity.class);
        if(view == btnServicios || view == btnServicios2)
            intent = new Intent(this, CarRegistryActivity.class);
        if(view == btnPersonas || view == btnPersonas2)
            intent = new Intent(this, CarRegistryActivity.class);

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
