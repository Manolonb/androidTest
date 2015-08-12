package com.example.manolo.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Manolo on 29/06/2015.
 */
public class prueba_primera extends MainActivity{

    float xFrom = 0.0f;
    float xTo = 400.0f;
    double StartTime,millis;

    TextView text2;
    Chronometer crono;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba_layout);

        //Como recibir datos y mostrarlos a un textview
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("usuario");
        int i = extras.getInt("edad");

        TextView text = (TextView) findViewById(R.id.cabeceratextview);
        text.setText(s);

        crono = (Chronometer) findViewById(R.id.cronometro);

    }

    public void mostrarImagen(View view) {

        crono.start();
        StartTime=System.currentTimeMillis();

        ImageView gol_imagen = (ImageView) findViewById(R.id.GOLimageView);
        //Cambiar estado de visibilidad
        int estado = gol_imagen.getVisibility();       // 0 = visible
        // 1 = invisible
        if (estado == 0)
            gol_imagen.setVisibility(View.INVISIBLE);
        else
            gol_imagen.setVisibility(View.VISIBLE);
    }

    public void moverImagen(View view){
        //Movimiento de la imagen
        ImageView gol_imagen = (ImageView) findViewById(R.id.GOLimageView);
        ImageView estrella_imagen = (ImageView) findViewById(R.id.ESTRELLAimageView);
        ImageView cambio_imagen = (ImageView) findViewById(R.id.CAMBIOimageView);


        crono.stop();
        millis=System.currentTimeMillis()-StartTime;        //Aqui obtenemos un numero que equivale al tiempo transcurrido
        text2 = (TextView) findViewById(R.id.text_prueba);
        text2.setText(String.valueOf(millis));

        //asigno imagen
        cambio_imagen.setImageResource(R.drawable.gol2);

        //creo la animacion

        AnimationSet cambio_Set = new AnimationSet(true);
        cambio_Set.setInterpolator(new AccelerateInterpolator());

        TranslateAnimation animation_cambio1 = new TranslateAnimation(0.0f, 100.0f, 0.0f, 0.0f);
        animation_cambio1.setStartOffset(0);
        animation_cambio1.setDuration(2000);  // animation duration
        animation_cambio1.setFillAfter(true);

        cambio_Set.addAnimation(animation_cambio1);

        // start animation parte 2
        TranslateAnimation animation_cambio2 = new TranslateAnimation(0.0f, 300.0f, 0.0f, 0.0f);
        animation_cambio2.setDuration(5000);  // animation duration
        animation_cambio2.setStartOffset(2000);
        animation_cambio2.setFillBefore(false);

        cambio_Set.addAnimation(animation_cambio2);
        cambio_imagen.startAnimation(cambio_Set);

        //ocultamos imagen
        cambio_imagen.setVisibility(View.INVISIBLE);

        //AnimationSet necesario para concatenar una animacion
        AnimationSet rootSet = new AnimationSet(true);
        rootSet.setInterpolator(new AccelerateInterpolator());
        // start animation parte 1
        TranslateAnimation animation_estrella1 = new TranslateAnimation(0.0f, 100.0f, 0.0f, 0.0f);
        animation_estrella1.setStartOffset(0);
        animation_estrella1.setDuration(5000);  // animation duration
        animation_estrella1.setFillAfter(true);

        rootSet.addAnimation(animation_estrella1);
        //estrella_imagen.startAnimation(animation_estrella1);

        // start animation parte 2
        TranslateAnimation animation_estrella2 = new TranslateAnimation(0.0f, 200.0f, 0.0f, 0.0f);
        animation_estrella2.setDuration(5000);  // animation duration
        animation_estrella2.setStartOffset(5000);
        animation_estrella2.setFillBefore(false);

        rootSet.addAnimation(animation_estrella2);

        estrella_imagen.startAnimation(rootSet);
        //estrella_imagen.startAnimation(animation_estrella2);


        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,10,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(5000);  // animation duration
        animation.setRepeatCount(5);  // animation repeat count
        animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
        //animation.setFillAfter(true);

        gol_imagen.startAnimation(animation);  // start animation
    }

    public void desplazar(View view)
    {



    }
}
