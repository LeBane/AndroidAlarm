package com.example.beantunes.myapplication.vue;


import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.beantunes.myapplication.R;
import com.example.beantunes.myapplication.metier.ListAlarm;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    public final static String EXTRA_MESSAGE = "truc de fou";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


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
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mRecyclerView.setAdapter(new AlarmAdapter(new ListAlarm().getList()));



        //Detection du flip pour cancel l'alarme
            //Chercher la TextView
        tvtest = (TextView)findViewById(R.id.testSensor);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManager.getSensorList(Sensor.TYPE_ROTATION_VECTOR).size()!=0){
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    /** Called when the user clicks the Send button */
    public void sendMessage() {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR)
            Log.d("000000000sensor",Float.toString(sensorEvent.values[0]));
        Log.d("1111111111111sensor",Float.toString(sensorEvent.values[1]));
        Log.d("2222222222222sensor",Float.toString(sensorEvent.values[2]));
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
