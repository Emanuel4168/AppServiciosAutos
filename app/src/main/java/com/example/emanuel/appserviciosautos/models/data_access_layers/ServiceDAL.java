package com.example.emanuel.appserviciosautos.models.data_access_layers;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.emanuel.appserviciosautos.db_conection.SQLiteConnection;
import com.example.emanuel.appserviciosautos.utils.DataBaseConstants;

public class ServiceDAL {
    private SQLiteConnection connection;
    private SQLiteDatabase dataBase;
    private Context context;
    private String error, errorDefault;

    public ServiceDAL(Context context) {
        this.context = context;
        connection = new SQLiteConnection(context, DataBaseConstants.DB_NAME, null, 1);
        dataBase = connection.getWritableDatabase();
        errorDefault = "No fue posible realizar la operación, es probable que no exista un servicio con ese número de orden";
    }

    public boolean insert(String[] fields) {
        String insert = "INSERT INTO " + DataBaseConstants.SERVICES_TABLE + " VALUES ( '" + fields[0] + "', '" + fields[1] + "', '" + fields[2] + "', " + fields[3] + fields[4] + fields[5];
        try {
            dataBase.execSQL(insert);
            error = "";
            return true;
        } catch (Exception e) {
            error = "No fue posible realizar la operación, es probable que ya exista un servicio con ese número de orden";
            return false;
        }
    }

    public String[] consult(String order) {
        String consult = "SELECT * FROM " + DataBaseConstants.SERVICES_TABLE + " where " + DataBaseConstants.SERVICE_ORDER + "= " + order;
        try {
            Cursor c = dataBase.rawQuery(consult, null);
            if (c.getCount() == 0) {
                error = errorDefault;
                return null;
            }

            c.moveToFirst();
            error = "";
            String[] res = {c.getInt(0)+"", c.getString(1), c.getString(2), c.getInt(3)+"", c.getFloat(4)+"", c.getString(5)};
            return res;
        } catch (Exception e) {
            error = errorDefault;
            return null;
        }
    }

    public boolean update(String[] fields){
        String update="Update "+DataBaseConstants.SERVICES_TABLE+" set "+DataBaseConstants.SERVICE_ORDER+"='"+fields[0]+
                "', "+DataBaseConstants.SERVICE_KILOMETERS+"='"+fields[3]+"', "+DataBaseConstants.SERVICE_PRICE+"='"+fields[4]
                + DataBaseConstants.SERVICE_DATE+"='"+fields[5]+"', "
                +"' where "+DataBaseConstants.SERVICE_ORDER+"Like"+"'"+fields[0]+"'";
        try{
            dataBase.execSQL(update);
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
