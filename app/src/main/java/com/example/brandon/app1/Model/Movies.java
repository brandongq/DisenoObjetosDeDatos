package com.example.brandon.app1.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Brandon on 25-Aug-17.
 */

public class Movies implements Parcelable{
    private String nombre;
    private int duracion;
    private String director;
    private String genero;
    private int year;

    public Movies(String nombre, int duracion, String director, String genero, int year) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.director = director;
        this.genero = genero;
        this.year = year;
    }

    // ------------------ PARCELABLE STUFF ------------------

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeInt(duracion);
        parcel.writeString(director);
        parcel.writeString(genero);
        parcel.writeInt(year);
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    protected Movies(Parcel in) {
        nombre = in.readString();
        duracion = in.readInt();
        director = in.readString();
        genero = in.readString();
        year = in.readInt();
    }

    // ------------------ PARCELABLE STUFF ------------------

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
