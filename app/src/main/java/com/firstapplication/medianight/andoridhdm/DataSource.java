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
public class DataSource {



    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase database;

    public final String[] expColumns = {
            SQLiteHelper.COLUMN_EXPENDS_ID,
            SQLiteHelper.COLUMN_EXPENDS_NAME,
            SQLiteHelper.COLUMN_EXPENDS_AMOUNT,
            SQLiteHelper.COLUMN_EXPENDS_DATE,
    };

    public DataSource(Context context) {

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
        values.put(SQLiteHelper.COLUMN_CREDITS_NAME, creditsmodel.getCreditsNameString());
        values.put(SQLiteHelper.COLUMN_CREDITS_AMOUNT, creditsmodel.getCreditsAmountString());
        values.put(SQLiteHelper.COLUMN_CREDITS_DATE, creditsmodel.getCreditsDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_CREDITS, null, values);
        creditsmodel.setCreditID(insertId);
        return creditsmodel;

    }



    public DebtsModel createDebt (DebtsModel debtsmodel) {
        Log.d("DatabaseDevt", debtsmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_DEBTS_NAME, debtsmodel.getDebtsNameString());
        values.put(SQLiteHelper.COLUMN_DEBTS_AMOUNT, debtsmodel.getDebtsAmountString());
        values.put(SQLiteHelper.COLUMN_DEBTS_DATE, debtsmodel.getDebtsDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_DEBTS, null, values);
        debtsmodel.setDebtID(insertId);
        return debtsmodel;

    }
    public IncomeModel createIncome (IncomeModel incomedmodel) {
        Log.d("DatabaseInc", incomedmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_INCOME_NAME, incomedmodel.getIncomeNameString());
        values.put(SQLiteHelper.COLUMN_INCOME_AMOUNT, incomedmodel.getIncomeAmountString());
        values.put(SQLiteHelper.COLUMN_INCOME_DATE, incomedmodel.getIncomeDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_INCOME, null, values);
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
        values.put(SQLiteHelper.COLUMN_PEXPENDS_NAME, pexpendgmodel.getPExpendNameString());
        values.put(SQLiteHelper.COLUMN_PEXPENDS_AMOUNT, pexpendgmodel.getPExpendAmountString());

        long insertId = database.insert(SQLiteHelper.TABLE_PEXPENDS, null, values);
        pexpendgmodel.setPExpID(insertId);
        return pexpendgmodel;

    }

    public PIncomeModel createPIncome (PIncomeModel pincomegmodel) {
        Log.d("DatabasePInc", pincomegmodel.toString());
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_PINCOME_NAME, pincomegmodel.getPIncomeNameString());
        values.put(SQLiteHelper.COLUMN_PINCOME_AMOUNT, pincomegmodel.getPIncomeAmountString());

        long insertId = database.insert(SQLiteHelper.TABLE_PINCOME, null, values);
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

    public List<IncomeModel> getAllIncome() {
        List<IncomeModel> incomelist = new ArrayList<IncomeModel>();
        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_INCOME;
        Cursor cursor = database.rawQuery(query, null);
        // 3. go over each row, build book and add it to list
        IncomeModel income = null;
        if (cursor.moveToFirst()) {
            do {
                income = new IncomeModel();
                income.setIncID(Integer.parseInt(cursor.getString(0)));
                income.setIncomeNameString(cursor.getString(1));
                income.setIncomeAmountString(cursor.getString(2));
                income.setIncomeDateString(cursor.getString(3));
                // Add book to books
                incomelist.add(income);
            } while (cursor.moveToNext());

        }

        Log.d("getAllBooks()", income.toString());
        return incomelist;
    }

    public List<CreditsModel> getAllCredits() {
        List<CreditsModel> creditslist = new ArrayList<CreditsModel>();
        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_CREDITS;
        Cursor cursor = database.rawQuery(query, null);
        // 3. go over each row, build book and add it to list
        CreditsModel credit = null;
        if (cursor.moveToFirst()) {
            do {
                credit = new CreditsModel();
                credit.setCreditID(Integer.parseInt(cursor.getString(0)));
                credit.setCreditsNameString(cursor.getString(1));
                credit.setCreditsAmountString(cursor.getString(2));
                credit.setCreditsDateString(cursor.getString(3));
                // Add book to books
                creditslist.add(credit);
            } while (cursor.moveToNext());

        }

        Log.d("getAllBooks()", credit.toString());
        return creditslist;
    }


    public List<DebtsModel> getAllDebts() {
        List<DebtsModel> debtslist = new ArrayList<DebtsModel>();
        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_DEBTS;
        Cursor cursor = database.rawQuery(query, null);
        // 3. go over each row, build book and add it to list
        DebtsModel debt = null;
        if (cursor.moveToFirst()) {
            do {
                debt = new DebtsModel();
                debt.setDebtID(Integer.parseInt(cursor.getString(0)));
                debt.setDebtsNameString(cursor.getString(1));
                debt.setDebtsAmountString(cursor.getString(2));
                debt.setDebtsDateString(cursor.getString(3));
                // Add book to books
                debtslist.add(debt);
            } while (cursor.moveToNext());

        }

        Log.d("getAllDebts()", debt.toString());
        return debtslist;
    }

    public List<PIncomeModel> getAllPincome() {
        List<PIncomeModel> pincomelist = new ArrayList<PIncomeModel>();
        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_PINCOME;
        Cursor cursor = database.rawQuery(query, null);
        // 3. go over each row, build book and add it to list
        PIncomeModel pincome = null;
        if (cursor.moveToFirst()) {
            do {
                pincome = new PIncomeModel();
                pincome.setPIncID(Integer.parseInt(cursor.getString(0)));
                pincome.setPIncomeNameString(cursor.getString(1));
                pincome.setPIncomeAmountString(cursor.getString(2));

                pincomelist.add(pincome);
            } while (cursor.moveToNext());

        }

        Log.d("getAllPincome()", pincome.toString());
        return pincomelist;
    }


    public List<PExpendModel> getAllPExpends() {
        List<PExpendModel> pexpendslist = new ArrayList<PExpendModel>();

        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_PEXPENDS;

        Cursor cursor = database.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        PExpendModel pexpend = null;
        if (cursor.moveToFirst()) {
            do {
                pexpend = new PExpendModel();
                pexpend.setPExpID(Integer.parseInt(cursor.getString(0)));
                pexpend.setPExpendNameString(cursor.getString(1));
                pexpend.setPExpendAmountString(cursor.getString(2));



                pexpendslist.add(pexpend);
            } while (cursor.moveToNext());
        }

        Log.d("getAllPexpend()", pexpend.toString());


        return pexpendslist;
    }

    public boolean deleteDebts(String debtLike){
        Log.d("String", debtLike.toString());
        String where = SQLiteHelper.COLUMN_DEBTS_ID + "=" + debtLike;
        return database.delete(SQLiteHelper.TABLE_DEBTS, where, null) !=0;
    }

    public boolean deleteCredits(String creditLike){
        Log.d("String", creditLike.toString());
        String where = SQLiteHelper.COLUMN_CREDITS_ID + "=" + creditLike;
        return database.delete(SQLiteHelper.TABLE_CREDITS, where, null) !=0;
    }

    public boolean deletePincome(String pincomeLike){
        Log.d("String", pincomeLike.toString());
        String where = SQLiteHelper.COLUMN_PINCOME_ID + "=" + pincomeLike;
        return database.delete(SQLiteHelper.TABLE_PINCOME, where, null) !=0;
    }

    public boolean deletePexpends(String pexpendLike){
        Log.d("String", pexpendLike.toString());
        String where = SQLiteHelper.COLUMN_PEXPENDS_ID + "=" + pexpendLike;
        return database.delete(SQLiteHelper.TABLE_PEXPENDS, where, null) !=0;
    }

    public boolean deleteIncome(String incLike){
        Log.d("String", incLike.toString());
        String where = SQLiteHelper.COLUMN_INCOME_ID + "=" + incLike;
        return database.delete(SQLiteHelper.TABLE_INCOME, where, null) !=0;
    }

    public boolean deleteExpend(String expLike){
        Log.d("String", expLike.toString());
        String where = SQLiteHelper.COLUMN_EXPENDS_ID + "=" + expLike;
        return database.delete(SQLiteHelper.TABLE_EXPENDS, where, null) !=0;
    }

    public ExpendModel getExpendSum(){
        Cursor cursor = database.rawQuery("SELECT sum(expendsAmount) FROM expends", null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        // 4. build book object
        ExpendModel expendSum = new ExpendModel();
        expendSum.setExpendSumString(cursor.getString(0));
        //expendSum.getExpendSumString(cursor.getLong(0));
        Log.d("test", expendSum.toStringSum());
        return expendSum;
    }

    public IncomeModel getIncomeSum(){
        Cursor cursor = database.rawQuery("SELECT sum(income_amount) FROM income", null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        // 4. build book object
        IncomeModel incomeSum = new IncomeModel();
        incomeSum.setIncomeSumString(cursor.getString(0));
        Log.d("test", incomeSum.toStringIncomeSum());
        return incomeSum;
    }

    public PIncomeModel getPincomeSum(){
        Cursor cursor = database.rawQuery("SELECT sum(pincome_amount) FROM pincome", null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        // 4. build book object
        PIncomeModel pincomeSum = new PIncomeModel();
        pincomeSum.setPincomeSumString(cursor.getString(0));
        Log.d("test", pincomeSum.toStringPincomeSum());
        return pincomeSum;
    }

    public PExpendModel getPExpendSum(){
        Cursor cursor = database.rawQuery("SELECT sum(pexpends_amount) FROM pexpends_income", null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        // 4. build book object
        PExpendModel pexpendSum = new PExpendModel();
        pexpendSum.setPexpendSumString(cursor.getString(0));
        Log.d("test", pexpendSum.toStringPexpendSum());
        return pexpendSum;
    }

    public DebtsModel getDebtsSum(){
        Cursor cursor = database.rawQuery("SELECT sum(debts_amount) FROM debts", null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        // 4. build book object
        DebtsModel debtsSum = new DebtsModel();
        debtsSum.setDebtsSumString(cursor.getString(0));
        Log.d("test", debtsSum.toStringDebtsSum());
        return debtsSum;
    }

    public CreditsModel getCreditsSum(){
        Cursor cursor = database.rawQuery("SELECT sum(credits_amount) FROM credits", null);

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
        // 4. build book object
        CreditsModel creditsSum = new CreditsModel();
        creditsSum.setCreditSumString(cursor.getString(0));
        Log.d("test", creditsSum.toStringCreditSum());
        return creditsSum;
    }
}