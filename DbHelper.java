package com.example.feto.mapatrab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by feto on 25/01/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String NOME_BASE = "Zoo";
    private static final int VERSAO_BASE = 33;


    public DbHelper(Context context){
        super(context, NOME_BASE, null, VERSAO_BASE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreateTabelaAnimal = "CREATE TABLE animal ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nomep TEXT,"
                + "nomec TEXT,"
                + "distgeo TEXT,"
                + "habitat TEXT,"
                + "alimentacao TEXT,"
                + "reproducao TEXT,"
                + "caracteristicas TEXT,"
                + "fav INTEGER,"
                + "tipo TEXT"
                + ")";

        sqLiteDatabase.execSQL(sqlCreateTabelaAnimal);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE animal");
        onCreate(sqLiteDatabase);
    }



}
