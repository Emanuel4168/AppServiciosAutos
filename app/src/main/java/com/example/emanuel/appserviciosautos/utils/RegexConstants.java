package com.example.emanuel.appserviciosautos.utils;

public class RegexConstants {

    public final static String RFC_REGEX = "[A-Za-z]{4}[0-9]{9}";
    public final static String NAME_REGEX = "[A-Za-z]{3,15}\\s[A-Za-z]{3,15}";
    public final static String CITY_REGEX = "[A-Za-z]{4,20}";

    public final static String PLATE_REGEX = "[A-Za-z]{3}[0-9]{4}";
    public final static String TRADEMARK_REGEX = "[A-Za-z]{3,14}";
    public final static String MODEL_REGEX = "[A-Za-z]{3,14}";
    public final static String YEAR_REGEX = "[1-2]{1}[0-9]{3}";

    public final static String ORDER_REGEX = "[0-9]{1,5}";
    public final static String KM_REGEX = "[0-9]{3,6}";
    public final static String PRICE_REGEX= "[0-9]{3,5}[.][0-9]{2}";
    public final static String DATE_REGEX = "[1-2]{1}[0-9]{7}";

}
