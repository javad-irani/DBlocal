package com.jnt.newdbs.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DatabaseName = "MarketShopping.db";
    private static final int DatabaseVersion = 1;

    public SQLiteHelper(@Nullable Context context) {

        super(context, DatabaseName, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Fields.createTableMarket);
        sqLiteDatabase.execSQL(Fields.createTableProduct);
        sqLiteDatabase.execSQL(Fields.createTableMP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Fields.SQL_DELETE_MARKET);
        sqLiteDatabase.execSQL(Fields.SQL_DELETE_PRODUCT);
        sqLiteDatabase.execSQL(Fields.SQL_DELETE_MP);
    }


}
