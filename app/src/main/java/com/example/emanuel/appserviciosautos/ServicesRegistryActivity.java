package com.example.emanuel.appserviciosautos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emanuel.appserviciosautos.models.ServiceModel;
import com.example.emanuel.appserviciosautos.utils.RegexConstants;
import com.example.emanuel.appserviciosautos.utils.Routines;

public class ServicesRegistryActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtOrder,txtPlateService,txtRFCService,txtKm,txtPrice,txtDate;
    private Button btnInsertService,btnUpdateService;
    private ServiceModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_registry);

        txtOrder = findViewById(R.id.txtOrder);
        txtPlateService = findViewById(R.id.txtPlateService);
        txtRFCService = findViewById(R.id.txtRFCService);
        txtKm = findViewById(R.id.txtKm);
        txtPrice = findViewById(R.id.txtPrice);
        txtDate = findViewById(R.id.txtDate);

        btnInsertService = findViewById(R.id.btnInsertCar);
        btnUpdateService = findViewById(R.id.btnUpdateService);

        btnInsertService.setOnClickListener(this);
        btnUpdateService.setOnClickListener(this);

        model = new ServiceModel(this);
    }

    @Override
    public void onClick(View view) {
        if(!validate())
            return;

        String[] car = {txtOrder.getText().toString(),txtPlateService.getText().toString(),
                txtRFCService.getText().toString(),txtKm.getText().toString(),txtPrice.getText().toString(),
                txtDate.getText().toString()};

        if(view == btnInsertService){
            if(!model.insert(car)){
                //error
                Routines.showNotificationMessage(this,"OOPS!",model.getCurrentError());
                return;
            }
            //exito
            Routines.showNotificationMessage(this,"CORRECTO!","El nuevo servicio está listo");
            return;
        }
        if(view == btnUpdateService){
            if(!model.update(car)){
                //error
                Routines.showNotificationMessage(this,"OOPS!",model.getCurrentError());
                return;
            }
            //exito
            Routines.showNotificationMessage(this,"CORRECTO!","Modificación exitosa");
            return;
        }

    }

    private boolean validate(){
        boolean res = true;
        if(!txtOrder.getText().toString().matches(RegexConstants.ORDER_REGEX)){
            txtOrder.setError("La orden no parece ser correcta");
            res = false;
        }
        if(!txtPlateService.getText().toString().matches(RegexConstants.PLATE_REGEX)){
            txtOrder.setError("La placa no parece ser correcta");
            res = false;
        }
        if(!txtRFCService.getText().toString().matches(RegexConstants.RFC_REGEX)){
            txtOrder.setError("El RFC no parece ser correcto");
            res = false;
        }
        if(!txtKm.getText().toString().matches(RegexConstants.KM_REGEX)){
            txtOrder.setError("El kilometrajeno parece ser correcta");
            res = false;
        }
        if(!txtPrice.getText().toString().matches(RegexConstants.PRICE_REGEX)){
            txtOrder.setError("El precio no parece ser correcto");
            res = false;
        }
        if(!txtDate.getText().toString().matches(RegexConstants.DATE_REGEX)){
            txtOrder.setError("La fecha no parece ser correcta");
            res = false;
        }

        return res;
    }
    
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
