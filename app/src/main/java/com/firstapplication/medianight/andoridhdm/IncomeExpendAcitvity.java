package com.firstapplication.medianight.andoridhdm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Peter Tan on 04.01.2015.
 */
public class IncomeExpendAcitvity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eas);
        Button submitButton = (Button)findViewById(R.id.buttonIncomeExpenditure);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInputToDatabase();
            }
        });
        dataSource = new DataSource(IncomeExpendAcitvity.this);
        dataSource.open();

        TextView textview = (TextView)findViewById(R.id.textViewIncExp);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/silentreaction.ttf");
        textview.setTypeface(typeface);



    }

    DataSource dataSource;


    public void sendInputToDatabase() {

        EditText name = (EditText) findViewById(R.id.easName);
        EditText amount = (EditText) findViewById(R.id.easAmount);
        RadioButton radioIncome = (RadioButton) findViewById(R.id.radioEarning);
        RadioButton radioExpend = (RadioButton) findViewById(R.id.radioSpending);


        if (radioIncome.isChecked()) {

            String nameString = name.getText().toString();
            String nameAmount = amount.getText().toString();


            PIncomeModel pincomeModel = new PIncomeModel();
            pincomeModel.setPIncomeNameString(nameString);
            pincomeModel.setPIncomeAmountString(nameAmount);
            dataSource.createPIncome(pincomeModel);


            Toast.makeText(this, "In Datenbank geschrieben", Toast.LENGTH_SHORT).show();
            name.getText().clear();
            amount.getText().clear();


        } else if (radioExpend.isChecked()) {

            String nameString = name.getText().toString();
            String nameAmount = amount.getText().toString();

            PExpendModel pexpendModel = new PExpendModel();
            pexpendModel.setPExpendNameString(nameString);
            pexpendModel.setPExpendAmountString(nameAmount);
            dataSource.createPExpend(pexpendModel);

            Toast.makeText(this, "In Datenbank geschrieben", Toast.LENGTH_SHORT).show();
            name.getText().clear();
            amount.getText().clear();

        } else {
            Toast.makeText(this, "Bitte einen Button auswählen", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }





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
