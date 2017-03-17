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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.TimePicker;
import android.widget.Toast;
import com.example.beantunes.myapplication.R;
import com.example.beantunes.myapplication.metier.ListAlarm;

import org.w3c.dom.Text;

import java.util.Date;

import static java.lang.System.currentTimeMillis;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    public final static String EXTRA_MESSAGE = "truc de fou";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    TimePicker alarmTimePicker;
    PendingIntent pendingIntent;
    public AlarmManager alarmManager;


    private SensorManager mSensorManager;
    private Sensor mSensor;

    private TextView tvtest;
    // Le booleen definit si le telephone est pose sur le dos pendant la sieste
    // (necessaire pour la desactivation de l'alarme par rotation
    private boolean telPoseSurDos=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

   //     mRecyclerView.setAdapter(new AlarmAdapter(new ListAlarm().getList()));



        //Detection du flip pour cancel l'alarme
            //Chercher la TextView
        tvtest = (TextView)findViewById(R.id.testSensor);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManager.getSensorList(Sensor.TYPE_ROTATION_VECTOR).size()!=0){
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void sendMessage(View v) {

        /*

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

        */
       long time = currentTimeMillis();
        Date d1 = new Date();
        Date d2;
      //  d2 = new Date(d1.getYear(),d1.getMonth(),d1.getDate(),d1.getHours(),d1.getMinutes(),d1.getSeconds());
        Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();
       // Calendar calendar = Calendar.getInstance();
       // calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
       // calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
        Intent intent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
       // time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
        Toast.makeText(MainActivity.this, "bjr", Toast.LENGTH_SHORT).show();
       // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time + 5, 10000, pendingIntent);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time + 10, pendingIntent);
        // Bon manque de prevenir le receiver....!!

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR)
        //    Log.d("sensor",Float.toString(sensorEvent.values[2]));
            if(telPoseSurDos) {
                if (Math.abs(sensorEvent.values[2]) < 0.3)
                    tvtest.setText("DESACTIVE ALARME");
                else
                    tvtest.setText("NE DESACTIVE PAS ALARME");
            }
            else {
                if (Math.abs(sensorEvent.values[2]) > 0.9)
                    tvtest.setText("NE DESACTIVE PAS ALARME");
                else
                    tvtest.setText("DESACTIVE ALARME");
            }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
