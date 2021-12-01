package com.example.broadcastreceiver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //se crea una instancia BroadcastReceiver
    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Se crea un filtro para los intents y se le pasa la conectividad
            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            //Se le añade alguna accion
            filter.addAction(intent.ACTION_AIRPLANE_MODE_CHANGED);
            //Registra
            registerReceiver(br, filter);
            //Se cierra
            unregisterReceiver(br);

            context.sendBroadcast(intent);
            //context.sendOrderedBroadcast(intent);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendOrderedBroadcast(Intent intent, @Nullable String receiverPermission) {
        super.sendOrderedBroadcast(intent, receiverPermission);
    }

    @Override
    public void sendBroadcast(Intent intent) {

        super.sendBroadcast(intent);
    }

}