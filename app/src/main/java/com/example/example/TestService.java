package com.example.example;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestService extends Service {

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
    @Override
    public void onCreate() {

        super.onCreate();
        Log.d("Test", "TestService Start");
        TestThread thread = new TestThread();
        thread.start();
    }
    class TestThread extends Thread {
        public void run() {
            try{
                Thread.sleep(5*1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                // TODO: handle exception
            }
            mHandler.sendMessage(Message.obtain(mHandler, 0));
        }
        public Handler mHandler = new Handler(){ // 핸들러 처리
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void handleMessage(Message msg){
                mHandler.sendEmptyMessageDelayed(0, 25*1000);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("HH", Locale.KOREA);
                int hour = Integer.parseInt(df.format(new Date()));

                if((MainActivity.save_month == 0 && MainActivity.save_date >= 20 && MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 1 && MainActivity.save_date <= 18)&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)){//month는 1을 빼줘야 한다.
                    new AlarmHATT1(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 1 && MainActivity.save_date >= 19&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 2 && MainActivity.save_date <= 20)&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)){
                    new AlarmHATT2(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 2 && MainActivity.save_date >= 21&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 3 && MainActivity.save_date <= 19&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT3(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 3 && MainActivity.save_date >= 20&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 4 && MainActivity.save_date <= 20&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT4(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 4 && MainActivity.save_date >= 21&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 5 && MainActivity.save_date <= 20&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT5(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 5 && MainActivity.save_date >= 21&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 6 && MainActivity.save_date <= 22&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT6(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 6 && MainActivity.save_date >= 23&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 7 && MainActivity.save_date <= 22&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT7(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 7 && MainActivity.save_date >= 23&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 8 && MainActivity.save_date <= 22&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT8(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 8 && MainActivity.save_date >= 23&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 9 && MainActivity.save_date <= 22&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT9(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 9 && MainActivity.save_date >= 23&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 10 && MainActivity.save_date <= 21&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT10(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 10 && MainActivity.save_date >= 22&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 11 && MainActivity.save_date <= 21&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT11(getApplicationContext()).Alarm();
                }else if((MainActivity.save_month == 11 && MainActivity.save_date >= 22&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE)) || (MainActivity.save_month == 12 && MainActivity.save_date <= 19&& MainActivity.save_hour == hour && MainActivity.save_min == calendar.get(Calendar.MINUTE))){
                    new AlarmHATT12(getApplicationContext()).Alarm();
                }
            }
        };

        public class AlarmHATT1 {
            public Context context;
            public AlarmHATT1(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD1.class);

                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Vibration cycle

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }

        public class AlarmHATT2 {
            public Context context;
            public AlarmHATT2(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD2.class);

                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Vibration cycle
                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT3 {
            public Context context;
            public AlarmHATT3(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD3.class);

                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Vibration cycle

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT4 {
            public Context context;
            public AlarmHATT4(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD4.class);

                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Vibration cycle

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT5 {
            public Context context;
            public AlarmHATT5(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD5.class);

                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Alarm reservation

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT6 {
            public Context context;
            public AlarmHATT6(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD6.class);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Alarm reservation

                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT7 {
            public Context context;
            public AlarmHATT7(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD7.class);

                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Alarm reservation
                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT8 {
            public Context context;
            public AlarmHATT8(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD8.class);

                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Alarm reservation
                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT9 {
            public Context context;
            public AlarmHATT9(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD9.class);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Alarm reservation
                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT10 {
            public Context context;
            public AlarmHATT10(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD10.class);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Alarm reservation
                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT11 {
            public Context context;
            public AlarmHATT11(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD11.class);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Alarm reservation
                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        public class AlarmHATT12 {
            public Context context;
            public AlarmHATT12(Context context) {
                this.context=context;
            }
            public void Alarm() {
                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(TestService.this, BroadcastD12.class);

                final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);//Alarm reservation
                PendingIntent sender = PendingIntent.getBroadcast(TestService.this, 0, intent, 0);

                Calendar calendar = Calendar.getInstance();
                //Set to alarm time calendar

                calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), MainActivity.save_hour, MainActivity.save_min);
                //Alarm reservation
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
    }
}