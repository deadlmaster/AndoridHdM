package com.firstapplication.medianight.andoridhdm;
import com.firstapplication.medianight.andoridhdm.MainActivity;

/**
 * Created by Cpt Cranberry on 04/01/2015.
 */
public class EntryDB {

    private long id;
    private String ExpendNameString;
    private String ExpendDateString;
    private String ExpendAmountString;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpendNameString() {
        return ExpendNameString;
    }

    public void setExpendNameString(String expendNameString) {
        this.ExpendNameString = expendNameString;

    }

    public String getExpendAmountString() {
        return ExpendAmountString;
    }

    public void setExpendAmountString(String ExpendAmountString) {
        this.ExpendAmountString = ExpendAmountString;
    }
    public String getExpendDateString() {
        return ExpendDateString;
    }

    public void setExpendDateString(String ExpendDateString) {
        this.ExpendDateString = ExpendDateString;
    }

    public String toString (){
        return String.format(" - %s € für %s am %s", ExpendAmountString, ExpendNameString, ExpendDateString);
    }




}
