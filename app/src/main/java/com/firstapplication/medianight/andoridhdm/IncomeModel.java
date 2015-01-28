package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class IncomeModel{

    private String incomeNameString;
    private String incomeDateString;
    private String incomeAmountString;
    private long incID;
    private String incomeSumString;

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

    public String getIncomeAmountString(){
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


    public String getIncomeSumString (String incomeSumString){
        return incomeSumString;
    }

    public void setIncomeSumString (String incomeSumString){
        this.incomeSumString = incomeSumString;
    }
    public String toStringIncomeSum(){
        return incomeSumString;
    }

    @Override
    public String toString() {
        return "Nr." + incID + "    "+ incomeNameString + "   |   " + incomeAmountString +"€   |   "+ incomeDateString;
    }

}
