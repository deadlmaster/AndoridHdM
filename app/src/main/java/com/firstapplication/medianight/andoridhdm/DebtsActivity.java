package com.firstapplication.medianight.andoridhdm;

import android.app.ListActivity;
import android.content.Intent;
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

import java.util.List;

/**
 * Created by Peter Tan on 04.01.2015.
 */
public class DebtsActivity extends ListActivity  {

    private DataSource datasource;
    ListView listView;
    ArrayAdapter<ExpendModel> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debts_layout);
        datasource = new DataSource(this);
        datasource.open();


        try { populateExp(); } catch (Exception e) {
            e.printStackTrace(); }

        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            // setting onItemLongClickListener and passing the position to the function
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {

                String expDel = ((TextView) arg1.findViewById(android.R.id.text1)).getText().toString();
                Log.d("StringTest1", expDel);
                String expLike = expDel.substring(3,5);
                Log.d("StringTest", expLike);

                datasource.deleteExpend(expLike);
                Intent intent = getIntent();
                //datasource.testdeleteexpend(arg3);
                try {populateExp();} catch (Exception e) {finish();
                    startActivity(intent);}
                return true;
            }
        });
    }


    public void populateExp (){

        listView = (ListView)findViewById(android.R.id.list);
        listView.setLongClickable(true);

        List<ExpendModel> values = datasource.getAllExpends();

        ArrayAdapter<ExpendModel> adapter = new ArrayAdapter<ExpendModel>(this, android.R.layout.simple_list_item_1, values);


        setListAdapter(adapter);
    }






    /**listView.OnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
    String ExpendNameString = ((TextView) view.findViewById(android.R.id.text1)).getText().toString();
    datasource.deleteExpend(ExpendNameString);
    new MyTask().execute();
    return true;
    }
    }*/


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
