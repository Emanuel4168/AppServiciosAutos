package com.example.emanuel.appserviciosautos.models;

import android.content.Context;

import com.example.emanuel.appserviciosautos.models.data_access_layers.CarDAL;
import com.example.emanuel.appserviciosautos.models.data_access_layers.PersonDAL;
import com.example.emanuel.appserviciosautos.models.data_access_layers.SQLiteModel;

public class CarModel implements SQLiteModel{
    private CarDAL dal;

    public CarModel(Context context){
        dal = new CarDAL(context);
    }

    public boolean insert(String plate, String trademark, String model, int year) {
        return dal.insert(plate, trademark, model, year);
    }

    public String[] consult(String plate) {
        return dal.consult(plate);
    }

    public boolean update(String plate, String trademark, String model, int year){
        return dal.update(plate, trademark, model, year);
    }

    public boolean delete(String plate){
        return dal.delete(plate);
    }

    @Override
    public String getCurrentError() {
        return dal.getCurrentError();
    }
}
