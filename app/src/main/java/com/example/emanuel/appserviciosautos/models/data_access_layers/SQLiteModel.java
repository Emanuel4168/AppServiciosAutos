package com.example.emanuel.appserviciosautos.models.data_access_layers;

import android.database.Cursor;

public interface SQLiteModel {

    void insert(String RFC, String name, String city);
    String[] consult(String RFC);
    void update(String RFC, String name, String city);
    void delete();
    String getCurrentError();
}
