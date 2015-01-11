package com.firstapplication.medianight.andoridhdm;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


/**
 * Created by Peter Tan on 04.01.2015.
 */

public class BalanceActivity extends Activity {

  private ExpendDataSource exds;
  private List<ExpendModel> expds = new ArrayList<ExpendModel>();
  ArrayAdapter<ExpendModel> adapter;
  ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balance_layout);
        TextView ScreenDate = (TextView)findViewById(R.id.text_date_balance);
        ScreenDate.setText(currentDate);
        exds = new ExpendDataSource(); //fehlt this
        exds.open();
        initializeViews();
        expds = exds.getAllExpends();
    }

    public void initializeViews(){

        listView = (ListView)findViewById(R.id.expendList);
        listView.setLongClickable(true);

    }

    public void refreshDisplay(){
        adapter = new ArrayAdapter<ExpendModel>(getApplicationContext(), android.R.layout.simple_list_item_1, expds);
        listView.setAdapter(adapter);
    }



    private class MyTask extends AsyncTask<String, String, String>{
        protected String doInBackground(String... strings){
            expds = exds.getAllExpends();
            return null;
        }

        protected void onPostExecute(String result){
            refreshDisplay();
        }
    }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_main) {
            Intent MainScreenIntent = new Intent(this, MainActivity.class);
            final int result = 1;
            startActivity(MainScreenIntent);
            return true;

        } else if (id == R.id.action_balance) {

            Intent BalanceScreenIntent = new Intent(this, BalanceActivity.class);
            final int result = 1;
            startActivity(BalanceScreenIntent);
            return true;

        } else if (id == R.id.action_debtscredits) {
            Intent DebtsCreditsScreenIntent = new Intent(this, DebtsCreditsActivity.class);
            final int result = 1;
            startActivity(DebtsCreditsScreenIntent);
            return true;

        } else if (id == R.id.action_incomeexpend) {
            Intent IncomeExpendScreenIntent = new Intent(this, IncomeExpendAcitvity.class);
            final int result = 1;
            startActivity(IncomeExpendScreenIntent);
            return true;

        } else if (id == R.id.action_dreamlist) {
            Intent DreamlistScreenIntent = new Intent(this, DreamlistActivity.class);
            final int result = 1;
            startActivity(DreamlistScreenIntent);
            return true;

        } else if (id == R.id.action_help) {

        } else if ( id == R.id.action_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
