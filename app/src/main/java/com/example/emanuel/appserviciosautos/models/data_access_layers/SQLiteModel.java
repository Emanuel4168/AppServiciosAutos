package com.example.emanuel.appserviciosautos.models.data_access_layers;

import android.database.Cursor;

public interface SQLiteModel {

    boolean insert(String [] fields);
    String[] consult(String id);
    boolean update(String [] fields);
    boolean delete(String id);
    String getCurrentError();
}
