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
    private String error, errorDefault;

    public PersonDAL(Context context) {
        this.context = context;
        connection = new SQLiteConnection(context, DataBaseConstants.DB_NAME, null, 1);
        dataBase = connection.getWritableDatabase();
        errorDefault = "No fue posible realizar la operación, es probable que no exista alguien con ese RFC";
    }

    public boolean insert(String[] fields) {
        String insert = "INSERT INTO " + DataBaseConstants.PERSONS_TABLE + " VALUES ( '" + fields[0] + "', '" + fields[1] + "', '" + fields[2] + "', " + "1)";
        try {
            dataBase.execSQL(insert);
            error = "";
            return true;
        } catch (Exception e) {
            error = "No fue posible realizar la operación, es probable que ya exista alguien con ese RFC";
            return false;
        }
    }

    public String[] consult(String RFC) {
        String consult = "SELECT * FROM " + DataBaseConstants.PERSONS_TABLE + " where " + DataBaseConstants.PERSONS_RFC + "= " + RFC;
        try {
            Cursor c = dataBase.rawQuery(consult, null);
            if (c.getCount() == 0) {
                error = errorDefault;
                return null;
            }

            c.moveToFirst();
            if(c.getInt(3)==0){
                error = "Ya no existe la persona con ese RFC";
                return null;
            }
            error = "";
            String[] res = {c.getString(0), c.getString(1), c.getString(2)};
            return res;
        } catch (Exception e) {
            error = errorDefault;
            return null;
        }
    }

    public boolean update(String[] fields){
        String update="Update "+DataBaseConstants.PERSONS_TABLE+" set "+DataBaseConstants.PERSONS_RFC+"='"+fields[0]+
                "', "+DataBaseConstants.PERSONS_NAME+"='"+fields[1]+"', "+DataBaseConstants.PERSONS_CITY+"='"+fields[2]
                +"' where "+DataBaseConstants.PERSONS_RFC+"Like"+"'"+fields[0]+"'";
        try{
            String[] person = this.consult(fields[0]);
            if(person == null){
                return false;
            }

            dataBase.execSQL(update);
            error = "";
            return true;
        }catch (Exception e){
            error = errorDefault;
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
            error = errorDefault;
            return false;
        }
    }

    public String getCurrentError() {
        return error;
    }
}
