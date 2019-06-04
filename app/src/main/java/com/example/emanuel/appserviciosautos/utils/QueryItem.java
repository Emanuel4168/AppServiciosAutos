package com.example.emanuel.appserviciosautos.utils;

public class QueryItem {

    String[] fields;
    int type;

    public QueryItem(String[] fields, int type) {
        this.fields = fields;
        this.type = type;
    }

    public String getFields(int pos) {
        return fields[pos];
    }

    public void setFields(String field, int pos) {
        this.fields[pos] = field;
    }

    public int getType(){
        return type;
    }

    public void setType(int type){
        this.type = type;
    }
}