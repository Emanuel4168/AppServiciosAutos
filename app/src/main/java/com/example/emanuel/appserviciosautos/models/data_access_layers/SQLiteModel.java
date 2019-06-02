package com.example.emanuel.appserviciosautos.models.data_access_layers;

import android.database.Cursor;

public interface SQLiteModel {

    public void insert();
    public String[] consult();
    public void update();
    public void delete();
    public String getCurrentError();
}
