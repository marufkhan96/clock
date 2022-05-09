package com.creative_multimedia.clock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class alarmRecever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent serviceIntent = new Intent(context,myService.class);
            context.startService(serviceIntent);

        Toast.makeText(context, "from recever", Toast.LENGTH_LONG).show();
    }
}
