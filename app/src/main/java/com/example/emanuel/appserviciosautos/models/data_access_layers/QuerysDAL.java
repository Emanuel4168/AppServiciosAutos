package com.example.emanuel.appserviciosautos.models.data_access_layers;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

import com.example.emanuel.appserviciosautos.db_conection.SQLiteConnection;
import com.example.emanuel.appserviciosautos.utils.DataBaseConstants;
import com.example.emanuel.appserviciosautos.utils.QueryItem;

import java.util.LinkedList;

public class QuerysDAL {

    private SQLiteConnection connection;
    private SQLiteDatabase dataBase;
    private Context context;
    private String error, errorDefault;

    public LinkedList<QueryItem> revenueByCity(){
        dataBase = connection.getWritableDatabase();
        LinkedList<QueryItem> res = new LinkedList<QueryItem>();
        String query = "select sum(price) as total, min(price) as min, max(price) as max, avg(price) as avg from SERVICES S inner join PERSONS P on S.rfc = P.rfc group by P.city";
        try{
            Cursor c = dataBase.rawQuery(query,null);
            while(c.moveToNext()){
                String[] fields = {c.getFloat(0)+"",c.getFloat(1)+"",c.getFloat(2)+"",c.getFloat(3)+""};
                res.add(new QueryItem(fields));
            }
            return res;
        }catch (Exception e){
            error = "";
            return null;
        }finally {
            dataBase.close();
        }
    }

    public LinkedList<QueryItem> servicesYearCityTrademark(){
        dataBase = connection.getWritableDatabase();
        LinkedList<QueryItem> res = new LinkedList<QueryItem>();
        String query = "select PERSONS.rfc,name,city from PERSONS P left join SERVICES S on(P.rfc = S.rfc) where P.rfc is null";
        try{
            Cursor c = dataBase.rawQuery(query,null);
            while(c.moveToNext()){
                String[] fields = {c.getString(0),c.getString(1),c.getString(2),""};
                res.add(new QueryItem(fields));
            }
            return res;

        }catch (Exception e){
            error = "";
            return null;
        }finally {
            dataBase.close();
        }
    }

    public LinkedList<QueryItem> personsWithoutService(){
        dataBase = connection.getWritableDatabase();
        LinkedList<QueryItem> res = new LinkedList<QueryItem>();
        String query = "Select substr(date,1,4) as year, city, trademark, count(*) as nServices" +
                        " from SERVICES S inner join PERSONS P on (S.rfc = P.rfc) inner join CARS C on (S.plate = C.plate)" +
                        " group by year, city, trademark";
        try{
            Cursor c = dataBase.rawQuery(query,null);
            while(c.moveToNext()){
                String[] fields = {c.getString(0),c.getString(1),c.getString(1),c.getInt(2)+""};
                res.add(new QueryItem(fields));
            }
            return res;
        }catch (Exception e){
            error = "";
            return null;
        }finally {
            dataBase.close();
        }
    }

}
