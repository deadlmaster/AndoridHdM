package com.firstapplication.medianight.andoridhdm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


//Klasse für die Activity der Report-Seite.

public class ReportActivity extends Activity {


    private DataSource datasource;


    //Gibt an was beim Öffnen der Seite durchgeführt werden soll. TextViews und Methoden.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

          /*
        Beim Aufruf wird die Report Layout Datei als View genommen.
        Weiterhin wird das Datumstextfeld initialisiert und mit dem jetztigen Datum gefüllt
        Die Datenbankverbindung wird zudem noch aufgebaut.
        Um den Textfont zu ändern, werden alle Texte erst initialisiert und dann mit Typeface das Font angepasst
        Beun erscheinen, sollen in den Textfeldern auch schon Daten angezeigt werden. Daher werden die Methoden
        dafür hier ebenso initialisiert.
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_layout);
        TextView ScreenDate = (TextView)findViewById(R.id.text_date_report);
        ScreenDate.setText(currentDate);

        datasource = new DataSource(this);
        datasource.open();
        populateReport();

        createSaldo();

        createDreamgoals();


        TextView textviewmain = (TextView)findViewById(R.id.text_report);
        TextView textviewpex = (TextView)findViewById(R.id.text_report_perexpense);
        TextView textviewpin = (TextView)findViewById(R.id.text_report_perincome);
        TextView textviewex = (TextView)findViewById(R.id.text_report_expense);
        TextView textviewin = (TextView)findViewById(R.id.text_report_income);
        TextView textviewgoal = (TextView)findViewById(R.id.text_report_dreamgoal);
        TextView textviewgoalmonth = (TextView)findViewById(R.id.text_report_dreamgoal_months);
        TextView textviewtotal = (TextView)findViewById(R.id.text_report_result);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/silentreaction.ttf");
        textviewmain.setTypeface(typeface);
        textviewpex.setTypeface(typeface);
        textviewpin.setTypeface(typeface);
        textviewex.setTypeface(typeface);
        textviewin.setTypeface(typeface);
        textviewgoal.setTypeface(typeface);
        textviewgoalmonth.setTypeface(typeface);
        textviewtotal.setTypeface(typeface);
    }

    // Methode populateReport(). Befüllt die Textfelder der Report-Seite mit Werten durch den Aufruf der entsprechenden Methoden.
    // Aus der Datenbank werden durch diese Methoden Werte für jede Kategorie abgefragt.
    // Diese Werte werden in die entsprechenden TextFelder gesetzt.

    public void populateReport(){

        TextView pexpendReport = (TextView)findViewById(R.id.edittext_pexpendreport);
        TextView pincomeReport = (TextView)findViewById(R.id.edittext_pincomereport);
        TextView incomeReport = (TextView)findViewById(R.id.edittext_incomereport);
        TextView expendReport = (TextView)findViewById(R.id.edittext_expendreport) ;


        String pexpendSumView = datasource.getPExpendSum().toStringPexpendSum();
        pexpendReport.setText("- " + pexpendSumView + "€");

        String pincomeSumView = datasource.getPincomeSum().toStringPincomeSum();
        pincomeReport.setText("+ " + pincomeSumView + "€");

        String incomeSumView = datasource.getIncomeSumDate().toStringIncomeWhere();
        incomeReport.setText("+ " + incomeSumView + "€");

        String expendSumView = datasource.getExpendSumDate().toStringExpendWhere();
        expendReport.setText("- " + expendSumView + "€");

    }


    // CreateSaldo() berechnet den Saldo indem durch Abfragen aus der Datenbank die benötigten Werte als String erhalten werden.
    // Diese Strings werden zu double gecastet. Auf diesen Variablen werden Rechenoperationen durchgeführt.
    // Das Ergebnis wird in der TextView als String gecastet angezeigt.

    public void createSaldo(){

        Double pexs;
        TextView saldoReport = (TextView)findViewById(R.id.edittext_saldoreport);

        String pexpendSaldo = datasource.getPExpendSum().toStringPexpendSum();
        if (pexpendSaldo != "Null"){
            pexs = Double.parseDouble(pexpendSaldo);
        }
        else { pexs = 0.0;}

        String pincomeSaldo = datasource.getPincomeSum().toStringPincomeSum();
        Double pins = Double.parseDouble(pincomeSaldo);

        String incomeSaldo = datasource.getIncomeSum().toStringIncomeSum();
        Double ins = Double.parseDouble(incomeSaldo);

        String expendSaldo = datasource.getExpendSum().toStringSum();
        Double exs = Double.parseDouble(expendSaldo);

        Double saldoraw = ins + pins - pexs - exs;
        Double saldofinal = Math.round(saldoraw*100)/100.0;

        String saldo =  String.valueOf(saldofinal);
        saldoReport.setText(""+ saldo + " €");


    }

    // Berechnet die monatliche Sparziel-Rate. Die Differenz aus dem currentDate und dem Datum des nächsten Sparziels ist der Divident.

    public void createDreamgoals (){
        TextView savingNext = (TextView)findViewById(R.id.edittext_report_result_dreamgoal) ;
        TextView savingMonth = (TextView)findViewById(R.id.edittext_report_result_dreamgoal_months) ;


        String dreamView = datasource.getNextSaving().toStringSavingWhere();
        savingNext.setText(dreamView);

        String rawCurrentDate = currentDate.substring(3,5);
        String rawDate = datasource.getNextSaving().toStringSavingWhere();
        String compDate = rawDate.substring(3,5);
        Log.d("comptest", compDate.toString());
        String rawNum = datasource.getNextSaving().toStringSavingNumber();
        Log.d("numtest", rawNum.toString());

        Double compDateD = Double.parseDouble(compDate);
        Double rawNumD = Double.parseDouble(rawNum);
        Double rawCurrentDateD = Double.parseDouble(rawCurrentDate);

        Double diffDate = compDateD - rawCurrentDateD;
        Double monthlyRate = rawNumD/diffDate;

        String finalRate = String.valueOf(monthlyRate);
        savingMonth.setText("" + finalRate + "€");
    }

    /*
    speichert eine Kalenderinstanz ab, formatiert die Datumsanzeige und speichert das aktuelle Datum
    in die Variable currentDate mit dem vorher definierten Format
     */
    private Calendar myCalender = Calendar.getInstance();
    String myFormat = "dd.MM.yy";
    SimpleDateFormat dateForm = new SimpleDateFormat(myFormat, Locale.GERMANY);
    String currentDate = dateForm.format(myCalender.getTime());



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    /*
      Jedes Item des Menüs wird mit einer Logik versehen. Die Logik besteht darin, den Bildschirm zu welchseln,
      sobald der Nutzer darauf klickt.
       */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_main) {
            Intent MainScreenIntent = new Intent(this, MainActivity.class);
            final int result = 1;
            startActivity(MainScreenIntent);
            return true;

        } else if (id == R.id.action_report) {

            Intent ReportScreenIntent = new Intent(this, ReportActivity.class);
            final int result = 1;
            startActivity(ReportScreenIntent);
            return true;

        } else if (id == R.id.action_incomeexpend) {
            Intent IncomeExpendScreenIntent = new Intent(this, IncomeExpendAcitvity.class);
            final int result = 1;
            startActivity(IncomeExpendScreenIntent);
            return true;

        } else if (id == R.id.action_debts) {
            Intent DebtsScreenIntent = new Intent(this, DebtsActivity.class);
            final int result = 1;
            startActivity(DebtsScreenIntent);
            return true;

        } else if (id == R.id.action_credits) {
            Intent CreditsScreenIntent = new Intent(this, CreditsActivity.class);
            final int result = 1;
            startActivity(CreditsScreenIntent);
            return true;

        } else if (id == R.id.action_income) {
            Intent IncomeScreenIntent = new Intent(this, IncomeActivity.class);
            final int result = 1;
            startActivity(IncomeScreenIntent);
            return true;

        } else if (id == R.id.action_expends) {
            Intent ExpendsScreenIntent = new Intent(this, ExpendsActivity.class);
            final int result = 1;
            startActivity(ExpendsScreenIntent);
            return true;

        } else if (id == R.id.action_pexpends) {
            Intent PExpendsScreenIntent = new Intent(this, PExpendActivity.class);
            final int result = 1;
            startActivity(PExpendsScreenIntent);
            return true;

        } else if (id == R.id.action_pincome) {
            Intent PIncomeScreenIntent = new Intent(this, PIncomeActivity.class);
            final int result = 1;
            startActivity(PIncomeScreenIntent);
            return true;

        } else if (id == R.id.action_dreamlist) {
            Intent DreamlistScreenIntent = new Intent(this, DreamlistActivity.class);
            final int result = 1;
            startActivity(DreamlistScreenIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}