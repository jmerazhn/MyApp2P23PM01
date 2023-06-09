package com.example.myapp2p23pm01.Configuracion;

public class Transacciones {
    public static final String NameDataBase = "PM01DB";

    public static final String TablaPersonas = "PERSONAS";

    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";

    public static final String CreateTablePersona = "CREATE TABLE PERSONAS "+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, edad INTEGER, "+
            "correo TEXT)";

    public static final String DropTablePersona = "DROP TABLE IF EXIST PERSONAS";

    public static final String SelectTablePersona = "SELECT * FROM "+TablaPersonas;

}
