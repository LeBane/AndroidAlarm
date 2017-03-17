package com.example.beantunes.myapplication.vue;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.util.Calendar;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.beantunes.myapplication.R;

public class DisplayMessageActivity extends AppCompatActivity{

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

      //  alarmMgr = (AlarmManager) getSystemService(ALARM_SERVICE);



    }


  //  Intent openNewAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);



    /*
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);

        AlarmClock c = new AlarmClock();
        AlarmManager b;
        b.set(AlarmManager.RTC,1000,null);
        b = (AlarmManager)getSystemService(ALARM_SERVICE);
        b.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,2000,null);

        b.set(AlarmManager.RTC,1000,null);
*/
    /*
        public void createAlarm(String message, int hour, int minutes) {
            Intent intent2 = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                    .putExtra(AlarmClock.EXTRA_HOUR, hour)
                    .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
            if (intent2.resolveActivity(getPackageManager()) != null) {
                startActivity(intent2);
            }
        }
*/


}

