package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Cpt Cranberry on 04/01/2015.
 */
import java.util.ArrayList;
import java.util.List;
import com.firstapplication.medianight.andoridhdm.SQLiteHelper;
import com.firstapplication.medianight.andoridhdm.EntryDB;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.DropBoxManager;


public class ExpendDataSource {


    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = { "ID", "ExpendName",
            "ExpendAmount", "ExpendDate"};



    public ExpendDataSource(Context context) {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public EntryDB createEntry(String ExpendNameString, String ExpendAmountString, String ExpendDateString) {
        ContentValues values = new ContentValues();
        values.put("ExpendName", ExpendNameString);
        values.put("ExpendAmount", ExpendAmountString);
        values.put("ExpendDate", ExpendDateString);

        long insertId = database.insert("EXPENDS", null,
                values);


        Cursor cursor = database.query("EXPEND",allColumns, "ID = " + insertId, null, null, null, null);
        cursor.moveToFirst();

        return cursorToEntry(cursor);
    }

    protected List<EntryDB> getAllEntries() {
        List<EntryDB> EntriesList = new ArrayList<EntryDB>();
        EntriesList = new ArrayList<EntryDB>();

        Cursor cursor = database.query("EXPEND", allColumns, null, null, null, null, null);
        cursor.moveToFirst();

        if(cursor.getCount() == 0) return EntriesList;


        while (cursor.isAfterLast() == false) {
            EntryDB entry = cursorToEntry(cursor);
            EntriesList.add(entry);
            cursor.moveToNext();
        }

        cursor.close();

        return EntriesList;
    }


    private EntryDB cursorToEntry(Cursor cursor) {
        EntryDB entry = new EntryDB();
        entry.setId(cursor.getLong(0));
        entry.setExpendNameString(cursor.getString(1));
        entry.setExpendAmountString(cursor.getString(2));
        entry.setExpendDateString(cursor.getString(3));

        return entry;
    }

}