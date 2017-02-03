package com.example.feto.mapatrab;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Favoritos extends AppCompatActivity {
    String animal_names[];
    Integer image_id[];
    int verif = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        BancoController bd = new BancoController(Favoritos.this);

        List<Animal> listanimais;
        listanimais = bd.buscar();
        for (int i = 0; i < listanimais.size(); i++) {
            if (listanimais.get(i).getFav() == 1) {
                verif++;
            }
        }


        if (verif == 0) {
            AlertDialog alertadialog;
            alertadialog = new AlertDialog.Builder(this).create();
            alertadialog.setTitle("Favoritados");
            alertadialog.setMessage("Nenhuma Animal foi favoritado ainda");
            alertadialog.show();
        } else {
            animal_names = new  String[verif];
            image_id = new  Integer[verif];
            int contadora = 0;
            for (int j = 0; j < listanimais.size(); j++) {
                if (listanimais.get(j).getFav() == 1) {
                    animal_names[contadora] = listanimais.get(j).getNomep();
                    switch (j) {
                        case 0:
                            image_id[contadora] = R.drawable.avestruz;
                            break;
                        case 1:
                            image_id[contadora] = R.drawable.cateto;
                            break;
                        case 2:
                            image_id[contadora] = R.drawable.cutia;
                            break;
                        case 3:
                            image_id[contadora] = R.drawable.gato;
                            break;
                        case 4:
                            image_id[contadora] = R.drawable.guaxinim;
                            break;
                        case 5:
                            image_id[contadora] = R.drawable.jabuti;
                            break;
                        case 6:
                            image_id[contadora] = R.drawable.jagua;
                            break;
                        case 7:
                            image_id[contadora] = R.drawable.macaco;
                            break;
                        case 8:
                            image_id[contadora] = R.drawable.quati;
                            break;
                        case 9:
                            image_id[contadora] = R.drawable.tartaruga;
                        default:
                            break;
                    }
                    contadora++;
                }
            }


            Customlistadapter adapter = new Customlistadapter(this, image_id, animal_names);
            ListView lv = (ListView) findViewById(R.id.listafavo);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    String Slecteditem = animal_names[+position];
                    Intent secondActivity = new Intent(Favoritos.this, Informacao.class);
                    secondActivity.putExtra("animal", Slecteditem);
                    secondActivity.putExtra("voltar", "Favoritos");
                    startActivity(secondActivity);
                }
            });
        }
    }
    public void sair(View view) {
        Intent secondActivity = new Intent(Favoritos.this, MainActivity.class);
        startActivity(secondActivity);
    }

}
