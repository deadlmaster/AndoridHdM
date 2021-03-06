package com.firstapplication.medianight.andoridhdm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "plainplaner.db";
    private static final int DATABASE_VERSION = 4;


    // columns of the expends table

    public static final String TABLE_EXPENDS = "expends";
    public static final String COLUMN_EXPENDS_ID = "_expid";
    public static final String COLUMN_EXPENDS_NAME = "expendName";
    public static final String COLUMN_EXPENDS_AMOUNT = "expendsAmount";
    public static final String COLUMN_EXPENDS_DATE = "expendsDate";

    // columns of the dreamgoal

    public static final String TABLE_DREAMGOAL = "dreamgoal";
    public static final String COLUMN_DREAMGOAL_ID = "_id";
    public static final String COLUMN_DREAMGOAL_NAME = "dreamgoal_name";
    public static final String COLUMN_DREAMGOAL_AMOUNT = "dreamgoal_amount";
    public static final String COLUMN_DREAMGOAL_DATE = "dreamgoal_date";

    // columns of the income table

    public static final String TABLE_INCOME = "income";
    public static final String COLUMN_INCOME_ID = "_id";
    public static final String COLUMN_INCOME_NAME = "income_name";
    public static final String COLUMN_INCOME_AMOUNT = "income_amount";
    public static final String COLUMN_INCOME_DATE = "income_date";

    // columns of the periodical expends table

    public static final String TABLE_PEXPENDS = "pexpends_income";
    public static final String COLUMN_PEXPENDS_ID = "_id";
    public static final String COLUMN_PEXPENDS_NAME = "pexpends_name";
    public static final String COLUMN_PEXPENDS_AMOUNT = "pexpends_amount";

    // columns of the periodical income table

    public static final String TABLE_PINCOME = "pincome";
    public static final String COLUMN_PINCOME_ID = "_id";
    public static final String COLUMN_PINCOME_NAME = "pincome_name";
    public static final String COLUMN_PINCOME_AMOUNT = "pincome_amount";

    // columns of the debts table

    public static final String TABLE_DEBTS = "debts";
    public static final String COLUMN_DEBTS_ID = "_id";
    public static final String COLUMN_DEBTS_NAME = "debts_name";
    public static final String COLUMN_DEBTS_AMOUNT = "debts_amount";
    public static final String COLUMN_DEBTS_DATE = "debts_date";

    // columns of the credits table

    public static final String TABLE_CREDITS = "credits";
    public static final String COLUMN_CREDITS_ID = "_id";
    public static final String COLUMN_CREDITS_NAME = "credits_name";
    public static final String COLUMN_CREDITS_AMOUNT = "credits_amount";
    public static final String COLUMN_CREDITS_DATE = "credits_date";



    // SQL statement of the expends table creation

    private static final String SQL_CREATE_TABLE_EXPENDS =
            "CREATE TABLE if not exists " + TABLE_EXPENDS + " ("
            + COLUMN_EXPENDS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_EXPENDS_NAME + " TEXT, "
            + COLUMN_EXPENDS_AMOUNT + " INTEGER, "
            + COLUMN_EXPENDS_DATE + " TEXT) ";

    // SQL statement of the dreamgoal table creation

    private static final String SQL_CREATE_TABLE_DREAMGOAL =
            "CREATE TABLE if not exists " + TABLE_DREAMGOAL + " ("
            + COLUMN_DREAMGOAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DREAMGOAL_NAME + " TEXT, "
            + COLUMN_DREAMGOAL_AMOUNT + " TEXT, "
            + COLUMN_DREAMGOAL_DATE + " TEXT) ";


    // SQL statement of the income table creation

    private static final String SQL_CREATE_TABLE_INCOME =
            "CREATE TABLE if not exists " + TABLE_INCOME + " ("
            + COLUMN_INCOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_INCOME_NAME + " TEXT, "
            + COLUMN_INCOME_AMOUNT + " TEXT, "
            + COLUMN_INCOME_DATE + " TEXT) ";


    // SQL statement of the pincome table creation

    private static final String SQL_CREATE_TABLE_PINCOME =
            "CREATE TABLE if not exists " + TABLE_PINCOME + " ("
            + COLUMN_PINCOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PINCOME_NAME + " TEXT, "
            + COLUMN_PINCOME_AMOUNT + " TEXT) ";


    // SQL statement of the pexpend table creation

    private static final String SQL_CREATE_TABLE_PEXPENDS =
            "CREATE TABLE if not exists " + TABLE_PEXPENDS + " ("
            + COLUMN_PEXPENDS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PEXPENDS_NAME + " TEXT, "
            + COLUMN_PEXPENDS_AMOUNT + " TEXT) ";


    // SQL statement of the debts table creation

    private static final String SQL_CREATE_TABLE_DEBTS =
            "CREATE TABLE if not exists " + TABLE_DEBTS + " ("
            + COLUMN_DEBTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DEBTS_NAME + " TEXT, "
            + COLUMN_DEBTS_AMOUNT + " TEXT, "
            + COLUMN_DEBTS_DATE + " TEXT) ";

    // SQL statement of the credits table creation

    private static final String SQL_CREATE_TABLE_CREDITS =
            "CREATE TABLE if not exists " + TABLE_CREDITS + " ("
            + COLUMN_CREDITS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CREDITS_NAME + " TEXT, "
            + COLUMN_CREDITS_AMOUNT + " TEXT, "
            + COLUMN_CREDITS_DATE + " TEXT) ";


    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE_EXPENDS);
        db.execSQL(SQL_CREATE_TABLE_INCOME);
        db.execSQL(SQL_CREATE_TABLE_PINCOME);
        db.execSQL(SQL_CREATE_TABLE_PEXPENDS);
        db.execSQL(SQL_CREATE_TABLE_DEBTS);
        db.execSQL(SQL_CREATE_TABLE_CREDITS);
        db.execSQL(SQL_CREATE_TABLE_DREAMGOAL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INCOME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PINCOME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEXPENDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEBTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DREAMGOAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CREDITS);

      this.onCreate(db);
    }



}