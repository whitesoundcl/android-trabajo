package com.example.whitesound.aprendiendoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Cosas a tener en consideración:
 * CALENDARIO CHINO:
 * La separacion entre años del horoscopo chino es de 12 años:
 * rata 1900
 * bufalo 1901
 * tigre 1902
 * liebre 1903
 * dragon 1904
 * serpiente 1905
 * caballo 1906
 * cabra 1907
 * mono 1908
 * gallo 1909
 * perro 1910
 * jabali 1911
 */

public class Calendario extends AppCompatActivity {

    private String user, annio, animal, siguienteAnnio, futuro, sexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);


        //Se obtienen los datos desde la actividad login:
        Intent i = getIntent();
        user = i.getStringExtra("user");
        annio = i.getStringExtra("annio");
        sexo = i.getStringExtra("sexo");

        //Se obtienen datos adicionales en base a los datos anteriores:
        animal = Utilidad.getAnimalPorAnnio(annio);
        futuro = Utilidad.getFuturo(animal);
        siguienteAnnio = Utilidad.getSiguienteAnnio(annio);
        System.out.println("Mi animal es el: " + animal);
        System.out.println("El siguiente año que me toca es: " + siguienteAnnio);

        //Se actualiza la información en la pantalla:
        ImageView img = (ImageView) findViewById(R.id.imgAnimal);
        img.setImageResource(Utilidad.getImagenPorNombre(animal));

        TextView txt = (TextView) findViewById(R.id.txtNombreAnimal);
        txt.setText(animal);

        txt = (TextView) findViewById(R.id.txtSiguienteAnnio);
        txt.setText(siguienteAnnio);

        txt = (TextView) findViewById(R.id.txtNombre);
        txt.setText(((sexo.equals("hombre")) ? "Bienvenido, " : "Bienvenida, ") + user + ".   Este e" +
                "s tu horoscopo:");

        txt = (TextView) findViewById(R.id.txtDescripcion);
        txt.setText(Utilidad.getFuturo(animal));


    }
}
