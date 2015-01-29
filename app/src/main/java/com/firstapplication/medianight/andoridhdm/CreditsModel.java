package com.firstapplication.medianight.andoridhdm;

// Objektklasse für Gutschriften. Beinhaltet Getter, Setter und toString-Variationen.

public class CreditsModel {

    private String creditSumString;
    private String creditsNameString;
    private String creditsDateString;
    private String creditsAmountString;
    private long creditID;

    public long creditID(){
        return creditID;
    }

    public void setCreditID(long creditID){
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

    public String getCreditSumString (String creditSumString){
        return creditSumString;
    }

    public void setCreditSumString (String creditSumString){
        this.creditSumString = creditSumString;
    }
    public String toStringCreditSum(){
        return creditSumString;
    }

    @Override
    public String toString() {
        return "Nr." + creditID + "    "+ creditsNameString + "   |   " + creditsAmountString +"€   |   "+ creditsDateString;
    }
}
