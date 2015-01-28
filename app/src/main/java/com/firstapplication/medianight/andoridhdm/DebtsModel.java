package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class DebtsModel {

    private String debtsSumString;
    private String debtsNameString;
    private String debtsDateString;
    private String debtsAmountString;
    private long debtID;

    public long debtID(){
        return debtID;
    }

    public void setDebtID(long debtID){
        this.debtID = debtID;
    }

    public String getDebtsNameString(){
        return debtsNameString;
    }

    public String getDebtsDateString(){
        return debtsDateString;
    }

    public String getDebtsAmountString(){
        return debtsAmountString;
    }

    public void setDebtsNameString(String debtsNameString){
        this.debtsNameString = debtsNameString;
    }

    public void setDebtsAmountString(String debtsAmountString){
        this.debtsAmountString = debtsAmountString;
    }

    public void setDebtsDateString(String debtsDateString){
        this.debtsDateString = debtsDateString;
    }

    public String getDebtsSumString (String debtsSumString){
        return debtsSumString;
    }

    public void setDebtsSumString (String debtsSumString){
        this.debtsSumString = debtsSumString;
    }
    public String toStringDebtsSum(){
        return debtsSumString;
    }

    @Override
    public String toString() {
        return "Nr." + debtID + "    "+ debtsNameString + "   |   " + debtsAmountString +"€   |   "+ debtsDateString;
    }
}
