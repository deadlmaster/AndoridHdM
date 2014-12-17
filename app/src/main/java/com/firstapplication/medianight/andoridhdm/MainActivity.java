package com.firstapplication.medianight.andoridhdm;

import android.app.Activity;
import android.content.ClipData;
//import android.content.Context;
import android.os.Bundle;
import android.view.DragEvent;
//import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
//import android.widget.PopupWindow;


public class MainActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView coinbutton, main_saving, main_expenditure, main_income, main_credit, main_debts;


        // dragable item

        coinbutton = (ImageView)findViewById(R.id.Coin_Main);
        coinbutton.setOnTouchListener(new ChoiceTouchListener());

        // dropable options
        main_saving = (ImageView)findViewById(R.id.main_saving);
        main_expenditure = (ImageView)findViewById(R.id.main_expenditure);
        main_income = (ImageView)findViewById(R.id.main_income);
        main_credit = (ImageView)findViewById(R.id.main_credit);
        main_debts = (ImageView)findViewById(R.id.main_debts);

        main_saving.setOnDragListener(new ChoiceDragListener());
        main_expenditure.setOnDragListener(new ChoiceDragListener());
        main_income.setOnDragListener(new ChoiceDragListener());
        main_credit.setOnDragListener(new ChoiceDragListener());
        main_debts.setOnDragListener(new ChoiceDragListener());
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private final class ChoiceTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {

                ClipData clipdata = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(clipdata,shadowBuilder,v,0);

                return true;

        } else {
                    return  false;
            }
        }
    }

    private class ChoiceDragListener implements View.OnDragListener{

        @Override
        public boolean onDrag(View v, DragEvent dragevent) {

            switch (dragevent.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    break;

                default:
                    break;
            }
        return true;
        }
    }

/*

    private void initiatePopupWindow() {

            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View popuplayout = inflater.inflate(R.layout.popupwindow_layout, null);
            PopupWindow popupWindow = new PopupWindow(popuplayout, 350, 400, true);


    }

*/

}
