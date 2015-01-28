package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class PExpendModel {

    private String pExpendSumString;
    private String pExpendNameString;
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


    public String getPExpendAmountString(){
        return pExpendAmountString;
    }

    public void setPExpendNameString(String pExpendNameString){
        this.pExpendNameString = pExpendNameString;
    }

    public void setPExpendAmountString(String pExpendAmountString){
        this.pExpendAmountString = pExpendAmountString;
    }


    public String getPexpendSumString (String pExpendSumString){
        return pExpendSumString;
    }

    public void setPexpendSumString (String pExpendSumString){
        this.pExpendSumString = pExpendSumString;
    }
    public String toStringPexpendSum(){
        return pExpendSumString;
    }

    @Override
    public String toString() {

        return "Nr." + pExpID + "    "+ pExpendNameString + "   |   " + pExpendAmountString +"€";
    }
}
