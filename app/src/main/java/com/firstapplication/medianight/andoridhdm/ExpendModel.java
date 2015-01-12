package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Cpt Cranberry on 11/01/2015.
 */
public class ExpendModel {

    private String ExpendNameString;
    private String ExpendDateString;
    private String ExpendAmountString;
    private long expID;

    public long getExpID(){
        return expID;
    }

    public void setExpID(long ExpID){
        this.expID = expID;
    }

    public String getExpendNameString(){
        return ExpendNameString;
    }

    public String getExpendDateString(){
        return ExpendDateString;
    }

    public String getExpendAmountString(){
        return ExpendAmountString;
    }

    public void setExpendNameString(String ExpendNameString){
        this.ExpendNameString = ExpendNameString;
    }

    public void setExpendAmountString(String ExpendAmountString){
        this.ExpendAmountString = ExpendAmountString;
    }

    public void setExpendDateString(String ExpendDateString){
        this.ExpendDateString = ExpendDateString;
    }

    public String toString() {
        return ExpendNameString + " " + ExpendAmountString +" "+ ExpendDateString;
    }
}
