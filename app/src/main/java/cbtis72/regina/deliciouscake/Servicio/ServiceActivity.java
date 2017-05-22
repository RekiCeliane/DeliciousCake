package cbtis72.regina.deliciouscake.Servicio;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cbtis72.regina.deliciouscake.R;

public class ServiceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        showToolbar(getResources().getString(R.string.servicio),true);

    }

    public void startService (View view){

        startService( new Intent (getBaseContext(), MyService.class));

    }

    public void destroyService (View view){

        stopService( new Intent (getBaseContext(), MyService.class));

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
