package br.com.packapps.eventbusapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Service", "onstartCommand");

        //Message to be sent for all View registed on EventBus
        MyMessage message = new MyMessage();
        message.setMessage("Message come the service");

        //delay sending by 2s
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }

        //send data for all Registed
        EventBus.getDefault().post(message);

        return super.onStartCommand(intent, flags, startId);
    }
}
