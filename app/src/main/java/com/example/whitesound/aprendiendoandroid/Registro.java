package com.example.whitesound.aprendiendoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    //Botones asociados:
    //      btnRegistro , btnInicio
    Button botonRegistro, botonInicio;
    ArrayList<String> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

//Se obtienen los datos desde la actividad del login.(MainActivity)
        Intent i = getIntent();
        //Del string que llegó, se vuelve a convertir en arreglo para manipularlo.
        usuarios = Utilidad.convertirAArrayList(i.getStringExtra("usuarios"),",");
        Utilidad.mostrarArreglo(usuarios,"Arreglo recibido desde el login.");

//EVENTOS:


        //Al momento de hacer click en iniciar sesión (VOLVER), esta pantalla termina.
        botonInicio = (Button) findViewById(R.id.btnInicio);
        botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Se ha hecho click en iniciar sesion (Volver)");

                //Se guarda el arreglo de usuarios como string:
                Intent intent = new Intent();
                intent.putExtra("usuarios", Utilidad.convertirAString(usuarios,","));
                setResult(1,intent);
                //Termina de mostrarse la pantalla para volver a la MainActivity
                finish();
            }
        });

        //Se añade un usuario (Si se cumplen las condiciones) al arreglo:
        botonRegistro = (Button) findViewById(R.id.btnRegistro);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Se ha hecho click en registro");



                //Se obtienen los datos desde los campos de texto:
                String user = ((EditText) findViewById(R.id.userRegistro)).getText().toString();
                String pass = ((EditText) findViewById(R.id.passRegistro)).getText().toString();
                int sexoId = ((RadioGroup) findViewById(R.id.rdoSexo)).getCheckedRadioButtonId();
                String sexo = (sexoId == R.id.hombre) ? "hombre":"mujer";

                //Si alguno de los campos está vacio, se notifica y se termina la ejecucion:
                if (user.isEmpty() || pass.isEmpty()){
                    System.out.println("Uno de los campos está vacio");
                    setError("Hay campos vacios.");
                    return;
                }

                //Se verifica que el texto no contenga alguno de los caracteres divisores:
                String divArreglo = ",";
                String divParametros = "#";
                if (user.contains(divArreglo) || user.contains(divParametros)
                        || pass.contains(divArreglo) || pass.contains(divParametros))
                {
                    setError("Se ha introducido un caracter no permitido.");
                    System.out.println("Se ha introducido un caracter no permitido.");
                    return;
                }

                //Se verifica que el usuario no esté registrado:
                for (int i = 0; i < usuarios.size();i++)
                {
                    if (usuarios.get(i).split("#")[0].equals(user))
                    {
                        System.out.println("El usuario ya existe");
                        setError("El usuario ya existe.");
                        return;
                    }
                }

                usuarios.add(user + divParametros + pass + divParametros + sexo);
                Utilidad.mostrarArreglo(usuarios,"Se agregó un usuario nuevo.");
                setError("Usuario agregado!");

            }
        });


    }

    private void setError(String mensaje)
    {
        ((TextView) findViewById(R.id.txtErrorRegistro)).setText(mensaje);
    }
}
