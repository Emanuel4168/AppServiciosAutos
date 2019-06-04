package com.example.emanuel.appserviciosautos;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener{

    int type;
    ImageView imgLogo;
    Button btnInsert, btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Intent intent = getIntent();
        type = intent.getIntExtra("type",0);
        this.btnInsert = findViewById(R.id.btnInsert);
        this.btnRemove = findViewById(R.id.btnRemove);

        btnInsert.setOnClickListener(this);
        btnRemove.setOnClickListener(this);

        imgLogo= findViewById(R.id.imgLogo);
        if(type == 1)
            imgLogo.setImageResource(R.drawable.car_icon);
        if(type == 2)
            imgLogo.setImageResource(R.drawable.services_icon);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        if(view == btnInsert){
            if(type == 0)
                intent = new Intent(this,RegistryActivity.class);
            if(type == 1)
                intent = new Intent(this,CarRegistryActivity.class);
            if(type == 2)
                intent = new Intent(this,ServicesRegistryActivity.class);

            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            return;
        }
        if(view == btnRemove){
            intent = new Intent(this,RemoveActivity.class);
            intent.putExtra("type",type);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            return;
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
