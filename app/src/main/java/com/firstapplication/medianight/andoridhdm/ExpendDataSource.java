package com.firstapplication.medianight.andoridhdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

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

    public CreditsModel createCredit (CreditsModel creditsmodel) {
        Log.d("Database", creditsmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, creditsmodel.getCreditsNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, creditsmodel.getCreditsAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, creditsmodel.getCreditsDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        creditsmodel.setCreditID(insertId);
        return creditsmodel;

    }

    public DebtsModel createDebt (DebtsModel debtsmodel) {
        Log.d("Databse", debtsmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, debtsmodel.getDebtsNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, debtsmodel.getDebtsAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, debtsmodel.getDebtsDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        debtsmodel.setDebtID(insertId);
        return debtsmodel;

    }
    public IncomeModel createIncome (IncomeModel incomedmodel) {
        Log.d("Databse", incomedmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, incomedmodel.getIncomeNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, incomedmodel.getIncomeAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, incomedmodel.getIncomeDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        incomedmodel.setIncID(insertId);
        return incomedmodel;

    }
    public SavingModel createSaving (SavingModel savingmodel) {
        Log.d("Databse", savingmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, savingmodel.getSaveNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, savingmodel.getSaveAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, savingmodel.getSaveDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        savingmodel.setSaveID(insertId);
        return savingmodel;

    }

    public PExpendModel createPExpend (PExpendModel pexpendgmodel) {
        Log.d("Databse", pexpendgmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, pexpendgmodel.getPExpendNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, pexpendgmodel.getPExpendAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, pexpendgmodel.getPExpendDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        pexpendgmodel.setPExpID(insertId);
        return pexpendgmodel;

    }

    public PIncomeModel createPIncome (PIncomeModel pincomegmodel) {
        Log.d("Databse", pincomegmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, pincomegmodel.getPIncomeNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, pincomegmodel.getPIncomeAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, pincomegmodel.getPIncomeDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        pincomegmodel.setPIncID(insertId);
        return pincomegmodel;

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