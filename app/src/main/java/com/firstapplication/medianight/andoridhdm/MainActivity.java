package com.firstapplication.medianight.andoridhdm;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends Activity {

    private PopupWindow popupWin;
    private Calendar myCalender = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton openbuttonexpend = (ImageButton)findViewById(R.id.main_expenditure);
        openbuttonexpend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiatePopupWindowExpend();
            }

        });
        ImageButton openbuttonincome = (ImageButton)findViewById(R.id.main_income);
        openbuttonincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiatePopupWindowIncome();
            }

        });
        ImageButton openbuttondebts = (ImageButton)findViewById(R.id.main_debts);
        openbuttondebts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiatePopupWindowDebts();
            }

        });
        ImageButton openbuttoncredit = (ImageButton)findViewById(R.id.main_credit);
        openbuttoncredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiatePopupWindowCredit();
            }

        });
        ImageButton openbuttonsaving = (ImageButton)findViewById(R.id.main_saving);
        openbuttonsaving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiatePopupWindowSaving();
            }

        });

    }


    private void initiatePopupWindowExpend(){

        try{
            LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popupwindow_layout_expend, null );
            popupWin = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWin.showAtLocation(layout, Gravity.CENTER,0,0);

            final EditText ExpendName = (EditText)layout.findViewById(R.id.editText_popup_name_expend);
            final EditText ExpendAmount = (EditText)layout.findViewById(R.id.editText_popup_expend_amount);
            final EditText ExpendDate = (EditText)layout.findViewById(R.id.editText_popup_expend_date);

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    myCalender.set(Calendar.YEAR, year);
                    myCalender.set(Calendar.MONTH, monthOfYear);
                    myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String myFormat = "dd.MM.yy";
                    SimpleDateFormat dateForm = new SimpleDateFormat(myFormat, Locale.GERMANY);
                    ExpendDate.setText(dateForm.format(myCalender.getTime()));

                }
            };

            ExpendDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(MainActivity.this, date, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.DAY_OF_MONTH).show();



                }
            });

            Button submitButton = (Button) layout.findViewById(R.id.popup_expend_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ExpendNameString = ExpendName.getText().toString();
                    String ExpendAmountString = ExpendAmount.getText().toString();
                    String ExpendDateString = ExpendDate.getText().toString();
                    Log.d("Test", ExpendNameString);
                    Log.d("Test", ExpendAmountString);
                    Log.d("Test", ExpendDateString);

                    popupWin.dismiss();

                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private void initiatePopupWindowIncome(){

        try{
            LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popupwindow_layout_income, null );
            popupWin = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWin.showAtLocation(layout, Gravity.CENTER,0,0);

            final EditText IncomeName = (EditText)layout.findViewById(R.id.editText_popup_name_income);
            final EditText IncomeAmount = (EditText)layout.findViewById(R.id.editText_popup_income_amount);
            final EditText IncomeDate = (EditText)layout.findViewById(R.id.editText_popup_income_date);

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    myCalender.set(Calendar.YEAR, year);
                    myCalender.set(Calendar.MONTH, monthOfYear);
                    myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String myFormat = "dd.MM.yy";
                    SimpleDateFormat dateForm = new SimpleDateFormat(myFormat, Locale.GERMANY);
                    IncomeDate.setText(dateForm.format(myCalender.getTime()));

                }
            };

            IncomeDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(MainActivity.this, date, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.DAY_OF_MONTH).show();

                }
            });


            Button submitButton = (Button) layout.findViewById(R.id.popup_income_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String IncomeNameString = IncomeName.getText().toString();
                    String IncomeAmountString = IncomeAmount.getText().toString();
                    String IncomeDateString = IncomeDate.getText().toString();
                    popupWin.dismiss();
                }
            });



        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void initiatePopupWindowDebts(){

        try{
            LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popupwindow_layout_debts, null );
            popupWin = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWin.showAtLocation(layout, Gravity.CENTER,0,0);

            final EditText DebtsName = (EditText)layout.findViewById(R.id.editText_popup_name_debts);
            final EditText DebtsAmount = (EditText)layout.findViewById(R.id.editText_popup_debts_amount);
            final EditText DebtsDate = (EditText)layout.findViewById(R.id.editText_popup_debts_date);

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    myCalender.set(Calendar.YEAR, year);
                    myCalender.set(Calendar.MONTH, monthOfYear);
                    myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String myFormat = "dd.MM.yy";
                    SimpleDateFormat dateForm = new SimpleDateFormat(myFormat, Locale.GERMANY);
                    DebtsDate.setText(dateForm.format(myCalender.getTime()));

                }
            };

            DebtsDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(MainActivity.this, date, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.DAY_OF_MONTH).show();

                }
            });


            Button submitButton = (Button) layout.findViewById(R.id.popup_debts_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String DebtsNameString = DebtsName.getText().toString();
                    String DebtsAmountString = DebtsAmount.getText().toString();
                    String DebtsDateString = DebtsDate.getText().toString();
                    popupWin.dismiss();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private void initiatePopupWindowCredit(){

        try{
            LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popupwindow_layout_credit, null );
            popupWin = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWin.showAtLocation(layout, Gravity.CENTER,0,0);

            final EditText CreditsName = (EditText)layout.findViewById(R.id.editText_popup_name_credits);
            final EditText CreditsAmount = (EditText)layout.findViewById(R.id.editText_popup_credits_amount);
            final EditText CreditsDate = (EditText)layout.findViewById(R.id.editText_popup_credits_date);

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    myCalender.set(Calendar.YEAR, year);
                    myCalender.set(Calendar.MONTH, monthOfYear);
                    myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String myFormat = "dd.MM.yy";
                    SimpleDateFormat dateForm = new SimpleDateFormat(myFormat, Locale.GERMANY);
                    CreditsDate.setText(dateForm.format(myCalender.getTime()));

                }
            };

            CreditsDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(MainActivity.this, date, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.DAY_OF_MONTH).show();

                }
            });


            Button submitButton = (Button) layout.findViewById(R.id.popup_credits_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String CreditsNameString = CreditsName.getText().toString();
                    String CreditsAmountString = CreditsAmount.getText().toString();
                    String CreditsDateString = CreditsDate.getText().toString();
                    popupWin.dismiss();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

      private void initiatePopupWindowSaving(){

        try{
            LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popupwindow_layout_saving, null );
            popupWin = new PopupWindow(layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWin.showAtLocation(layout, Gravity.CENTER,0,0);

            final EditText SavingName = (EditText)layout.findViewById(R.id.editText_popup_name_saving);
            final EditText SavingAmount = (EditText)layout.findViewById(R.id.editText_popup_saving_amount);
            final EditText SavingDate = (EditText)layout.findViewById(R.id.editText_popup_saving_date);

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    myCalender.set(Calendar.YEAR, year);
                    myCalender.set(Calendar.MONTH, monthOfYear);
                    myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String myFormat = "dd.MM.yy";
                    SimpleDateFormat dateForm = new SimpleDateFormat(myFormat, Locale.GERMANY);
                    SavingDate.setText(dateForm.format(myCalender.getTime()));

                }
            };

            SavingDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new DatePickerDialog(MainActivity.this, date, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.DAY_OF_MONTH).show();

                }
            });


            Button submitButton = (Button) layout.findViewById(R.id.popup_saving_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String SavingNameString = SavingName.getText().toString();
                    String SavingAmountString = SavingAmount.getText().toString();
                    String SavingDateString = SavingDate.getText().toString();
                    popupWin.dismiss();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
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
