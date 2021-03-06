package com.firstapplication.medianight.andoridhdm;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends Activity {

    private PopupWindow popupWin;
    private Calendar myCalender = Calendar.getInstance();
    DataSource dataSource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

          /*
        Beim Aufruf wird die Main Layout Datei als View genommen.
        Die Datenbankverbindung wird zudem noch aufgebaut.
        Um den Textfont zu ändern, werden alle Texte erst initialisiert und dann mit Typeface das Font angepasst
        ES werdem weiterhin alle BImagebuttons initialisiert und mit einer On Click Methode versehen.
        Je nachdem welcher Button gedrückt wird, wird eine andere Pop Up Methode ausgefürt


         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = (TextView)findViewById(R.id.textView_main);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/silentreaction.ttf");
        textview.setTypeface(typeface);


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
        dataSource = new DataSource(MainActivity.this);
     //   List<ExpendModel> values = dataSource.getAllExpends();



    }



    // Eine Notification soll angezeigt werden, beim Aufruf dieser Methode.
    public void ToastDatabase(){
        Toast.makeText(getApplicationContext(), "Daten in Datenbank geschrieben", Toast.LENGTH_SHORT).show();
    }

    /*
    Diese Methode erstellt einen Popup für die Eingabe der Ausgaben. Darin wird zunächst die Popup java Klasse genutzt um einen popup
    bauen zu können. Dieser wird dann mit einem Layout zugeordnet.
    Als nächstes werden die Elemente im Popup initilisiert, in diesem Fall 3 Edit Felder.
    Für das Datumsfeld soll ein Kalender auftacuhen, bei dem das Datum ausgewählt werden kann. Dies wird mit dem Datepicker
    erstellt. Dort wird ein OnListener hinzugefügt damit die Eingabe verwertet werden kann.
    Dann wird beim Datumseingabefeld ein OnClickListener drangesetzt. Beim Klick poppt dann ein Kalender auf.
    Am Ende werden 2 Button initialisiert. Einer dient zum schließen des pop Ups, der andere verwertet, beim klick, die Eingaben und
    schickt sie der Datenbank. Die Datenbank erhält ein Ausgabeobjekt.
    Danach wird auch hier das pop Up geschlossen und eine Notification erscheint, das die Eingabe erfolgreich war.

     */
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

            final Button dimissButton = (Button) layout.findViewById(R.id.popup_expend_dimiss);
            dimissButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   popupWin.dismiss();

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

                    ExpendModel expendModel = new ExpendModel();
                    expendModel.setExpendNameString(ExpendNameString);
                    expendModel.setExpendAmountString(ExpendAmountString);
                    expendModel.setExpendDateString(ExpendDateString);
                    dataSource.open();
                    dataSource.createExpend(expendModel);
                    popupWin.dismiss();
                    ToastDatabase();
                    dataSource.close();


                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /*
    Diese Methode erstellt einen Popup für die Eingabe der Einnahmen. Darin wird zunächst die Popup java Klasse genutzt um einen popup
    bauen zu können. Dieser wird dann mit einem Layout zugeordnet.
    Als nächstes werden die Elemente im Popup initilisiert, in diesem Fall 3 Edit Felder.
    Für das Datumsfeld soll ein Kalender auftacuhen, bei dem das Datum ausgewählt werden kann. Dies wird mit dem Datepicker
    erstellt. Dort wird ein OnListener hinzugefügt damit die Eingabe verwertet werden kann.
    Dann wird beim Datumseingabefeld ein OnClickListener drangesetzt. Beim Klick poppt dann ein Kalender auf.
    Am Ende werden 2 Button initialisiert. Einer dient zum schließen des pop Ups, der andere verwertet, beim klick, die Eingaben und
    schickt sie der Datenbank. Die Datenbank erhält ein Einnahmeobjekt.
    Danach wird auch hier das pop Up geschlossen und eine Notification erscheint, das die Eingabe erfolgreich war.

     */
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

            Button dimissButton = (Button) layout.findViewById(R.id.popup_income_dimiss);
            dimissButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWin.dismiss();
                }
            });


            Button submitButton = (Button) layout.findViewById(R.id.popup_income_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String IncomeNameString = IncomeName.getText().toString();
                    String IncomeAmountString = IncomeAmount.getText().toString();
                    String IncomeDateString = IncomeDate.getText().toString();

                    IncomeModel incomeModel = new IncomeModel();
                    incomeModel.setIncomeNameString(IncomeNameString);
                    incomeModel.setIncomeAmountString(IncomeAmountString);
                    incomeModel.setIncomeDateString(IncomeDateString);


                    dataSource.open();
                    dataSource.createIncome(incomeModel);
                    popupWin.dismiss();
                    ToastDatabase();
                    dataSource.close();
                }
            });



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
      Diese Methode erstellt einen Popup für die Eingabe der Schulden. Darin wird zunächst die Popup java Klasse genutzt um einen popup
      bauen zu können. Dieser wird dann mit einem Layout zugeordnet.
      Als nächstes werden die Elemente im Popup initilisiert, in diesem Fall 3 Edit Felder.
      Für das Datumsfeld soll ein Kalender auftacuhen, bei dem das Datum ausgewählt werden kann. Dies wird mit dem Datepicker
      erstellt. Dort wird ein OnListener hinzugefügt damit die Eingabe verwertet werden kann.
      Dann wird beim Datumseingabefeld ein OnClickListener drangesetzt. Beim Klick poppt dann ein Kalender auf.
      Am Ende werden 2 Button initialisiert. Einer dient zum schließen des pop Ups, der andere verwertet, beim klick, die Eingaben und
      schickt sie der Datenbank. Die Datenbank erhält ein Schuldenobjekt.
      Danach wird auch hier das pop Up geschlossen und eine Notification erscheint, das die Eingabe erfolgreich war.

       */
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

            Button dimissButton = (Button) layout.findViewById(R.id.popup_debts_dimiss);
            dimissButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWin.dismiss();
                }
            });


            Button submitButton = (Button) layout.findViewById(R.id.popup_debts_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String DebtsNameString = DebtsName.getText().toString();
                    String DebtsAmountString = DebtsAmount.getText().toString();
                    String DebtsDateString = DebtsDate.getText().toString();
                    DebtsModel debtsModel = new DebtsModel();
                    debtsModel.setDebtsNameString(DebtsNameString);
                    debtsModel.setDebtsAmountString(DebtsAmountString);
                    debtsModel.setDebtsDateString(DebtsDateString);


                    dataSource.open();
                    dataSource.createDebt(debtsModel);
                    popupWin.dismiss();
                    ToastDatabase();
                    dataSource.close();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /*
  Diese Methode erstellt einen Popup für die Eingabe der gutschriften. Darin wird zunächst die Popup java Klasse genutzt um einen popup
  bauen zu können. Dieser wird dann mit einem Layout zugeordnet.
  Als nächstes werden die Elemente im Popup initilisiert, in diesem Fall 3 Edit Felder.
  Für das Datumsfeld soll ein Kalender auftacuhen, bei dem das Datum ausgewählt werden kann. Dies wird mit dem Datepicker
  erstellt. Dort wird ein OnListener hinzugefügt damit die Eingabe verwertet werden kann.
  Dann wird beim Datumseingabefeld ein OnClickListener drangesetzt. Beim Klick poppt dann ein Kalender auf.
  Am Ende werden 2 Button initialisiert. Einer dient zum schließen des pop Ups, der andere verwertet, beim klick, die Eingaben und
  schickt sie der Datenbank. Die Datenbank erhält ein Gutschriftobjekt.
  Danach wird auch hier das pop Up geschlossen und eine Notification erscheint, das die Eingabe erfolgreich war.

   */
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

            Button dimissButton = (Button) layout.findViewById(R.id.popup_credits_dimiss);
            dimissButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWin.dismiss();
                }
            });


            Button submitButton = (Button) layout.findViewById(R.id.popup_credits_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String CreditsNameString = CreditsName.getText().toString();
                    String CreditsAmountString = CreditsAmount.getText().toString();
                    String CreditsDateString = CreditsDate.getText().toString();

                    CreditsModel creditModel = new CreditsModel();
                    creditModel.setCreditsNameString(CreditsNameString);
                    creditModel.setCreditsAmountString(CreditsAmountString);
                    creditModel.setCreditsDateString(CreditsDateString);


                    dataSource.open();
                    dataSource.createCredit(creditModel);
                    popupWin.dismiss();
                    ToastDatabase();
                    dataSource.close();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
  Diese Methode erstellt einen Popup für die Eingabe der Sparziele. Darin wird zunächst die Popup java Klasse genutzt um einen popup
  bauen zu können. Dieser wird dann mit einem Layout zugeordnet.
  Als nächstes werden die Elemente im Popup initilisiert, in diesem Fall 3 Edit Felder.
  Für das Datumsfeld soll ein Kalender auftacuhen, bei dem das Datum ausgewählt werden kann. Dies wird mit dem Datepicker
  erstellt. Dort wird ein OnListener hinzugefügt damit die Eingabe verwertet werden kann.
  Dann wird beim Datumseingabefeld ein OnClickListener drangesetzt. Beim Klick poppt dann ein Kalender auf.
  Am Ende werden 2 Button initialisiert. Einer dient zum schließen des pop Ups, der andere verwertet, beim klick, die Eingaben und
  schickt sie der Datenbank. Die Datenbank erhält ein Sparzielobjekt.
  Danach wird auch hier das pop Up geschlossen und eine Notification erscheint, das die Eingabe erfolgreich war.

   */
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

            Button dimissButton = (Button) layout.findViewById(R.id.popup_saving_dimiss);
            dimissButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWin.dismiss();
                }
            });


            Button submitButton = (Button) layout.findViewById(R.id.popup_saving_submit);
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String SavingNameString = SavingName.getText().toString();
                    String SavingAmountString = SavingAmount.getText().toString();
                    String SavingDateString = SavingDate.getText().toString();

                    SavingModel savingModel = new SavingModel();
                    savingModel.setSaveNameString(SavingNameString);
                    savingModel.setSaveAmountString(SavingAmountString);
                    savingModel.setSaveDateString(SavingDateString);


                    dataSource.open();
                    dataSource.createSaving(savingModel);
                    popupWin.dismiss();
                    ToastDatabase();
                    dataSource.close();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Erstelle die Menüleiste
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