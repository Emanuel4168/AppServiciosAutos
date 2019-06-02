package com.example.emanuel.appserviciosautos.models;

import android.content.Context;

import com.example.emanuel.appserviciosautos.models.data_access_layers.PersonDAL;
import com.example.emanuel.appserviciosautos.models.data_access_layers.SQLiteModel;

public class PersonModel implements SQLiteModel{

    private PersonDAL dal;

    public PersonModel(Context context){
        dal = new PersonDAL(context);
    }

    @Override
    public boolean insert(String RFC, String name, String city) {
        return dal.insert(RFC,name,city);
    }

    @Override
    public String[] consult(String RFC) {
        return dal.consult(RFC);
    }

    @Override
    public boolean update(String RFC, String name, String city) {
        return dal.update(RFC,name,city);
    }

    @Override
    public boolean delete(String RFC) {
        return dal.delete(RFC);
    }

    @Override
    public String getCurrentError() {
        return dal.getCurrentError();
    }
}
