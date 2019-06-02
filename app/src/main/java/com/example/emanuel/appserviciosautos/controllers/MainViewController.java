package com.example.emanuel.appserviciosautos.controllers;

import android.content.Intent;
import android.view.View;

import com.example.emanuel.appserviciosautos.MainActivity;

public class MainViewController implements View.OnClickListener{
    MainActivity view;
    private Intent intent;

    public MainViewController(MainActivity view){
        this.view = view;
    }

    @Override
    public void onClick(View view) {

    }
}
