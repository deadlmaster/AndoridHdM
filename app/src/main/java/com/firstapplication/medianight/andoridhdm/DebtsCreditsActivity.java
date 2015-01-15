package com.firstapplication.medianight.andoridhdm;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Peter Tan on 04.01.2015.
 */
public class DebtsCreditsActivity extends ListActivity  {

    private ExpendDataSource datasource;
    ListView listView;
    ArrayAdapter<ExpendModel> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debtscredits_layout);
        datasource = new ExpendDataSource(this);
        datasource.open();
        populateExp();

        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            // setting onItemLongClickListener and passing the position to the function
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {

                String expDel = ((TextView) arg1.findViewById(android.R.id.text1)).getText().toString();
                String expLike = expDel.substring(0,5);
                datasource.deleteExpend(expLike);

                //datasource.testdeleteexpend(arg3);
                populateExp();
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
