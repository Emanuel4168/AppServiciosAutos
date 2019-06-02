package com.example.emanuel.appserviciosautos.models.data_access_layers;

import android.database.Cursor;

public interface SQLiteModel {

    boolean insert(String RFC, String name, String city);
    String[] consult(String RFC);
    boolean update(String RFC, String name, String city);
    boolean delete(String RFC);
    String getCurrentError();
}
