package com.acampdev.borisalexandrcamposrios.tasty;

import java.util.UUID;

public class SQLConstants {

    //DB
    public static final String DB= "bdrecetas.db";
    // Tables
    public static final String tableRecetas = "recetas";
    // Columns
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NOMBRE="nombre";
    public static final String COLUMN_PERSONAS="personas";
    public static final String COLUMN_DESCRIPCION="descripcion";
    public static final String COLUMN_PREPARACION="preparacion";
    public static final String COLUMN_IMAGE="image";
    public static final String COLUMN_FAV="fav";
    // QUERY
    public static final String sql_create_table_recetas=
            "CREATE TABLE "+ tableRecetas +" (" +
                    COLUMN_ID +" TEXT PRIMARY KEY,"+
                    COLUMN_NOMBRE+" TEXT,"+
                    COLUMN_PERSONAS+" INT,"+
                    COLUMN_DESCRIPCION+" TEXT,"+
                    COLUMN_PREPARACION+" TEXT,"+
                    COLUMN_IMAGE+" TEXT,"+
                    COLUMN_FAV+" INT)";

    public static final String SQL_DELETE= "DROP TABLE IF EXISTS "+tableRecetas;
    public static final String WHERE_CLAUSE_FAVS= "fav=?";
    public static final String WHERE_CLAUSE_PERSONAS= "personas=?";
    public static final String WHERE_CLAUSE_NOMBRE = "nombre=?";
    public static final String GENERAR_ID= UUID.randomUUID().toString();
    public static final String[] ALL_COLUMNS= {
            COLUMN_ID,COLUMN_NOMBRE,COLUMN_PERSONAS,COLUMN_DESCRIPCION,COLUMN_PREPARACION,COLUMN_IMAGE,COLUMN_FAV
    };
}
