package com.firstapplication.medianight.andoridhdm;

// Objektklasse für Ausgaben. Beinhaltet Getter, Setter und toString-Variationen.
public class ExpendModel {

    private String expendWhere;
    private String expendSumString;
    private String expendNameString;
    private String expendDateString;
    private String expendAmountString;
    private long expID;

    public long getExpID(){
        return expID;
    }

    public void setExpID(long expID){
        this.expID = expID;
    }

    public String getExpendNameString(){
        return expendNameString;
    }

    public String getExpendDateString(){
        return expendDateString;
    }

    public String getExpendAmountString(){
        return expendAmountString;
    }

    public void setExpendNameString(String ExpendNameString){
        this.expendNameString = ExpendNameString;
    }

    public void setExpendAmountString(String ExpendAmountString){
        this.expendAmountString = ExpendAmountString;
    }

    public void setExpendDateString(String ExpendDateString){
        this.expendDateString = ExpendDateString;
    }

    public String getExpendSumString (String ExpendSumString){
        return expendSumString;
    }

    public void setExpendSumString (String expendSumString){
        this.expendSumString = expendSumString;
    }
    public String toStringSum(){
        return expendSumString;
    }

    public String toStringExpendWhere(){
        return expendWhere;
    }

    public String getExpendWhere (String expendWhere){
        return expendWhere;
    }

    public void setExpendWhere(String expendWhere){
        this.expendWhere = expendWhere;
    }

    @Override
    public String toString() {
        return "Nr." + expID + "    "+ expendNameString + "   |   " + expendAmountString +"€   |   "+ expendDateString;
    }
}
