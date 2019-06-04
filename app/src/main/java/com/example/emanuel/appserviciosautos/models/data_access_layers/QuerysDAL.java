package com.example.emanuel.appserviciosautos.models.data_access_layers;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

import com.example.emanuel.appserviciosautos.db_conection.SQLiteConnection;
import com.example.emanuel.appserviciosautos.utils.DataBaseConstants;

public class QuerysDAL {

    private SQLiteConnection connection;
    private SQLiteDatabase dataBase;
    private Context context;
    private String error, errorDefault;

    public void revenueByCity(){
        dataBase = connection.getWritableDatabase();
        String query = "Select sum("+ DataBaseConstants.SERVICE_PRICE+") from "+DataBaseConstants.SERVICES_TABLE+" S"
                +" inner join "+DataBaseConstants.PERSONS_TABLE+" P on S."+DataBaseConstants.PERSONS_RFC+" = P."+DataBaseConstants.PERSONS_RFC
                +" group by P."+DataBaseConstants.PERSONS_CITY;
        try{
            dataBase.execSQL(query);
        }catch (Exception e){

        }finally {
            dataBase.close();
        }
    }

    public void servicesYearCityTrademark(){
        dataBase = connection.getWritableDatabase();
        String query = "Select sum("+ DataBaseConstants.SERVICE_PRICE+") from "+DataBaseConstants.PERSONS_TABLE+" P"
                +" left join "+DataBaseConstants.SERVICES_TABLE+" S on P."+DataBaseConstants.PERSONS_RFC+" is null";
        try{
            dataBase.execSQL(query);
        }catch (Exception e){

        }finally {
            dataBase.close();
        }
    }

    public void personsWithoutService(){
        dataBase = connection.getWritableDatabase();
        String query = "Select substr(date,1,4) as year, city, trademark, count(*) as nServices, sum(price) as total" +
                        " from SERVICES S inner join PERSONS P on (S.rfc = P.rfc) inner join CARS C on (S.plate = C.plate)" +
                        " group by year, city, trademark";
        try{
            dataBase.execSQL(query);
        }catch (Exception e){

        }finally {
            dataBase.close();
        }
    }

}
