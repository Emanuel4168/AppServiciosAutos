package com.example.emanuel.appserviciosautos.models;

import com.example.emanuel.appserviciosautos.models.data_access_layers.QuerysDAL;
import com.example.emanuel.appserviciosautos.utils.QueryItem;

import java.util.LinkedList;

public class QueryModel {

    private QuerysDAL dal;

    public LinkedList<QueryItem> revenueByCity(){
        return dal.revenueByCity();
    }

    public LinkedList<QueryItem> servicesYearCityTrademark(){
        return  dal.servicesYearCityTrademark();
    }

    public LinkedList<QueryItem> personsWithoutService(){
        return dal.personsWithoutService();
    }

}
