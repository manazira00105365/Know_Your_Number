package com.example.example;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

//https://kwongyo.tistory.com/5 push alarm!!!!!!!!!!!
//https://codeman77.tistory.com/29 set value!!!!!!
public class MainActivity extends AppCompatActivity {

    static  Calendar calendar = Calendar.getInstance();
    private SharedPreferences appData;
    public static int save_year = calendar.get(Calendar.YEAR);
    public static int save_month = calendar.get(Calendar.MONTH);
    public static int save_date = calendar.get(Calendar.DATE);
    public static int save_hour = 0;
    public static int save_min = 0;

    DatePickerDialog dialog;
    TimePickerDialog timedialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceIntent = new Intent(this.getBaseContext(),TestService.class);
        this.startService(serviceIntent);



        dialog = new DatePickerDialog(this, listener, save_year, save_month, save_date);
        timedialog = new TimePickerDialog(this, timeSetListener, save_hour, save_min, true);

        //Save settings
        appData = getSharedPreferences("appData", MODE_PRIVATE);
        load();


    }

    public void SaveDate(View view) {
        dialog.show();
    }

    public  void SaveTime(View view){timedialog.show();}

    private void save() {
        // SharedPreferences Can't save only with object Use Editor
        SharedPreferences.Editor editor = appData.edit();

        // Overwrite if name to save already exists ", save_month);
        editor.putInt("YEAR", save_year);
        editor.putInt("MONTH", save_month);
        editor.putInt("DATE", save_date);
        editor.putInt("HOUR", save_hour);
        editor.putInt("MIN", save_min);

        // apply, commit Save content
        editor.apply();
    }

    private void load() {
        // SharedPreferences Object.gettype (stored name, default)
        // Default if no saved name exists
        MainActivity.save_year = appData.getInt("YEAR", calendar.get(Calendar.YEAR));
        MainActivity.save_month = appData.getInt("MONTH", calendar.get(Calendar.MONTH));
        MainActivity.save_date = appData.getInt("DATE", calendar.get(Calendar.DATE));//The default is the current day
        MainActivity.save_hour = appData.getInt("HOUR", calendar.get(Calendar.HOUR));
        MainActivity.save_min = appData.getInt("MIN", calendar.get(Calendar.MINUTE));
    }


    //Date dialog
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int date) {
            MainActivity.save_year = year;
            MainActivity.save_month = month;
            MainActivity.save_date = date;
            save();
            Toast.makeText(getApplicationContext(), "Birthday setting "+year + "year" + (month+1) + "month" + date +"Set day.", Toast.LENGTH_SHORT).show();
        }
    };

    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            MainActivity.save_hour = hourOfDay;
            MainActivity.save_min = minute;
            save();
            Toast.makeText(getApplicationContext(), "Alarm setting "+ hourOfDay + "city " + minute + "Set to minutes.", Toast.LENGTH_SHORT).show();
        }
    };

    //Move to another page!!!!!!!!!!!!!!!!!!
    public void GotoSub1(View view) {
        Intent intent = new Intent(getApplicationContext(), Num1Activity.class);
        startActivity(intent);
    }

    public void GotoSub2(View view) {
        Intent intent = new Intent(getApplicationContext(), Num2Activity.class);
        startActivity(intent);
    }

    public void GotoSub3(View view) {
        Intent intent = new Intent(getApplicationContext(), Num3Activity.class);
        startActivity(intent);
    }

    public void GotoSub4(View view) {
        Intent intent = new Intent(getApplicationContext(), Num4Activity.class);
        startActivity(intent);
    }

    public void GotoSub5(View view) {
        Intent intent = new Intent(getApplicationContext(), Num5Activity.class);
        startActivity(intent);
    }

    public void GotoSub6(View view) {
        Intent intent = new Intent(getApplicationContext(), Num6Activity.class);
        startActivity(intent);
    }

    public void GotoSub7(View view) {
        Intent intent = new Intent(getApplicationContext(), Num7Activity.class);
        startActivity(intent);
    }

    public void GotoSub8(View view) {
        Intent intent = new Intent(getApplicationContext(), Num8Activity.class);
        startActivity(intent);
    }

    public void GotoSub9(View view) {
        Intent intent = new Intent(getApplicationContext(), Num9Activity.class);
        startActivity(intent);
    }

    public void GotoSub10(View view) {
        Intent intent = new Intent(getApplicationContext(), Num10Activity.class);
        startActivity(intent);
    }

    public void GotoSub11(View view) {
        Intent intent = new Intent(getApplicationContext(), Num11Activity.class);
        startActivity(intent);
    }

    public void GotoSub12(View view) {
        Intent intent = new Intent(getApplicationContext(), Num12Activity.class);
        startActivity(intent);
    }
}