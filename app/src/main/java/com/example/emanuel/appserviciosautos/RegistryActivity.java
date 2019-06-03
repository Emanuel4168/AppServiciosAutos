package com.example.emanuel.appserviciosautos;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.emanuel.appserviciosautos.models.PersonModel;
import com.example.emanuel.appserviciosautos.utils.RegexConstants;

public class RegistryActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtRFC, txtName,txtCity;
    private Button btnInsert, btnUpdate;

    private PersonModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);

        txtRFC = findViewById(R.id.txtRFC);
        txtName = findViewById(R.id.txtName);
        txtCity = findViewById(R.id.txtCity);
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);

        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        model = new PersonModel(this);
    }

    @Override
    public void onClick(View view) {
        if(!validate()){

            return;
        }

        String[] data = {txtRFC.getText().toString(), txtName.getText().toString(), txtCity.getText().toString()};
        if(view == btnInsert){
            if(!model.insert(data)){
                //fallo

                return;
            }
            //exito
            return;
        }

        if(view == btnUpdate){
            if(!model.update(data)){
                //fallo

                return;
            }
            //exito
            return;

        }

    }

    private boolean validate(){
        boolean res = true;
        if(!txtRFC.getText().toString().matches(RegexConstants.RFC_REGEX)){
            txtRFC.setError("El RFC parece ser incorrecto");
            res = false;
        }
        if(!txtName.getText().toString().matches(RegexConstants.NAME_REGEX)){
            txtRFC.setError("El nombre parece ser incorrecto");
            res = false;
        }
        if(!txtCity.getText().toString().matches(RegexConstants.CITY_REGEX)){
            txtRFC.setError("la ciudad parece ser incorrecto");
            res = false;
        }
        return res;
    }
}
