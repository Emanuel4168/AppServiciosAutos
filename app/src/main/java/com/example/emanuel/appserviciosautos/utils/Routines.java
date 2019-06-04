package com.example.emanuel.appserviciosautos.utils;

import android.app.AlertDialog;
import android.content.Context;

public class Routines {

    public static void showNotificationMessage(Context context, String title, String mesage){
        AlertDialog Alerta = new AlertDialog.Builder(context).create();
        Alerta.setTitle(title);
        Alerta.setMessage(mesage);
        Alerta.show();
    }
}
