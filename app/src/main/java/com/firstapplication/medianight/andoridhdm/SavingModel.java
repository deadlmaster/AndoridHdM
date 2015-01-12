package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class SavingModel {


    private String savingNameString;
    private String savingDateString;
    private String savingAmountString;
    private long saveID;

    public long getSaveID(){
        return saveID;
    }

    public void setSaveID(long incID){
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

    public void setSaveNameString(String savingNameString){
        this.savingNameString = savingNameString;
    }

    public void setSaveAmountString(String savingAmountString){
        this.savingAmountString = savingAmountString;
    }

    public void setSaveDateString(String savingDateString){
        this.savingDateString = savingDateString;
    }

    public String toString() {
        return savingNameString + " " + savingAmountString +" "+ savingDateString;
    }
}
