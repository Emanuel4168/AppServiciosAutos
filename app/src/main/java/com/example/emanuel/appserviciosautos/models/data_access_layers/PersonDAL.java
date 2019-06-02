package com.example.emanuel.appserviciosautos.models.data_access_layers;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.emanuel.appserviciosautos.db_conection.SQLiteConnection;
import com.example.emanuel.appserviciosautos.utils.DataBaseConstants;

public class PersonDAL {
    private SQLiteConnection connection;
    private SQLiteDatabase dataBase;
    private Context context;
    private String error;

    public PersonDAL(Context context) {
        this.context = context;
        connection = new SQLiteConnection(context, DataBaseConstants.DB_NAME, null, 1);
        dataBase = connection.getWritableDatabase();
    }

    public boolean insert(String RFC, String name, String city) {
        String insert = "INSERT INTO " + DataBaseConstants.PERSONS_TABLE + " VALUES ( '" + RFC + "', '" + name + "', '" + city + "', " + "1)";
        try {
            dataBase.execSQL(insert);
            error = "";
            return true;
        } catch (Exception e) {
            error = "No fué posible realizar la operación, es probable que ya exista alguien con este RFC";
            return false;
        }
    }

    public String[] consult(String RFC) {
        String consult = "SELECT * FROM " + DataBaseConstants.PERSONS_TABLE + " where " + DataBaseConstants.PERSONS_RFC + "= " + RFC;
        try {
            Cursor c = dataBase.rawQuery(consult, null);
            if (c.getCount() == 0) {
                error = "No fué posible realizar la operación, es probable que no exista alguien con este RFC";
                return null;
            }

            c.moveToFirst();
            error = "";
            String[] res = {c.getString(0), c.getString(1), c.getString(2)};
            return res;
        } catch (Exception e) {
            error = "No fué posible realizar la operación, es probable que no exista alguien con este RFC";
            return null;
        }
    }

    public boolean update(String RFC, String name, String city){
        String update="Update "+DataBaseConstants.PERSONS_TABLE+" set "+DataBaseConstants.PERSONS_RFC+"='"+RFC+
                "', "+DataBaseConstants.PERSONS_NAME+"='"+name+"', "+DataBaseConstants.PERSONS_CITY+"='"+city
                +"' where "+DataBaseConstants.PERSONS_RFC+"Like"+"'"+RFC+"'";
        try{
            dataBase.execSQL(update);
            error = "";
            return true;
        }catch (Exception e){
            error = "No fué posible realizar la operación, es probable que no exista alguien con este RFC";
            return false;
        }
    }

    public boolean delete(String RFC){
        String delete="Update "+DataBaseConstants.PERSONS_TABLE+" set "+ DataBaseConstants.PERSONS_STATUS+"= 0 " +
                "where "+DataBaseConstants.PERSONS_RFC+" like '"+RFC+"'";
        try{
            dataBase.execSQL(delete);
            error = "";
            return true;
        }catch (Exception e){
            error = "No fué posible realizar la operación, es probable que no exista alguien con este RFC";
            return false;
        }
    }

    public String getCurrentError() {
        return error;
    }
}
