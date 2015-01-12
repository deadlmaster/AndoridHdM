package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class IncomeModel{

    private String incomeNameString;
    private String incomeDateString;
    private String incomeAmountString;
    private long incID;

    public long getIncID(){
        return incID;
    }

    public void setIncID(long incID){
        this.incID = incID;
    }

    public String getIncomeNameString(){
        return incomeNameString;
    }

    public String getIncomeDateString(){
        return incomeDateString;
    }

    public String getExpendAmountString(){
        return incomeAmountString;
    }

    public void setIncomeNameString(String incomeNameString){
        this.incomeNameString = incomeNameString;
    }

    public void setIncomeAmountString(String incomeAmountString){
        this.incomeAmountString = incomeAmountString;
    }

    public void setIncomeDateString(String incomeDateString){
        this.incomeDateString = incomeDateString;
    }

    public String toString() {
        return incomeNameString + " " + incomeAmountString +" "+ incomeDateString;
    }

}
