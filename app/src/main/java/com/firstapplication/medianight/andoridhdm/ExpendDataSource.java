package com.firstapplication.medianight.andoridhdm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cpt Cranberry on 11/01/2015.
 */
public class ExpendDataSource {



    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

    public final String[] expColumns = {
            SQLiteHelper.COLUMN_EXPENDS_NAME,
            SQLiteHelper.COLUMN_EXPENDS_AMOUNT,
            SQLiteHelper.COLUMN_EXPENDS_DATE,
    };

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public ExpendModel createExpendmodel(String ExpendNameString, String ExpendAmountString, String ExpendDateString) {
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, ExpendNameString);
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, ExpendAmountString);
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, ExpendDateString);

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        Cursor cursor = database.query("expends",expColumns, "ID = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        //ExpendModel newExpendModel = cursorToExpendModel(cursor);
        cursor.close();
        return cursorToExpendModel(cursor);

   }

   /** private ExpendModel cursorToExpendModel(Cursor cursor) {
        ExpendModel ExpendModel = new ExpendModel();
        ExpendModel.setExpID(cursor.getLong(0));
        ExpendModel.setExpendNameString(cursor.getString(1));
        ExpendModel.setExpendAmountString(cursor.getString(2));
        ExpendModel.setExpendDateString(cursor.getString(3));
        return ExpendModel;
    }*/
}
