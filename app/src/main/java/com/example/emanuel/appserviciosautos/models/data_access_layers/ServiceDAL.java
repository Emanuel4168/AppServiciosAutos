package com.example.emanuel.appserviciosautos.models.data_access_layers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.emanuel.appserviciosautos.db_conection.SQLiteConnection;
import com.example.emanuel.appserviciosautos.utils.DataBaseConstants;
import com.example.emanuel.appserviciosautos.utils.Routines;
import com.example.emanuel.appserviciosautos.models.*;

public class ServiceDAL {
    private SQLiteConnection connection;
    private SQLiteDatabase dataBase;
    private Context context;
    private String error, errorDefault;
    private CarModel carModel;
    private PersonModel personModel;

    public ServiceDAL(Context context) {
        this.context = context;
        connection = new SQLiteConnection(context, DataBaseConstants.DB_NAME, null, 1);
        errorDefault = "No fue posible realizar la operación, es probable que no exista un servicio con ese número de orden";
        carModel = new CarModel(context);
        personModel = new PersonModel(context);
    }

    public boolean insert(String[] fields) {
        dataBase = connection.getWritableDatabase();
        String insert = "INSERT INTO " + DataBaseConstants.SERVICES_TABLE + " VALUES ( " + fields[0] + ", '" + fields[1] + "', '" + fields[2] + "', " + fields[3]+" , " + fields[4]+", '"+ fields[5]+"')";

        //Verificar que el auto exista
        if(carModel.consult(fields[1])==null){
            error = "¡OOPS! No existe el auto.";
            return false;
        }

        //Verificar que la persona exista
        if(personModel.consult(fields[2])==null){
            error = "¡OOPS! No existe la persona.";
            return false;
        }
        try {
            dataBase.execSQL(insert);
            error = "";
            return true;
        } catch (Exception e) {
            error = "No fue posible realizar la operación, es probable que ya exista un servicio con ese número de orden";
            return false;
        }finally {
            dataBase.close();
        }
    }

    public String[] consult(String order) {
        dataBase = connection.getWritableDatabase();
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
        }finally {
            dataBase.close();
        }
    }

    public boolean update(String[] fields){
        dataBase = connection.getWritableDatabase();
        String update="Update "+DataBaseConstants.SERVICES_TABLE+" set "+DataBaseConstants.SERVICE_ORDER+"='"+fields[0]+
                "', "+DataBaseConstants.SERVICE_KILOMETERS+"='"+fields[3]+"', "+DataBaseConstants.SERVICE_PRICE+"='"+fields[4]
                + DataBaseConstants.SERVICE_DATE+"='"+fields[5]+"', "
                +"' where "+DataBaseConstants.SERVICE_ORDER+"Like"+"'"+fields[0]+"'";
        try{
            String[] service = consult(fields[0]);
            if(service == null){
                return false;
            }
            dataBase.execSQL(update);
            error = "";
            return true;
        }catch (Exception e){
            error = errorDefault;
            return false;
        }finally {
            dataBase.close();
        }
    }

    public String getCurrentError() {
        return error;
    }
}
