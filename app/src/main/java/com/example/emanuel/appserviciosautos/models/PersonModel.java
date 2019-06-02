package com.example.emanuel.appserviciosautos.models;

import android.content.Context;

import com.example.emanuel.appserviciosautos.models.data_access_layers.PersonDAL;
import com.example.emanuel.appserviciosautos.models.data_access_layers.SQLiteModel;

public class PersonModel implements SQLiteModel{

    private PersonDAL dal;

    public PersonModel(Context context){
        dal = new PersonDAL(context);
    }

    public boolean insert(String[] fields) {
        return dal.insert(fields);
    }

    public String[] consult(String RFC) {
        return dal.consult(RFC);
    }

    public boolean update(String[] fields) {
        return dal.update(fields);
    }

    public boolean delete(String RFC) {
        return dal.delete(RFC);
    }

    public String getCurrentError() {
        return dal.getCurrentError();
    }
}
