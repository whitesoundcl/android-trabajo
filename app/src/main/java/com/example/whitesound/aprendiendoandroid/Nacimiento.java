package com.example.whitesound.aprendiendoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Nacimiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nacimiento);

        //Listener del boton aceptar
        Button btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String annio = ((EditText) findViewById(R.id.annioNacimiento)).getText().toString();

                if (annio.length() == 0)
                    return;
                //Se limita el número mínimo que el usuario puede introducir.
                int numero = Integer.parseInt(annio);
                if (numero < 1900){
                    //TODO: Notificar al usuario..
                    setError("Año de nacimiento incorrecto.");
                    return;
                }

                //Se pasa el parametro a la actividad anterior:
                Intent i = new Intent();
                i.putExtra("annio",annio);
                setResult(2,i);
                setError("");//Se limpia cualquier mensaje de error.
                finish();

            }
        });
    }

    private void setError(String mensaje)
    {
        ((TextView) findViewById(R.id.txtErrorNacimiento)).setText(mensaje);
    }
}
