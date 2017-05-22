package cbtis72.regina.deliciouscake;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cbtis72.regina.deliciouscake.Servicio.ServiceActivity;
import cbtis72.regina.deliciouscake.Settings.SettingsActivity;
import cbtis72.regina.deliciouscake.Share.ShareActivity;
import cbtis72.regina.deliciouscake.Share.ShareFragment;

public class MainActivity extends AppCompatActivity {

    AlarmManager am;

    @InjectView(R.id.settings)
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        showToolbar(getResources().getString(R.string.app_name),true);

        ButterKnife.inject(this);

    }

    //ButterKnife
    @OnClick(R.id.settings)
    public void goSettings(){
        Intent intent=new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void goCakes(View v){
        Intent intent=new Intent(this, CakesActivity.class);
        startActivity(intent);

        Intent intent2= new Intent();
        intent2.setAction("com.brounie.alarmas.action.ALARM_RECEIVER");

        PendingIntent pi = PendingIntent.getBroadcast( getApplicationContext(), 0, intent2, 0);

        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, pi);


    }

    public void goSearch (View v) {
        Intent intent=new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void goCompartir(View v){

        Intent intent=new Intent(this, ShareActivity.class);
        startActivity(intent);

    }

    public void goService(View v){

        Intent intent=new Intent(this, ServiceActivity.class);
        startActivity(intent);
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
