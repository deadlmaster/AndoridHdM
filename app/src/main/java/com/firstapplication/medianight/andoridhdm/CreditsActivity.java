package com.firstapplication.medianight.andoridhdm;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

//Klasse für die Activity mit der Liste der Gutschriften.
public class CreditsActivity extends ListActivity  {

    private DataSource datasource;
    ListView listView;

//Gibt an, was bei dem Öffnen der Activity aufgerufen wird.

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*
        Beim Aufruf wird die Credits Layout Datei als View genommen.
        Weiterhin wird das Datumstextfeld initialisiert und mit dem jetztigen Datum gefüllt
        Die Datenbankverbindung wird zudem noch aufgebaut.
        Um den Textfont zu ändern, werden alle Texte erst initialisiert und dann mit Typeface das Font angepasst

         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits_layout);
        TextView ScreenDate = (TextView)findViewById(R.id.text_date_credits);
        ScreenDate.setText(currentDate);
        datasource = new DataSource(this);
        datasource.open();

        TextView textviewtotal = (TextView)findViewById(R.id.text_credits_list_total);
        TextView textviewmain = (TextView)findViewById(R.id.text_credits);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/silentreaction.ttf");
        textviewtotal.setTypeface(typeface);
        textviewmain.setTypeface(typeface);

        // Versucht die Liste zu befüllen: Sind keine Werte in der Datenvorhanden passiert nichts. Liste wird nicht befüllt.

        try { populateList(); } catch (Exception e) {
            e.printStackTrace(); }

        // Bei Long-Click wird die Methode deleteCredits() aufgerufen. Anschließend wird die Liste erneut befüllt.
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            // setting onItemLongClickListener and passing the position to the function
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {

                String creditDel = ((TextView) arg1.findViewById(android.R.id.text1)).getText().toString();
                String creditLike = creditDel.substring(3,5);


                datasource.deleteCredits(creditLike);
                Intent intent = getIntent();

                try {
                    populateList();} catch (Exception e) {finish();
                    startActivity(intent);}
                return true;
            }
        });
    }


    // Befüllt die Liste mit den Daten durch Aufruf der Methode getAllCredits().
    public void populateList(){

        listView = (ListView)findViewById(android.R.id.list);
        listView.setLongClickable(true);

        List<CreditsModel> values = datasource.getAllCredits();

        ArrayAdapter<CreditsModel> adapter = new ArrayAdapter<CreditsModel>(this, android.R.layout.simple_list_item_1, values);


        setListAdapter(adapter);
        TextView textView = (TextView) findViewById(R.id.editText_credits_amount);
        String creditSumView = datasource.getCreditsSum().toStringCreditSum();
        textView.setText("+ " + creditSumView + "€");
    }


    // Erstelle die Menüleiste
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
     speichert eine Kalenderinstanz ab, formatiert die Datumsanzeige und speichert das aktuelle Datum
     in die Variable currentDate mit dem vorher definierten Format
      */
    private Calendar myCalender = Calendar.getInstance();
    String myFormat = "dd.MM.yy";
    SimpleDateFormat dateForm = new SimpleDateFormat(myFormat, Locale.GERMANY);
    String currentDate = dateForm.format(myCalender.getTime());


    /*
    Jedes Item des Menüs wird mit einer Logik versehen. Die Logik besteht darin, den Bildschirm zu welchseln,
    sobald der Nutzer darauf klickt.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


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
