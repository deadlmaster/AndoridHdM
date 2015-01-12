package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class PExpendModel {

    private String pExpendNameString;
    private String pExpendDateString;
    private String pExpendAmountString;
    private long pExpID;

    public long getPExpID(){
        return pExpID;
    }

    public void setPExpID(long pExpID){
        this.pExpID = pExpID;
    }

    public String getPExpendNameString(){
        return pExpendNameString;
    }

    public String getPExpendDateString(){
        return pExpendDateString;
    }

    public String getPExpendAmountString(){
        return pExpendAmountString;
    }

    public void setPExpendNameString(String pExpendNameString){
        this.pExpendNameString = pExpendNameString;
    }

    public void setPExpendAmountString(String pExpendAmountString){
        this.pExpendAmountString = pExpendAmountString;
    }

    public void setPExpendDateString(String pExpendDateString){
        this.pExpendDateString = pExpendDateString;
    }

    public String toString() {
        return pExpendNameString + " " + pExpendAmountString +" "+ pExpendDateString;
    }
}
