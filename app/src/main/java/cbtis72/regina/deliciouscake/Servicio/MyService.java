package cbtis72.regina.deliciouscake.Servicio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this, "Empieza el Servicio", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        Toast.makeText(this, "Termina el Servicio", Toast.LENGTH_SHORT).show();
    }
}
