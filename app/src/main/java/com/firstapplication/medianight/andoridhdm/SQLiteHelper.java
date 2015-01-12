package com.firstapplication.medianight.andoridhdm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "plainplaner.db";
    private static final int DATABASE_VERSION = 1;



    // columns of the expends table

    public static final String TABLE_EXPENDS = "expends";
    public static final String COLUMN_EXPENDS_ID = "expendId";
    public static final String COLUMN_EXPENDS_NAME = "expendName";
    public static final String COLUMN_EXPENDS_AMOUNT = "expendsAmount";
    public static final String COLUMN_EXPENDS_DATE = "expendsDate";


    // SQL statement of the expends table creation

    private static final String SQL_CREATE_TABLE_EXPENDS =
            "CREATE TABLE " + TABLE_EXPENDS + " ("
            + COLUMN_EXPENDS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_EXPENDS_NAME + " TEXT, "
            + COLUMN_EXPENDS_AMOUNT + " TEXT, "
            + COLUMN_EXPENDS_DATE + " TEXT) ";


    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_EXPENDS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENDS);

    }



}