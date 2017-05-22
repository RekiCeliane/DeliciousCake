package cbtis72.regina.deliciouscake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class CakesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cakes);

        showToolbar(getResources().getString(R.string.pasteles),true);



    }


    public void goChoco (View v){
        setContentView(R.layout.pastel_chocolate);
        ImageView imageView = (ImageView) findViewById(R.id.imageCake);
        Glide.with(this).load("http://blog.kiwilimon.com/wp-content/uploads/2011/09/chocolate.jpg").into(imageView);
        showToolbar(getResources().getString(R.string.pastel_chocolate),false);

    }

    public void goCoco (View v){
        setContentView(R.layout.pastel_chocolate);
        ImageView imageView = (ImageView) findViewById(R.id.imageCake);
        Glide.with(this).load("https://postrestiamaria07.files.wordpress.com/2013/06/pastel-de-coco.jpg").into(imageView);
        showToolbar(getResources().getString(R.string.pastel_coco),false);

    }

    public void goFresa (View v){
        setContentView(R.layout.pastel_chocolate);
        ImageView imageView = (ImageView) findViewById(R.id.imageCake);
        Glide.with(this).load("http://detinmarin.mx/images/blog/pastel%20de%20fresa.jpg").into(imageView);
        showToolbar(getResources().getString(R.string.pastel_fresa),false);

    }
    public void goZanahoria (View v){
        setContentView(R.layout.pastel_chocolate);
        ImageView imageView = (ImageView) findViewById(R.id.imageCake);
        Glide.with(this).load("http://pasteleriajeffrey.com/images/stories/virtuemart/product/22_carrot_cake_copy.jpg").into(imageView);
        showToolbar(getResources().getString(R.string.pastel_zanahoria),false);

    }
    public void goGalleta (View v){
        setContentView(R.layout.pastel_chocolate);
        ImageView imageView = (ImageView) findViewById(R.id.imageCake);
        Glide.with(this).load("https://s-media-cache-ak0.pinimg.com/originals/71/1b/45/711b453e19e5ba2294f9eca7dd549c17.jpg").into(imageView);
        showToolbar(getResources().getString(R.string.pastel_galleta),false);

    }

    public void goQueso (View v){
        setContentView(R.layout.pastel_chocolate);
        ImageView imageView = (ImageView) findViewById(R.id.imageCake);
        Glide.with(this).load("http://menudiando.com/home/wp-content/uploads/2013/07/cheesecake5.jpg").into(imageView);
        showToolbar(getResources().getString(R.string.pastel_queso),false);

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
