package com.firstapplication.medianight.andoridhdm;

// Objektklasse für Sparziele. Beinhaltet Getter, Setter und toString-Variationen.
public class SavingModel {

    private String savingNameWhere;
    private String savingDateWhere;
    private String savingWhere;
    private String saveSumString;
    private String savingNameString;
    private String savingDateString;
    private String savingAmountString;
    private long saveID;

    public long getSaveID(){
        return saveID;
    }

    public void setSaveID(long saveID){
        this.saveID = saveID;
    }

    public String getSaveNameString(){
        return savingNameString;
    }

    public String getSaveDateString(){
        return savingDateString;
    }

    public String getSaveAmountString(){
        return savingAmountString;
    }

    public String getSavingDateWhere() {return savingDateWhere;}

    public void setSavingDateWhere(String savingDateWhere){
        this.savingDateWhere = savingDateWhere;
    }


    public void setSaveNameString(String savingNameString){
        this.savingNameString = savingNameString;
    }

    public void setSaveAmountString(String savingAmountString){
        this.savingAmountString = savingAmountString;
    }

    public void setSaveDateString(String savingDateString){
        this.savingDateString = savingDateString;
    }

    public String toStringSavingNumber(){
        return savingWhere;
    }


    public String toStringSavingWhere(){

       return savingDateWhere + ": " + savingNameWhere + "  " + savingWhere + "€";
    }

    public String getSavingWhere (String savingWhere){
        return savingWhere;
    }

    public void setSavingWhere(String savingWhere){
        this.savingWhere = savingWhere;
    }


    public String getSaveSumString (String saveSumString){
        return saveSumString;
    }

    public void setSaveSumString (String saveSumString){
        this.saveSumString = saveSumString;
    }

    public String getSavingNameWhere (String savingNameWhere){
        return savingNameWhere;
    }

    public void setSavingNameWhere (String savingNameWhere){
        this.savingNameWhere = savingNameWhere;
    }

    public String toStringSaveSum(){
        return saveSumString;
    }

    @Override
    public String toString() {
        return "Nr." + saveID + "    "+ savingNameString + "   |   " + savingAmountString +"€   |   "+ savingDateString;
    }
}
