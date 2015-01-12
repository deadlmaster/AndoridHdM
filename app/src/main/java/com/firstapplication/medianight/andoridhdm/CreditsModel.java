package com.firstapplication.medianight.andoridhdm;

/**
 * Created by Peter Tan on 12.01.2015.
 */
public class CreditsModel {


    private String creditsNameString;
    private String creditsDateString;
    private String creditsAmountString;
    private long creditID;

    public long creditExpID(){
        return creditID;
    }

    public void setCreditID(long ExpID){
        this.creditID = creditID;
    }

    public String getCreditsNameString(){
        return creditsNameString;
    }

    public String getCreditsDateString(){
        return creditsDateString;
    }

    public String getCreditsAmountString(){
        return creditsAmountString;
    }

    public void setCreditsNameString(String creditsNameString){
        this.creditsNameString = creditsNameString;
    }

    public void setCreditsAmountString(String creditsAmountString){
        this.creditsAmountString = creditsAmountString;
    }

    public void setCreditsDateString(String creditsDateString){
        this.creditsDateString = creditsDateString;
    }

    public String toString() {
        return creditsNameString + " " + creditsAmountString +" "+ creditsDateString;
    }
}
