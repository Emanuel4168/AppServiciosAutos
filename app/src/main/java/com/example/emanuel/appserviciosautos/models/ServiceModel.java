package com.example.emanuel.appserviciosautos.models;

import android.content.Context;
import com.example.emanuel.appserviciosautos.models.data_access_layers.ServiceDAL;

public class ServiceModel {
    private ServiceDAL dal;

    public ServiceModel(Context context){
        dal = new ServiceDAL(context);
    }

    public boolean insert(String [] fields) {
        return dal.insert(fields);
    }

    public String[] consult(String order) {
        return dal.consult(order);
    }

    public boolean update(String[] fields){
        return dal.update(fields);
    }

    public String getCurrentError() {
        return dal.getCurrentError();
    }
}
