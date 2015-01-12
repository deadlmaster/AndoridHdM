package com.firstapplication.medianight.andoridhdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cpt Cranberry on 11/01/2015.
 */
public class ExpendDataSource {



    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;

    public final String[] expColumns = {
            SQLiteHelper.COLUMN_EXPENDS_ID,
            SQLiteHelper.COLUMN_EXPENDS_NAME,
            SQLiteHelper.COLUMN_EXPENDS_AMOUNT,
            SQLiteHelper.COLUMN_EXPENDS_DATE,
    };

    public ExpendDataSource(Context context) {

        dbHelper = new SQLiteHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public ExpendModel createExpend (ExpendModel expendmodel) {
        Log.d("Databse", expendmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, expendmodel.getExpendNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, expendmodel.getExpendAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, expendmodel.getExpendDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        expendmodel.setExpID(insertId);
        return expendmodel;

    }

    public List<ExpendModel> getAllExpends() {
        List<ExpendModel> expendslist = new ArrayList<ExpendModel>();

        Cursor cursor = database.query(SQLiteHelper.TABLE_EXPENDS,
                expColumns, null, null, null, null, SQLiteHelper.COLUMN_EXPENDS_DATE);

        if (cursor.getCount() > 0) {
             while (!cursor.isAfterLast()) {
                 ExpendModel expendModel = new ExpendModel();
                 expendModel.setExpID(cursor.getLong(cursor.getColumnIndex(SQLiteHelper.COLUMN_EXPENDS_ID)));
                 expendModel.setExpendNameString(cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_EXPENDS_NAME)));
                 expendModel.setExpendAmountString(cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_EXPENDS_AMOUNT)));
                 expendModel.setExpendDateString(cursor.getString(cursor.getColumnIndex(SQLiteHelper.COLUMN_EXPENDS_DATE)));
                 expendslist.add(expendModel);

             }
        }
        Log.d("DatabaseList", expendslist.toString());
        return expendslist;
    }


}