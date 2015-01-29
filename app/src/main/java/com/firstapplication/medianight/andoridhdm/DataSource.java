package com.firstapplication.medianight.andoridhdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

// Die Klasse beinhaltet alle Datenbank-Operationen.

public class DataSource {

    // SQLiteOpenHelper und SQLiteDatabase.
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


    // Erzeugt ein Ausgaben-Objekt(Expend)und trägt die Informationen in die entsprechenden Tabellen und Spalten in der SQLite-DB ein.
    public ExpendModel createExpend (ExpendModel expendmodel) {

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_EXPENDS_NAME, expendmodel.getExpendNameString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_AMOUNT, expendmodel.getExpendAmountString());
        values.put(SQLiteHelper.COLUMN_EXPENDS_DATE, expendmodel.getExpendDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_EXPENDS, null, values);
        expendmodel.setExpID(insertId);
        return expendmodel;

    }

    //Erzeugt ein Gutschriften-Objekt(Credit)und trägt die Informationen in die entsprechenden Tabellen und Spalten in der SQLite-DB ein.
    public CreditsModel createCredit (CreditsModel creditsmodel) {

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_CREDITS_NAME, creditsmodel.getCreditsNameString());
        values.put(SQLiteHelper.COLUMN_CREDITS_AMOUNT, creditsmodel.getCreditsAmountString());
        values.put(SQLiteHelper.COLUMN_CREDITS_DATE, creditsmodel.getCreditsDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_CREDITS, null, values);
        creditsmodel.setCreditID(insertId);
        return creditsmodel;

    }

    //Erzeugt ein Schulden-Objekt (Debt)und trägt die Informationen in die entsprechenden Tabellen und Spalten in der SQLite-DB ein.
    public DebtsModel createDebt (DebtsModel debtsmodel) {

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_DEBTS_NAME, debtsmodel.getDebtsNameString());
        values.put(SQLiteHelper.COLUMN_DEBTS_AMOUNT, debtsmodel.getDebtsAmountString());
        values.put(SQLiteHelper.COLUMN_DEBTS_DATE, debtsmodel.getDebtsDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_DEBTS, null, values);
        debtsmodel.setDebtID(insertId);
        return debtsmodel;

    }

    //Erzeugt ein Einnahmen-Objekt (Income)und trägt die Informationen in die entsprechenden Tabellen und Spalten in der SQLite-DB ein.
    public IncomeModel createIncome (IncomeModel incomedmodel) {

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_INCOME_NAME, incomedmodel.getIncomeNameString());
        values.put(SQLiteHelper.COLUMN_INCOME_AMOUNT, incomedmodel.getIncomeAmountString());
        values.put(SQLiteHelper.COLUMN_INCOME_DATE, incomedmodel.getIncomeDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_INCOME, null, values);
        incomedmodel.setIncID(insertId);
        return incomedmodel;

    }

    //Erzeugt ein Sparziel-Objekt (Saving aka. Dreamgoal) und trägt die Informationen in die entsprechenden Tabellen und Spalten in der SQLite-DB ein.
    public SavingModel createSaving (SavingModel savingmodel) {

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_DREAMGOAL_NAME, savingmodel.getSaveNameString());
        values.put(SQLiteHelper.COLUMN_DREAMGOAL_AMOUNT, savingmodel.getSaveAmountString());
        values.put(SQLiteHelper.COLUMN_DREAMGOAL_DATE, savingmodel.getSaveDateString());

        long insertId = database.insert(SQLiteHelper.TABLE_DREAMGOAL, null, values);
        savingmodel.setSaveID(insertId);
        return savingmodel;

    }

    //Erzeugt ein periodische Ausgaben-Objekt (PExpend) und trägt die Informationen in die entsprechenden Tabellen und Spalten in der SQLite-DB ein.
    public PExpendModel createPExpend (PExpendModel pexpendgmodel) {

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_PEXPENDS_NAME, pexpendgmodel.getPExpendNameString());
        values.put(SQLiteHelper.COLUMN_PEXPENDS_AMOUNT, pexpendgmodel.getPExpendAmountString());

        long insertId = database.insert(SQLiteHelper.TABLE_PEXPENDS, null, values);
        pexpendgmodel.setPExpID(insertId);
        return pexpendgmodel;

    }

    //Erzeugt ein periodische Einnahmen-Objekt (PIncome) und trägt die Informationen in die entsprechenden Tabellen und Spalten in der SQLite-DB ein.
    public PIncomeModel createPIncome (PIncomeModel pincomegmodel) {

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_PINCOME_NAME, pincomegmodel.getPIncomeNameString());
        values.put(SQLiteHelper.COLUMN_PINCOME_AMOUNT, pincomegmodel.getPIncomeAmountString());

        long insertId = database.insert(SQLiteHelper.TABLE_PINCOME, null, values);
        pincomegmodel.setPIncID(insertId);
        return pincomegmodel;

    }

    // Frägt die Datenbank mit einer SQL-Query ab. Packt die erhaltenen Informationen in eine Liste. Eine Liste mit allen Ausgaben wird erzeugt.
    public List<ExpendModel> getAllExpends() {
        List<ExpendModel> expendslist = new ArrayList<ExpendModel>();

        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_EXPENDS;

        Cursor cursor = database.rawQuery(query, null);
        ExpendModel expend = null;
        if (cursor.moveToFirst()) {
            do {
                expend = new ExpendModel();
                expend.setExpID(Integer.parseInt(cursor.getString(0)));
                expend.setExpendNameString(cursor.getString(1));
                expend.setExpendAmountString(cursor.getString(2));
                expend.setExpendDateString(cursor.getString(3));
                expendslist.add(expend);
            } while (cursor.moveToNext());
        }
        return expendslist;
    }

    // Frägt die Datenbank mit einer SQL-Query ab. Packt die erhaltenen Informationen in eine Liste. Eine Liste mit allen Einnahmen wird erzeugt.
    public List<IncomeModel> getAllIncome() {
        List<IncomeModel> incomelist = new ArrayList<IncomeModel>();
        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_INCOME;
        Cursor cursor = database.rawQuery(query, null);

        IncomeModel income = null;
        if (cursor.moveToFirst()) {
            do {
                income = new IncomeModel();
                income.setIncID(Integer.parseInt(cursor.getString(0)));
                income.setIncomeNameString(cursor.getString(1));
                income.setIncomeAmountString(cursor.getString(2));
                income.setIncomeDateString(cursor.getString(3));

                incomelist.add(income);
            } while (cursor.moveToNext());
        }

        return incomelist;
    }

    // Frägt die Datenbank mit einer SQL-Query ab. Packt die erhaltenen Informationen in eine Liste. Eine Liste mit allen Gutschriften wird erzeugt.
    public List<CreditsModel> getAllCredits() {
        List<CreditsModel> creditslist = new ArrayList<CreditsModel>();
        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_CREDITS;
        Cursor cursor = database.rawQuery(query, null);

        CreditsModel credit = null;
        if (cursor.moveToFirst()) {
            do {
                credit = new CreditsModel();
                credit.setCreditID(Integer.parseInt(cursor.getString(0)));
                credit.setCreditsNameString(cursor.getString(1));
                credit.setCreditsAmountString(cursor.getString(2));
                credit.setCreditsDateString(cursor.getString(3));

                creditslist.add(credit);
            } while (cursor.moveToNext());

        }
        return creditslist;
    }

    // Frägt die Datenbank mit einer SQL-Query ab. Packt die erhaltenen Informationen in eine Liste. Eine Liste mit allen Schulden wird erzeugt.
    public List<DebtsModel> getAllDebts() {
        List<DebtsModel> debtslist = new ArrayList<DebtsModel>();
        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_DEBTS;
        Cursor cursor = database.rawQuery(query, null);

        DebtsModel debt = null;
        if (cursor.moveToFirst()) {
            do {
                debt = new DebtsModel();
                debt.setDebtID(Integer.parseInt(cursor.getString(0)));
                debt.setDebtsNameString(cursor.getString(1));
                debt.setDebtsAmountString(cursor.getString(2));
                debt.setDebtsDateString(cursor.getString(3));

                debtslist.add(debt);
            } while (cursor.moveToNext());

        }

        return debtslist;
    }

    // Frägt die Datenbank mit einer SQL-Query ab. Packt die erhaltenen Informationen in eine Liste. Eine Liste mit allen periodischen Ausgaben wird erzeugt.
    public List<PIncomeModel> getAllPincome() {
        List<PIncomeModel> pincomelist = new ArrayList<PIncomeModel>();
        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_PINCOME;
        Cursor cursor = database.rawQuery(query, null);

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

        return pincomelist;
    }

    // Frägt die Datenbank mit einer SQL-Query ab. Packt die erhaltenen Informationen in eine Liste. Eine Liste mit allen Sparzielen wird erzeugt.
    public List<SavingModel> getAllSavings() {
        List<SavingModel> savingslist = new ArrayList<SavingModel>();

        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_DREAMGOAL;

        Cursor cursor = database.rawQuery(query, null);

        SavingModel savings = null;
        if (cursor.moveToFirst()) {
            do {
                savings = new SavingModel();
                savings.setSaveID(Integer.parseInt(cursor.getString(0)));
                savings.setSaveNameString(cursor.getString(1));
                savings.setSaveAmountString(cursor.getString(2));
                savings.setSaveDateString(cursor.getString(3));


                savingslist.add(savings);
            } while (cursor.moveToNext());
        }


        return savingslist;
    }

    // Frägt die Datenbank mit einer SQL-Query ab. Packt die erhaltenen Informationen in eine Liste. Eine Liste mit allen periodischen Ausgaben wird erzeugt.
    public List<PExpendModel> getAllPExpends() {
        List<PExpendModel> pexpendslist = new ArrayList<PExpendModel>();

        String query = "SELECT  * FROM " + SQLiteHelper.TABLE_PEXPENDS;

        Cursor cursor = database.rawQuery(query, null);

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

        return pexpendslist;
    }


    // Für Schulden. Erhält aus der Liste durch Long-Click die ID. Diese ID wird im SQL-Statement aufgegriffen. Der Eintrag mit der entsprechenden ID wird aus der Datenbank gelöscht.
    public boolean deleteDebts(String debtLike){
        Log.d("String", debtLike.toString());
        String where = SQLiteHelper.COLUMN_DEBTS_ID + "=" + debtLike;
        return database.delete(SQLiteHelper.TABLE_DEBTS, where, null) !=0;
    }

    // Für Sparziele. Erhält aus der Liste durch Long-Click die ID. Diese ID wird im SQL-Statement aufgegriffen. Der Eintrag mit der entsprechenden ID wird aus der Datenbank gelöscht.
    public boolean deleteSavings(String savLike){
        Log.d("String", savLike.toString());
        String where = SQLiteHelper.COLUMN_DREAMGOAL_ID + "=" + savLike;
        return database.delete(SQLiteHelper.TABLE_DREAMGOAL, where, null) !=0;
    }

    // Für Gutschriften. Erhält aus der Liste durch Long-Click die ID. Diese ID wird im SQL-Statement aufgegriffen. Der Eintrag mit der entsprechenden ID wird aus der Datenbank gelöscht.
    public boolean deleteCredits(String creditLike){
        Log.d("String", creditLike.toString());
        String where = SQLiteHelper.COLUMN_CREDITS_ID + "=" + creditLike;
        return database.delete(SQLiteHelper.TABLE_CREDITS, where, null) !=0;
    }

    // Für periodische Einnahmen. Erhält aus der Liste durch Long-Click die ID. Diese ID wird im SQL-Statement aufgegriffen. Der Eintrag mit der entsprechenden ID wird aus der Datenbank gelöscht.
    public boolean deletePincome(String pincomeLike){
        Log.d("String", pincomeLike.toString());
        String where = SQLiteHelper.COLUMN_PINCOME_ID + "=" + pincomeLike;
        return database.delete(SQLiteHelper.TABLE_PINCOME, where, null) !=0;
    }

    // Für periodische Ausgaben. Erhält aus der Liste durch Long-Click die ID. Diese ID wird im SQL-Statement aufgegriffen. Der Eintrag mit der entsprechenden ID wird aus der Datenbank gelöscht.
    public boolean deletePexpends(String pexpendLike){
        Log.d("String", pexpendLike.toString());
        String where = SQLiteHelper.COLUMN_PEXPENDS_ID + "=" + pexpendLike;
        return database.delete(SQLiteHelper.TABLE_PEXPENDS, where, null) !=0;
    }

    // Für Einnahmen. Erhält aus der Liste durch Long-Click die ID. Diese ID wird im SQL-Statement aufgegriffen. Der Eintrag mit der entsprechenden ID wird aus der Datenbank gelöscht.
    public boolean deleteIncome(String incLike){
        Log.d("String", incLike.toString());
        String where = SQLiteHelper.COLUMN_INCOME_ID + "=" + incLike;
        return database.delete(SQLiteHelper.TABLE_INCOME, where, null) !=0;
    }

    // Für Ausgaben. Erhält aus der Liste durch Long-Click die ID. Diese ID wird im SQL-Statement aufgegriffen. Der Eintrag mit der entsprechenden ID wird aus der Datenbank gelöscht.
    public boolean deleteExpend(String expLike){
        Log.d("String", expLike.toString());
        String where = SQLiteHelper.COLUMN_EXPENDS_ID + "=" + expLike;
        return database.delete(SQLiteHelper.TABLE_EXPENDS, where, null) !=0;
    }

    // Errechnet die Summe aller Ausgaben durch Einsatz von SQL-sum()-Operator. Erhält als Ergebnis die Summe der entsprechenden Spalte aus der Datenbank.
    public ExpendModel getExpendSum(){
        Cursor cursor = database.rawQuery("SELECT sum(expendsAmount) FROM expends", null);


        if (cursor != null)
            cursor.moveToFirst();

        ExpendModel expendSum = new ExpendModel();
        expendSum.setExpendSumString(cursor.getString(0));

        Log.d("test", expendSum.toStringSum());
        return expendSum;
    }

    // Errechnet die Summe aller Einnahmen durch Einsatz von SQL-sum()-Operator. Erhält als Ergebnis die Summe der entsprechenden Spalte aus der Datenbank.
    public IncomeModel getIncomeSum(){
        Cursor cursor = database.rawQuery("SELECT sum(income_amount) FROM income", null);


        if (cursor != null)
            cursor.moveToFirst();

        IncomeModel incomeSum = new IncomeModel();
        incomeSum.setIncomeSumString(cursor.getString(0));
        Log.d("test", incomeSum.toStringIncomeSum());
        return incomeSum;
    }

    // Errechnet die Summe aller periodischen Einnahmen durch Einsatz von SQL-sum()-Operator. Erhält als Ergebnis die Summe der entsprechenden Spalte aus der Datenbank.
    public PIncomeModel getPincomeSum(){
        Cursor cursor = database.rawQuery("SELECT sum(pincome_amount) FROM pincome", null);


        if (cursor != null)
            cursor.moveToFirst();

        PIncomeModel pincomeSum = new PIncomeModel();
        pincomeSum.setPincomeSumString(cursor.getString(0));
        Log.d("test", pincomeSum.toStringPincomeSum());
        return pincomeSum;
    }

    // Errechnet die Summe aller periodischen Ausgaben durch Einsatz von SQL-sum()-Operator. Erhält als Ergebnis die Summe der entsprechenden Spalte aus der Datenbank.
    public PExpendModel getPExpendSum(){
        Cursor cursor = database.rawQuery("SELECT sum(pexpends_amount) FROM pexpends_income", null);
        if (cursor != null)
            cursor.moveToFirst();

        PExpendModel pexpendSum = new PExpendModel();
        pexpendSum.setPexpendSumString(cursor.getString(0));
        Log.d("test", pexpendSum.toStringPexpendSum());
        return pexpendSum;
    }

    // Errechnet die Summe aller Schulden durch Einsatz von SQL-sum()-Operator. Erhält als Ergebnis die Summe der entsprechenden Spalte aus der Datenbank.
    public DebtsModel getDebtsSum(){
        Cursor cursor = database.rawQuery("SELECT sum(debts_amount) FROM debts", null);


        if (cursor != null)
            cursor.moveToFirst();

        DebtsModel debtsSum = new DebtsModel();
        debtsSum.setDebtsSumString(cursor.getString(0));
        Log.d("test", debtsSum.toStringDebtsSum());
        return debtsSum;
    }

    // Errechnet die Summe aller Gutschriften durch Einsatz von SQL-sum()-Operator. Erhält als Ergebnis die Summe der entsprechenden Spalte aus der Datenbank.
    public CreditsModel getCreditsSum(){
        Cursor cursor = database.rawQuery("SELECT sum(credits_amount) FROM credits", null);


        if (cursor != null)
            cursor.moveToFirst();

        CreditsModel creditsSum = new CreditsModel();
        creditsSum.setCreditSumString(cursor.getString(0));
        Log.d("test", creditsSum.toStringCreditSum());
        return creditsSum;
    }


    // Errechnet die Summe aller Sparziele durch Einsatz von SQL-sum()-Operator. Erhält als Ergebnis die Summe der entsprechenden Spalte aus der Datenbank.
    public SavingModel getSavingsSum(){
        Cursor cursor = database.rawQuery("SELECT sum(dreamgoal_amount) FROM dreamgoal", null);

        if (cursor != null)
            cursor.moveToFirst();

        SavingModel savingsSum = new SavingModel();
        savingsSum.setSaveSumString(cursor.getString(0));
        Log.d("test", savingsSum.toStringSaveSum());
        return savingsSum;
    }


    // Erzeugt die Variable datewhere, die benötigt wird für zeitabhängige Methoden.
    public Calendar myCalender = Calendar.getInstance();
    String myFormat = "dd.MM.yy";
    SimpleDateFormat dateForm = new SimpleDateFormat(myFormat, Locale.GERMANY);
    String currentDate = dateForm.format(myCalender.getTime());
    String datewhere = currentDate.substring(3,8);


    // Filtert die Tabelle Einnahmen nach dem Monat des aktuellen Datums (s. datewhere)durch einen SQL-Statement. Erhält alle Einträge vom gleichen Monat. Wird für Saldoberechnung verwendet.
    public IncomeModel getIncomeSumDate(){
        String query = "SELECT SUM(" + SQLiteHelper.COLUMN_INCOME_AMOUNT +   ") FROM " + SQLiteHelper.TABLE_INCOME + " WHERE " + SQLiteHelper.COLUMN_INCOME_DATE + " LIKE '%" + datewhere + "'";
        Cursor cursor = database.rawQuery(query, null);


        if (cursor != null)
            cursor.moveToFirst();

        IncomeModel incomeWhere = new IncomeModel();
        incomeWhere.setIncomeWhere(cursor.getString(0));
        Log.d("test", incomeWhere.toStringIncomeWhere());
        return incomeWhere;
    }

    // Filtert die Tabelle Ausgaben nach dem Monat des aktuellen Datums (s. datewhere)durch einen SQL-Statement. Erhält alle Einträge vom gleichen Monat. Wird für Saldoberechnung verwendet.
    public ExpendModel getExpendSumDate(){
        String query = "SELECT SUM(" + SQLiteHelper.COLUMN_EXPENDS_AMOUNT +   ") FROM " + SQLiteHelper.TABLE_EXPENDS + " WHERE " + SQLiteHelper.COLUMN_EXPENDS_DATE + " LIKE '%" + datewhere + "'";
        Cursor cursor = database.rawQuery(query, null);


        if (cursor != null)
            cursor.moveToFirst();

        ExpendModel expendWhere = new ExpendModel();
        expendWhere.setExpendWhere(cursor.getString(0));
        Log.d("test", expendWhere.toStringExpendWhere());
        return expendWhere;
    }

    // Filtert die Tabelle Sparziele nach dem Eintrag der am nächsten zum aktuellen Datums ist(s. datewhere)durch einen SQL-Statement.
    public SavingModel getNextSaving(){


        String query = "SELECT " + SQLiteHelper.COLUMN_DREAMGOAL_AMOUNT + ", " + SQLiteHelper.COLUMN_DREAMGOAL_DATE + ", "+ SQLiteHelper.COLUMN_DREAMGOAL_NAME + " FROM " + SQLiteHelper.TABLE_DREAMGOAL + " ORDER BY " + SQLiteHelper.COLUMN_DREAMGOAL_DATE + " ASC";
        Cursor cursor = database.rawQuery(query, null);

        if (cursor != null)
            cursor.moveToFirst();

        SavingModel savingWhere = new SavingModel();
        savingWhere.setSavingWhere(cursor.getString(0));
        savingWhere.setSavingDateWhere(cursor.getString(1));
        savingWhere.setSavingNameWhere(cursor.getString(2));
     Log.d("sehr wichtig!", savingWhere.toStringSavingWhere());
        return savingWhere;
    }

}