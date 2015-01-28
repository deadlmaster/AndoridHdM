package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class PIncomeModel {

    private String pIncomeSumString;
    private String pIncomeNameString;
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

    public String getPIncomeAmountString(){
        return pIncomeAmountString;
    }

    public void setPIncomeNameString(String pincomeNameString){
        this.pIncomeNameString = pincomeNameString;
    }

    public void setPIncomeAmountString(String pincomeAmountString){
        this.pIncomeAmountString = pincomeAmountString;
    }

    public String getPincomeSumString (String pIncomeSumString){
        return pIncomeSumString;
    }

    public void setPincomeSumString (String pIncomeSumString){
        this.pIncomeSumString = pIncomeSumString;
    }
    public String toStringPincomeSum(){
        return pIncomeSumString;
    }

    @Override
    public String toString() {

        return "Nr." + pIncID + "    "+ pIncomeNameString + "   |   " + pIncomeAmountString +"€";
    }
}
