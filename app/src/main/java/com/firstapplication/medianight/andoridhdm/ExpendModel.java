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

    public void setExpID(){
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

   /** public void setExpendNameString(ExpendNameString){
        this.ExpendNameString=ExpendNameString;
    }

    public void setExpendAmountString(ExpendAmountString){
        this.ExpendAmountString = ExpendAmountString;
    }

    public void setExpendDateString(ExpendDateString){
        this.ExpendDateString = ExpendDateString;
    }*/
}
