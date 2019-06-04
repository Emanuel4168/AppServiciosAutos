package com.example.emanuel.appserviciosautos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emanuel.appserviciosautos.models.CarModel;
import com.example.emanuel.appserviciosautos.utils.RegexConstants;

public class CarRegistryActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtPlate,txtTrademark,txtModel,txtYear;
    private Button btnInsertCar,btnUpdateCar;
    private CarModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_registry);

        txtPlate = findViewById(R.id.txtPlate);
        txtTrademark = findViewById(R.id.txtTrademark);
        txtPlate = findViewById(R.id.txtModel);
        txtYear = findViewById(R.id.txtYear);

        btnInsertCar = findViewById(R.id.btnInsertCar);
        btnUpdateCar = findViewById(R.id.btnUpdateCar);

        btnInsertCar.setOnClickListener(this);
        btnUpdateCar.setOnClickListener(this);

        model = new CarModel(this);
    }

    @Override
    public void onClick(View view) {
        if(!validate())
            return;

        String[] car = {txtPlate.getText().toString(),txtTrademark.getText().toString(),
                         txtModel.getText().toString(),txtYear.getText().toString()};

        if(view == btnInsertCar){
            if(!model.insert(car)){
                //error
                return;
            }
            //exito
            return;
        }
        if(view == btnUpdateCar){
            if(!model.update(car)){
                //error
                return;
            }
            //exito
            return;
        }

    }

    private boolean validate(){
        boolean res = true;
        if(!txtPlate.getText().toString().matches(RegexConstants.PLATE_REGEX)){
            txtPlate.setError("La placa no parece ser correcta");
            res = false;
        }
        if(!txtTrademark.getText().toString().matches(RegexConstants.TRADEMARK_REGEX)){
            txtTrademark.setError("La marca no parece ser correcta");
            res = false;
        }
        if(!txtModel.getText().toString().matches(RegexConstants.MODEL_REGEX)){
            txtModel.setError("El modelo no parece ser correcto");
            res = false;
        }
        if(!txtYear.getText().toString().matches(RegexConstants.YEAR_REGEX)){
            txtYear.setError("El año no parece ser correcto");
        }

        return res;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
