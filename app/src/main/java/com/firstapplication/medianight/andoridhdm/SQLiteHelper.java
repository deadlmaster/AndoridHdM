package com.firstapplication.medianight.andoridhdm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Cpt Cranberry on 04/01/2015. Diese Klasse erstellt die SQLiteDB
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "plainPlaner.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * Tabellen hinzufuegen
     */
    private static final String TABLE_CREATE_EXPENDS= ""
            +"create table if not exists EXPENDS("
            +"  ID integer primary key autoincrement, "
            +"ExpendName VARCHAR, "
            +"ExpendAmount VARCHAR"
            +"ExpendDate VARCHAR" ;



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Tabelle wird erstellt
     * @param database
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(TABLE_CREATE_EXPENDS);

    }

    /**
     * Updatet die Version der DB sofern noetig
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS SCANITEM");
        onCreate(db);
    }
}