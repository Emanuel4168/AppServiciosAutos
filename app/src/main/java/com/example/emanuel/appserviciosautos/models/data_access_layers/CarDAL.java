package com.example.emanuel.appserviciosautos.models.data_access_layers;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.emanuel.appserviciosautos.db_conection.SQLiteConnection;
import com.example.emanuel.appserviciosautos.utils.DataBaseConstants;

public class CarDAL {
    private SQLiteConnection connection;
    private SQLiteDatabase dataBase;
    private Context context;
    private String error, errorDefault;

    public CarDAL(Context context) {
        this.context = context;
        connection = new SQLiteConnection(context, DataBaseConstants.DB_NAME, null, 1);
        dataBase = connection.getWritableDatabase();
        errorDefault = "No fué posible realizar la operación, es probable que ya exista un carro con esa placa";
    }

    public boolean insert(String[] fields) {
        String insert = "INSERT INTO " + DataBaseConstants.CARS_TABLE + " VALUES ( '" + fields[0] + "', '" + fields[1] + "', '" + fields[2] + "', " + fields[3] + ")" + "1)";
        try {
            dataBase.execSQL(insert);
            error = "";
            return true;
        } catch (Exception e) {
            error = errorDefault;
            return false;
        }
    }

    public String[] consult(String plate) {
        String consult = "SELECT * FROM " + DataBaseConstants.CARS_TABLE + " where " + DataBaseConstants.CARS_PLATE + "= " + plate;
        try {
            Cursor c = dataBase.rawQuery(consult, null);
            if (c.getCount() == 0) {
                error = errorDefault;
                return null;
            }

            c.moveToFirst();
            if(c.getInt(4)==0){
                error = "Ya no existe el carro con esa placa";
                return null;
            }
            error = "";
            String[] res = {c.getString(0), c.getString(1), c.getString(2), c.getInt(3)+""};
            return res;
        } catch (Exception e) {
            error = errorDefault;
            return null;
        }
    }

    public boolean update(String[] fields){
        String update="Update "+DataBaseConstants.CARS_TABLE+" set "+DataBaseConstants.CARS_PLATE+"='"+fields[0]+
                "', "+DataBaseConstants.CARS_TRADEMARK+"='"+fields[1]+"', "+DataBaseConstants.CARS_MODEL+"='"+fields[2]
                + DataBaseConstants.CARS_YEAR+"='"+fields[3]+"', "
                +"' where "+DataBaseConstants.CARS_PLATE+"Like"+"'"+fields[0]+"'";
        try{
            dataBase.execSQL(update);
            error = "";
            return true;
        }catch (Exception e){
            error = errorDefault;
            return false;
        }
    }

    public boolean delete(String plate){
        String delete="Update "+DataBaseConstants.CARS_TABLE+" set "+ DataBaseConstants.CARS_STATUS+"= 0 " +
                "where "+DataBaseConstants.CARS_PLATE+" like '"+plate+"'";
        try{
            dataBase.execSQL(delete);
            error = "";
            return true;
        }catch (Exception e){
            error = errorDefault;
            return false;
        }
    }

    public String getCurrentError() {
        return error;
    }
}
