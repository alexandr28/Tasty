package com.acampdev.borisalexandrcamposrios.tasty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.acampdev.borisalexandrcamposrios.tasty.Helpers.DBHelper;
import com.acampdev.borisalexandrcamposrios.tasty.POJOS.Receta;

import java.util.ArrayList;
import java.util.List;

public class Data {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context){
        this.context=context;
        sqLiteOpenHelper= new DBHelper(context);
        sqLiteDatabase= sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
    }
    public void close(){
        sqLiteOpenHelper.close();
    }

    public long  getItemsCounts(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstants.tableRecetas);
    }

    public void insertReceta(Receta receta){
        ContentValues contentValues= receta.toValues();
        sqLiteDatabase.insert(SQLConstants.tableRecetas,null,contentValues);
    }

    public void insertRecetas(List<Receta> recetas){
        long items= getItemsCounts();
        if (items==0){
            for(Receta receta: recetas){
                try{
                    insertReceta(receta);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Receta> getAll(){
        List<Receta> recetas = new ArrayList<>();
        Cursor cursor= sqLiteDatabase.query(SQLConstants.tableRecetas,
                SQLConstants.ALL_COLUMNS,null,null,null,null,null);
        while (cursor.moveToNext()){
            Receta receta = new Receta();
            receta.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            receta.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            receta.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            receta.setImagen(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            receta.setFav(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            recetas.add(receta);
        }
        return recetas;
    }

    public void deteleItem(String nombre){
        String[] whereArgs = new String[]{String.valueOf(nombre)};
        sqLiteDatabase.delete(SQLConstants.tableRecetas, SQLConstants.WHERE_CLAUSE_NOMBRE,whereArgs);
    }

    // se encarga de traer los favoritos de la BD
    public List<Receta> getFavs(){
        List<Receta> recetas = new ArrayList<>();
        String[]whereArgs = new String[]{String.valueOf(1)};
        Cursor cursor= sqLiteDatabase.query(
                SQLConstants.tableRecetas,SQLConstants.ALL_COLUMNS,
                SQLConstants.WHERE_CLAUSE_FAVS,whereArgs,
                null,null,null,null);
        while (cursor.moveToNext()){
            Receta receta = new Receta();
            receta.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            receta.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            receta.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            receta.setImagen(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            receta.setFav(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            recetas.add(receta);
        }
        return recetas;
    }

    // se encarga de traer los favoritos de la BD
    public List<Receta> getPersonas(int p){
        List<Receta> recetas = new ArrayList<>();
        String[]whereArgs = new String[]{String.valueOf(p)};
        Cursor cursor= sqLiteDatabase.query(
                SQLConstants.tableRecetas,SQLConstants.ALL_COLUMNS,
                SQLConstants.WHERE_CLAUSE_PERSONAS,whereArgs,
                null,null,null,null);
        while (cursor.moveToNext()){
            Receta receta = new Receta();
            receta.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            receta.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            receta.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_PREPARACION)));
            receta.setImagen(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGE)));
            receta.setFav(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            recetas.add(receta);
        }
        return recetas;
    }
}
