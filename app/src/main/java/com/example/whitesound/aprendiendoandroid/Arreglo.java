package com.example.whitesound.aprendiendoandroid;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by whitesound on 07-11-17.
 */

public class Arreglo implements Parcelable {
    private int mData;
    private ArrayList<String> arreglo;
    private String divisor = null;

    @Override
    public int describeContents() {
        return 0;
    }


    // write your object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Arreglo> CREATOR = new Parcelable.Creator<Arreglo>() {
        public Arreglo createFromParcel(Parcel in) {
            return new Arreglo(in);
        }

        public Arreglo[] newArray(int size) {
            return new Arreglo[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Arreglo(Parcel in) {
        mData = in.readInt();

    }

    //-------------

    public Arreglo(String divisor){
        this.divisor = divisor;
        arreglo = new ArrayList<>();
    }


    //Para añadir un usuario se debe usar este metodo.
    //Retorna false en caso de que el usuario ya estuviese registrado.
    //true si el usuario fue añadido correctamente
    public boolean addUser(String nombre,String pass, String sexo){

        //Se revisa si el usuario no está previamente registrado.
        for (int i = 0; i < arreglo.size() ; i++){
            String user =  arreglo.get(i).split(divisor)[0];
            if (nombre.equals(user)){
                //Si el usuario es encontrado en el arreglo, se retorna un false.
                return false;
            }
        }
        arreglo.add(nombre + this.divisor + pass + this.divisor + sexo);
        return true;
    }

    public ArrayList getUsuarios(){
        return this.arreglo;
    }

}
