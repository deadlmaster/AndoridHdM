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
        Log.d("DatabaseExp", expendmodel.toString());

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, expendmodel.getExpendNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, expendmodel.getExpendAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, expendmodel.getExpendDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        expendmodel.setExpID(insertId);
        return expendmodel;

    }

    public CreditsModel createCredit (CreditsModel creditsmodel) {
        Log.d("DatabaseCredit", creditsmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, creditsmodel.getCreditsNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, creditsmodel.getCreditsAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, creditsmodel.getCreditsDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        creditsmodel.setCreditID(insertId);
        return creditsmodel;

    }

    public DebtsModel createDebt (DebtsModel debtsmodel) {
        Log.d("DatabaseDevt", debtsmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, debtsmodel.getDebtsNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, debtsmodel.getDebtsAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, debtsmodel.getDebtsDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        debtsmodel.setDebtID(insertId);
        return debtsmodel;

    }
    public IncomeModel createIncome (IncomeModel incomedmodel) {
        Log.d("DatabaseInc", incomedmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, incomedmodel.getIncomeNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, incomedmodel.getIncomeAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, incomedmodel.getIncomeDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        incomedmodel.setIncID(insertId);
        return incomedmodel;

    }
    public SavingModel createSaving (SavingModel savingmodel) {
        Log.d("DatabaseSave", savingmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, savingmodel.getSaveNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, savingmodel.getSaveAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, savingmodel.getSaveDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        savingmodel.setSaveID(insertId);
        return savingmodel;

    }

    public PExpendModel createPExpend (PExpendModel pexpendgmodel) {
        Log.d("DatabasePExp", pexpendgmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, pexpendgmodel.getPExpendNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, pexpendgmodel.getPExpendAmountString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        pexpendgmodel.setPExpID(insertId);
        return pexpendgmodel;

    }

    public PIncomeModel createPIncome (PIncomeModel pincomegmodel) {
        Log.d("DatabasePInc", pincomegmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, pincomegmodel.getPIncomeNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, pincomegmodel.getPIncomeAmountString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        pincomegmodel.setPIncID(insertId);
        return pincomegmodel;

    }

    public List<ExpendModel> getAllExpends() {
        List<ExpendModel> expendslist = new ArrayList<ExpendModel>();

        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_EXPENDS;

        Cursor cursor = database.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        ExpendModel expend = null;
        if (cursor.moveToFirst()) {
            do {
                expend = new ExpendModel();
                expend.setExpID(Integer.parseInt(cursor.getString(0)));
                expend.setExpendNameString(cursor.getString(1));
                expend.setExpendAmountString(cursor.getString(2));
                expend.setExpendDateString(cursor.getString(3));

                // Add book to books
                expendslist.add(expend);
            } while (cursor.moveToNext());
        }

        Log.d("getAllBooks()", expend.toString());


        return expendslist;
    }


   /** public boolean testdeleteexpend (long expDel){
        String where = SQLiteHelper.COLUMN_EXPENDS_ID + "=" + expDel;
        return database.delete(SQLiteHelper.TABLE_EXPENDS, where, null) !=0;
    }*/

    public boolean deleteExpend(String expLike){
        Log.d("String", expLike.toString());
        String where = SQLiteHelper.COLUMN_EXPENDS_NAME + " LIKE " + "'" + expLike + "%'";
        return database.delete(SQLiteHelper.TABLE_EXPENDS, where, null) !=0;
    }
}