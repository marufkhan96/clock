package com.creative_multimedia.clock;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button alarm;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarm = findViewById(R.id.alrm);
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAlarm();
            }

        });
    }

   public void setAlarm(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
       Calendar calendar = Calendar.getInstance();
       calendar.setTimeInMillis(System.currentTimeMillis());
       calendar.set(Calendar.HOUR_OF_DAY,8);
       calendar.set(Calendar.MINUTE,30);
       Intent intent = new Intent(this,alarmRecever.class);
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
           pendingIntent = PendingIntent.getBroadcast(this,
                   0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);


       }else {
           pendingIntent = PendingIntent.getBroadcast(this,
                   0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

       }
       alarmManager.set(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), pendingIntent);
       Toast.makeText(this, "alarm set", Toast.LENGTH_SHORT).show();
    }


}