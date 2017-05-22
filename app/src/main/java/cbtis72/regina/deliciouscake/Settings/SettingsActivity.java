package cbtis72.regina.deliciouscake.Settings;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import cbtis72.regina.deliciouscake.R;

public class SettingsActivity extends AppCompatActivity {

    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        showToolbar(getResources().getString(R.string.configuraciones),true);

        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);



    }

    public void alarmita (View view){

        Toast.makeText(this,"Espere...", Toast.LENGTH_SHORT).show();

            Intent intent= new Intent();
            intent.setAction("com.brounie.alarmas.action.ALARM_RECEIVER");

            PendingIntent pi = PendingIntent.getBroadcast( getApplicationContext(), 0, intent, 0);

            am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, pi);
    }


    public void showToolbar(String tittle, boolean upButton){
        //Para que el toolbar tenga soporte para versiones anteriores
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Agregarle titulo
        getSupportActionBar().setTitle(tittle);
        //Para agregarle un boton de regreso
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
