package com.example.emanuel.appserviciosautos.utils;

public class DataBaseConstants {

    public static final String DB_NAME = "SERVICESDB";

    public static final String PERSONS_TABLE = "PERSONS";
    public static final String PERSONS_RFC = "rfc";
    public static final String PERSONS_NAME = "name";
    public static final String PERSONS_CITY = "city";
    public static final String PERSONS_STATUS = "status";

    public static final String CARS_TABLE = "CARS";
    public static final String CARS_PLATE = "plate";
    public static final String CARS_TRADEMARK = "trademark";
    public static final String CARS_MODEL = "model";
    public static final String CARS_YEAR = "year";
    public static final String CARS_STATUS = "status";

    public static final String SERVICES_TABLE = "SERVICES";;
    public static final String SERVICE_ORDER = "orden";
//    public static final String SERVICE_PlATE = "plate";
//    public static final String SERVICE_RFC = "rfc";
    public static final String SERVICE_KILOMETERS = "kilometers";
    public static final String SERVICE_PRICE = "price";
    public static final String SERVICE_DATE = "date";

    public static final String CREATE_TABLE_PERSONS = "CREATE TABLE "+PERSONS_TABLE+"("+PERSONS_RFC+" TEXT PRIMARY KEY, " +PERSONS_NAME+" TEXT, " +PERSONS_CITY+" TEXT, "+PERSONS_STATUS+" INTEGER)";
    public static final String CREATE_TABLE_CARS = "CREATE TABLE "+CARS_TABLE+"("+CARS_PLATE+" TEXT PRIMARY KEY, " +CARS_TRADEMARK+" TEXT, " +CARS_MODEL+" TEXT, "+CARS_YEAR+" INTEGER, "+CARS_STATUS+" INTEGER)";
    public static final String CREATE_TABLE_SERVICES = "CREATE TABLE "+SERVICES_TABLE+"("+SERVICE_ORDER+" INTEGER PRIMARY KEY, " +CARS_PLATE+" TEXT, " +PERSONS_RFC +" TEXT, "+SERVICE_KILOMETERS+" INTEGER, "+SERVICE_PRICE+" REAL, "+SERVICE_DATE+" TEXT)";

    public static String getDropTableStrinng(String tableName){
        return "DROP TABLE IF EXISTS "+ tableName;
    }
}
