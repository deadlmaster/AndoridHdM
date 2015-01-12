package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class PIncomeModel {

    private String pIncomeNameString;
    private String pIncomeDateString;
    private String pIncomeAmountString;
    private long pIncID;

    public long getPIncID(){
        return pIncID;
    }

    public void setPIncID(long pincID){
        this.pIncID = pincID;
    }

    public String getPIncomeNameString(){
        return pIncomeNameString;
    }

    public String getPIncomeDateString(){
        return pIncomeDateString;
    }

    public String getPIncomeAmountString(){
        return pIncomeAmountString;
    }

    public void setPIncomeNameString(String pincomeNameString){
        this.pIncomeNameString = pincomeNameString;
    }

    public void setPIncomeAmountString(String pincomeAmountString){
        this.pIncomeAmountString = pincomeAmountString;
    }

    public void setPIncomeDateString(String pincomeDateString){
        this.pIncomeDateString = pincomeDateString;
    }

    public String toString() {
        return pIncomeNameString + " " + pIncomeAmountString +" "+ pIncomeDateString;
    }
}
