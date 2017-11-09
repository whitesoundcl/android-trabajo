package com.example.whitesound.aprendiendoandroid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by whitesound (Luis Clavijo) on 07-11-17.
 * Este objeto almacenará el ArrayList que será pasado entre las actividades, además de contener logica
 * de almacenamiento de los datos.
 *
 * Existe para evitar que la información del arraylist se pierda en caso de que alguna actividad deba
 * cerrarse.
 *
 * Si una actividad debe cerrarse, tendrá que pasar este objeto a la siguiente.
 *
 * El contenido de un argumento del arraylist tipicamente será:
 * contenido0%sep%contenido1%sep%contenido2
 * Donde:
 *  Contenido0: nombre de usuario
 *  Contenido1: contraseña
 *  Contenido2: sexo
 */

public class  Pasable implements Serializable {
    private ArrayList<String> usuarios;
    private String divisor = "";

    public Pasable(String divisor) {
        usuarios = new ArrayList<>();
        this.divisor = divisor;
    }

    public ArrayList getUsuarios(){
        return this.usuarios;
    }

    //Para añadir un usuario se debe usar este metodo.
    //Retorna false en caso de que el usuario ya estuviese registrado.
    //true si el usuario fue añadido correctamente
    public boolean addUser(String nombre,String pass, String sexo){

        //Se revisa si el usuario no está previamente registrado.
        for (int i = 0; i < usuarios.size() ; i++){
            String user =  usuarios.get(i).split(divisor)[0];
            if (nombre.equals(user)){
                //Si el usuario es encontrado en el arreglo, se retorna un false.
                return false;
            }
        }
        usuarios.add(nombre + this.divisor + pass + this.divisor + sexo);
        return true;
    }
}