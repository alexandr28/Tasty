package com.acampdev.borisalexandrcamposrios.tasty.POJOS;

import android.content.ContentValues;

import com.acampdev.borisalexandrcamposrios.tasty.SQLConstants;

public class Receta {

    private String id, nombre, descripcion,preparacion,imagen;
    private  int personas,fav;

    public Receta(){}

    public Receta(String id, String nombre, int personas, String descripcion,
                  String preparacion, String imagen, int fav){
        this.id= id;
        this.nombre=nombre;
        this.personas=personas;
        this.descripcion=descripcion;
        this.preparacion=preparacion;
        this.imagen=imagen;
        this.fav=fav;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public ContentValues toValues(){
        ContentValues contentValues= new ContentValues(7);
        contentValues.put(SQLConstants.COLUMN_ID,id);
        contentValues.put(SQLConstants.COLUMN_NOMBRE,nombre);
        contentValues.put(SQLConstants.COLUMN_PERSONAS,personas);
        contentValues.put(SQLConstants.COLUMN_DESCRIPCION,descripcion);
        contentValues.put(SQLConstants.COLUMN_PREPARACION,preparacion);
        contentValues.put(SQLConstants.COLUMN_IMAGE,imagen);
        contentValues.put(SQLConstants.COLUMN_FAV,fav);
        return  contentValues;
    }


}
