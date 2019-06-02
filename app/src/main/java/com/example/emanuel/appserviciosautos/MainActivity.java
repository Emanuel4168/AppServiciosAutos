package com.example.emanuel.appserviciosautos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPerson,btnCar,btnService,btnQuerry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnPerson = findViewById(R.id.btnPerson);
        this.btnCar = findViewById(R.id.btnCar);
        this.btnService = findViewById(R.id.btnService);
        this.btnQuerry = findViewById(R.id.btnQuerry);
    }

    public Button getBtnPerson() {
        return btnPerson;
    }

    public Button getBtnCar() {
        return btnCar;
    }

    public Button getBtnService() {
        return btnService;
    }

    public Button getBtnQuerry() {
        return btnQuerry;
    }
}
