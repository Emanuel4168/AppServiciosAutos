package com.example.emanuel.appserviciosautos.db_conection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.emanuel.appserviciosautos.utils.DataBaseConstants;

public class SQLiteConnection extends SQLiteOpenHelper {

    public SQLiteConnection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBaseConstants.CREATE_TABLE_PERSONS);
        sqLiteDatabase.execSQL(DataBaseConstants.CREATE_TABLE_CARS);
        sqLiteDatabase.execSQL(DataBaseConstants.CREATE_TABLE_SERVICES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DataBaseConstants.getDropTableStrinng(DataBaseConstants.PERSONS_NAME));
        sqLiteDatabase.execSQL(DataBaseConstants.getDropTableStrinng(DataBaseConstants.CARS_TABLE));
        sqLiteDatabase.execSQL(DataBaseConstants.getDropTableStrinng(DataBaseConstants.SERVICES_TABLE));
        onCreate(sqLiteDatabase);
    }
}
