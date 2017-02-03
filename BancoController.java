package com.example.feto.mapatrab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feto on 25/01/2017.
 */

public class BancoController{
    private SQLiteDatabase bd;

    public BancoController(Context context){
        DbHelper auxBd = new DbHelper(context);
        bd = auxBd.getWritableDatabase();
    }

    public void insertAnimal(Animal animal){
        ContentValues cv = new ContentValues();
        cv.put("nomep", animal.getNomep());
        cv.put("nomec", animal.getNomec());
        cv.put("distgeo", animal.getDistgeo());
        cv.put("habitat", animal.getHabitat());
        cv.put("alimentacao", animal.getAlimentacao());
        cv.put("reproducao", animal.getReproducao());
        cv.put("caracteristicas", animal.getCaracteristicas());
        cv.put("fav", animal.getFav());
        cv.put("tipo", animal.getTipo());
        bd.insert("animal", null, cv);

    }

    public void atualizarAnimal(Animal animal){
        ContentValues cv = new ContentValues();
        cv.put("nomep", animal.getNomep());
        cv.put("nomec", animal.getNomec());
        cv.put("distgeo", animal.getDistgeo());
        cv.put("habitat", animal.getHabitat());
        cv.put("alimentacao", animal.getAlimentacao());
        cv.put("reproducao", animal.getReproducao());
        cv.put("caracteristicas", animal.getCaracteristicas());
        cv.put("fav", animal.getFav());
        cv.put("tipo", animal.getTipo());
        bd.update("animal",cv,"_id = ?", new String[]{""+animal.getId()});

    }

    public void deletarAnimal(Animal animal){
        bd.delete("animal","_id = "+animal.getId(),null);
    }

    public List<Animal> buscar(){
        List<Animal> list = new ArrayList<Animal>();
        String[] colunas = new String[]{"_id","nomep","nomec","distgeo","habitat","alimentacao","reproducao","caracteristicas","fav","tipo"};

        Cursor cursor = bd.query("animal", colunas,null,null,null,null,"nomep ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Animal a = new Animal();
                a.setId(cursor.getInt(0));
                a.setNomep(cursor.getString(1));
                a.setNomec(cursor.getString(2));
                a.setDistgeo(cursor.getString(3));
                a.setHabitat(cursor.getString(4));
                a.setAlimentacao(cursor.getString(5));
                a.setReproducao(cursor.getString(6));
                a.setCaracteristicas(cursor.getString(7));
                a.setFav(cursor.getInt(8));
                a.setTipo(cursor.getString(9));
                list.add(a);
            }while (cursor.moveToNext());
        }
        return(list);
    }


}



