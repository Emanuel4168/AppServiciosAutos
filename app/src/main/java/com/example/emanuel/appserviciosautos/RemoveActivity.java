package com.example.emanuel.appserviciosautos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.emanuel.appserviciosautos.models.CarModel;
import com.example.emanuel.appserviciosautos.models.PersonModel;
import com.example.emanuel.appserviciosautos.models.ServiceModel;
import com.example.emanuel.appserviciosautos.models.data_access_layers.SQLiteModel;

public class RemoveActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRemove2;
    private ImageView imgLogo;
    private EditText txtID;
    private SQLiteModel model;
    int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        btnRemove2 = findViewById(R.id.btnRemove2);
        txtID = findViewById(R.id.txtID);
        imgLogo = findViewById(R.id.imgLogo2);
        Intent intent = getIntent();
        type = intent.getIntExtra("type",0);
        imgLogo= findViewById(R.id.imgLogo);
        model = new PersonModel(this);
        txtID.setHint("RFC:");
        if(type == 1) {
            imgLogo.setImageResource(R.drawable.car_icon);
            model = new CarModel(this);
            txtID.setHint("Placas:");
        }
        if(type == 2) {
            imgLogo.setImageResource(R.drawable.services_icon);
            model = new ServiceModel(this);
            txtID.setHint("No. de Servicio:");
        }
        btnRemove2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(!validate())
            return;

        if(!model.delete(txtID.getText().toString())){
            //error
            return;
        }

        //success

    }

    private boolean validate() {
        if(txtID.getText().length() < 1){
            txtID.setError("Este campo no puede estar vacío");
            return false;
        }
        return true;
    }

    private void showError(){

    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
