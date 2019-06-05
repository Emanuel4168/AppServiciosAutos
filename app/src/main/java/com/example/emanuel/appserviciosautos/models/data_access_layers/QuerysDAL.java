package com.example.emanuel.appserviciosautos.models.data_access_layers;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.emanuel.appserviciosautos.db_conection.SQLiteConnection;
import com.example.emanuel.appserviciosautos.utils.DataBaseConstants;
import com.example.emanuel.appserviciosautos.utils.QueryItem;

import java.util.LinkedList;

public class QuerysDAL {

    private SQLiteConnection connection;
    private SQLiteDatabase dataBase;
    private Context context;
    private String error, errorDefault;

    public QuerysDAL(Context context) {
        this.context = context;
        connection = new SQLiteConnection(context, DataBaseConstants.DB_NAME, null, 1);
        errorDefault = "No fue posible realizar la operación, es probable que no exista alguien con ese RFC";
    }

    public LinkedList<QueryItem> revenueByCity(){
        dataBase = connection.getWritableDatabase();
        LinkedList<QueryItem> res = new LinkedList<QueryItem>();
        String query = "SELECT SUM(price), MIN(price), MAX(price), AVG(price)  FROM SERVICES S INNER JOIN PERSONS P on (S.rfc = P.rfc) GROUP BY P.city";
        try{
            Log.d("tagPerron","nuloooooooooo");
            Cursor c = dataBase.rawQuery(query,null);
            while(c.moveToNext()){
                String[] fields = {c.getFloat(0)+"",c.getFloat(1)+"",c.getFloat(2)+"",c.getFloat(3)+""};
                res.add(new QueryItem(fields,2));
            }
            return res;
        }catch (Exception e){
            Log.d("tagPerron","EXCEPTION");
            error = "";
            return null;
        }finally {
            dataBase.close();
        }
    }

    public LinkedList<QueryItem> personsWithoutService(){
        dataBase = connection.getWritableDatabase();
        LinkedList<QueryItem> res = new LinkedList<QueryItem>();
        String query; //= "select PERSONS.rfc,name,city from PERSONS P left join SERVICES S on(P.rfc = S.rfc) where P.rfc is not null";
        query = "select name,city from PERSONS P where rfc not in (select rfc from SERVICES)";
        try{
            Cursor c = dataBase.rawQuery(query,null);
            while(c.moveToNext()){
                String[] fields = {c.getString(0),c.getString(1),"",""};
                res.add(new QueryItem(fields,0));
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
        String query = "Select substr(date,1,4) as year, city, trademark, count(*) as nServices" +
                        " from SERVICES S inner join PERSONS P on (S.rfc = P.rfc) inner join CARS C on (S.plate = C.plate)" +
                        " group by year, city, trademark";
        try{
            Cursor c = dataBase.rawQuery(query,null);
            while(c.moveToNext()){
                String[] fields = {c.getString(0),c.getString(1),c.getString(1),c.getInt(2)+""};
                res.add(new QueryItem(fields,2));
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
