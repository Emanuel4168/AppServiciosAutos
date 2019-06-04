package com.example.emanuel.appserviciosautos.utils;

public class QueryItem {

    String[] fields;

    public QueryItem(String[] fields) {
        this.fields = fields;
    }

    public String getFields(int pos) {
        return fields[pos];
    }

    public void setFields(String field, int pos) {
        this.fields[pos] = field;
    }
}