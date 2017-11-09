package com.example.whitesound.aprendiendoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private Button botonIngreso, botonRegistrarse;
    private ArrayList<String> usuarios;

    //Si la sesión está iniciada, estas variables deben de saberlo.
    private String userActual, passActual, sexoActual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (usuarios == null) {
            usuarios = new ArrayList<>();
            usuarios.add("q#q#hombre");
        }

        //El boton registrarse tiene la funcion de cambiar de actividad.
        botonRegistrarse = (Button) findViewById(R.id.btnRegistrarme);
        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Se ha hecho click en Registro.");
                //Se ingresa a la pantalla Registro
                Intent i = new Intent(getApplicationContext(),Registro.class);
                //A la actividad registro se le mandan los usuarios previamente creados como String:
                i.putExtra("usuarios",
                        Utilidad.convertirAString(usuarios,","));
                Utilidad.mostrarArreglo(usuarios, "Arreglo enviado a actividad registro.");
                startActivityForResult(i,1);




            }
        });



        //El boton ingreso compara el contenido de los campos de texto vs el arraylist.
        botonIngreso = (Button) findViewById(R.id.btnIngresar);
        botonIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Se ha hecho click en Ingreso.");


                //Se obtiene el contenido de los dos EditText's:
                String user = ((EditText) findViewById(R.id.userLogin)).getText().toString();
                String pass = ((EditText) findViewById(R.id.passLogin)).getText().toString();

                //Si alguno de los campos está vacio, se notifica y se termina la ejecucion ·
                if (user.isEmpty() || pass.isEmpty())
                {
                    System.out.println("Alguno de los campos esta vacío.");
                    setError("Error: Hay campos vacios!.");
                   return;
                }

                //Comparación de datos vs los de el arraylist:

                boolean encontrado = false;
                for (int i = 0; i < usuarios.size(); i++){
                    String[] split = usuarios.get(i).split("#");
                    if (user.equals(split[0]) && pass.equals(split[1])){
                        encontrado = true;

                        System.out.println("El usuario ha sido encontrado, iniciando nueva actividad.");

                        userActual = user;
                        passActual = pass;
                        sexoActual = split[2];

                        setError("");//Se limpia texto de error.
                        //Se iniciará la actividad que permite escoger la fecha de nacimiento:
                        Intent intent = new Intent(getApplicationContext(),Nacimiento.class);
                        startActivityForResult(intent,2);

                        break;
                    }
                }

                //Se notifica en caso de que el usuario finalmente no haya sido encontrado.
                if (!encontrado){
                    setError("Error: Usuario o contraseña incorrectos.");
                    System.out.println("El usuario no ha sido encontrado.");
                }




            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Según el request_code con el que termine cada actividad, se sabrá que hacer.
        switch (requestCode){
            case 1:
                //Cuando se regresa del registro:
                try {
                    usuarios = Utilidad.convertirAArrayList((String)data.getExtras().get("usuarios"), ",");
                    Utilidad.mostrarArreglo(usuarios,"Resultado desde actividad registro.");

                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                break;
            case 2:
                try {
                    System.out.println("Se ha retornado desde nacimiento:");
                    //Cuando se regresa de la actividad nacimiento:
                    Intent i = new Intent(getApplicationContext(), Calendario.class);

                    String annio = (String) data.getExtras().get("annio");
                    //Se envian las variables a la actividad calendario:
                    i.putExtra("annio", annio);
                    i.putExtra("user", userActual);
                    i.putExtra("pass", passActual);//No es necesaria
                    i.putExtra("sexo", sexoActual);

                    //Se inicia la actividad:
                    startActivity(i);
                } catch (Exception ex){
                    System.out.println("Se ha devuelto utilizando el boton de retroceso.\n" +
                            " esto ha provocado el siguiente error: \n" + ex.getMessage());
                }
                break;
        }
    }

    private void setError(String mensaje)
    {
        ((TextView) findViewById(R.id.txtErrorLogin)).setText(mensaje);
    }




}
