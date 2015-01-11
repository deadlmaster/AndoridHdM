/**package com.firstapplication.medianight.andoridhdm;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Cpt Cranberry on 04/01/2015.

public class EaSClass extends Activity {

    public void ButtonClick (View view){
        String field1;
        int field2;
        RadioButton earningR, spendingR;
        Button saveEAS;

        EditText EaSField1 = (EditText)findViewById(R.id.eaSName);
        EditText EaSField2 = (EditText)findViewById(R.id.easAmount);
        earningR =(RadioButton)findViewById(R.id.radioEarning);
        spendingR = (RadioButton)findViewById(R.id.radioSpending);

        if (field1.getText().toString().lenght == 0) {
            return;
            }
        if (field2.getText().toString().lenght == 0) {
            return;
        }
        field1 = EaSField1.getText().toString();
        field2 = Integer.parseInt(EaSField2.getText().toString());

    }
}
*/