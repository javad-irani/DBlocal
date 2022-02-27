package com.jnt.newdbs.DataBase;

import android.provider.BaseColumns;

public class Fields {

    public static class TableMarket implements BaseColumns {
        public static final String MARKET_TABLE = "MARKET_TABLE";
        public static final String COLUMN_MARKET_NAME = "MARKET_NAME";
        public static final String COLUMN_MARKET_ADDRESS = "MARKET_ADDRESS";
        public static final String COLUMN_MARKET_ACTIVE = "MARKET_ACTIVE";
    }

    public static class TableProduct implements BaseColumns {
        public static final String PRODUCT_TABLE = "PRODUCT_TABLE";
        public static final String COLUMN_PRODUCT_NAME = "PRODUCT_NAME";
        public static final String COLUMN_PRODUCT_PRICE = "PRODUCT_PRICE";
        public static final String COLUMN_PRODUCT_ACTIVE = "PRODUCT_ACTIVE";
    }

    // MP mean market product
    public static class TableMP implements BaseColumns {
        public static final String MP_TABLE = "MP_TABLE";
        public static final String COLUMN_MP_MARKET_ID = "MP_MARKET_ID";
        public static final String COLUMN_MP_PRODUCT_ID = "MP_PRODUCT_ID";
        public static final String COLUMN_MP_LABEL = "MP_lABEL";
        public static final String COLUMN_MP_ACTIVE = "MP_ACTIVE";
    }

    public static final String createTableMarket = "CREATE TABLE " +
            TableMarket.MARKET_TABLE + " (" +
            TableMarket._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            TableMarket.COLUMN_MARKET_NAME + " TEXT, " +
            TableMarket.COLUMN_MARKET_ADDRESS + " TEXT, " +
            TableMarket.COLUMN_MARKET_ACTIVE + " BOOL)";

    public static final String createTableProduct = "CREATE TABLE " +
            TableProduct.PRODUCT_TABLE + " (" +
            TableProduct._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            TableProduct.COLUMN_PRODUCT_NAME + " TEXT, " +
            TableProduct.COLUMN_PRODUCT_PRICE + " TEXT, " +
            TableProduct.COLUMN_PRODUCT_ACTIVE + " BOOL)";

    public static final String createTableMP = "CREATE TABLE " +
            TableMP.MP_TABLE + " (" +
            TableMP._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            TableMP.COLUMN_MP_MARKET_ID + " INTEGER, " +
            TableMP.COLUMN_MP_PRODUCT_ID + " INTEGER, " +
            TableMP.COLUMN_MP_LABEL + " TEXT, " +
            TableMP.COLUMN_MP_ACTIVE + " BOOL)";

    public static final String SQL_DELETE_MARKET =
            "DROP TABLE IF EXISTS " + TableMarket.MARKET_TABLE;

    public static final String SQL_DELETE_PRODUCT =
            "DROP TABLE IF EXISTS " + TableProduct.PRODUCT_TABLE;

    public static final String SQL_DELETE_MP =
            "DROP TABLE IF EXISTS " + TableMP.MP_TABLE;

}
