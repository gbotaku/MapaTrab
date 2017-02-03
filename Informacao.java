package com.example.feto.mapatrab;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import static android.R.drawable.btn_star_big_on;

/**
 * Created by feto on 25/01/2017.
 */

public class Informacao extends AppCompatActivity{
    String ani,voltar;
    List<Animal> listaanimais;
    int x = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao);

    }

    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        ani = intent.getStringExtra("animal");
        voltar = intent.getStringExtra("voltar");

        BancoController bd = new BancoController(this);
        listaanimais = bd.buscar();


        for (Iterator iterator = listaanimais.iterator(); iterator.hasNext();) {
            Animal animal = (Animal)iterator.next();
            if(animal.getNomep().equals(ani)){
                TextView t1 = (TextView)findViewById(R.id.nome_popular);
                t1.setText(animal.getNomep());
                TextView t2 = (TextView)findViewById(R.id.nome_cientifico);
                t2.setText(animal.getNomec());
                TextView t3 = (TextView)findViewById(R.id.aba);
                TextView t4 = (TextView)findViewById(R.id.abainfo);
                switch (x){
                    case 1: t3.setText("Características");
                            t4.setText(animal.getCaracteristicas());
                            break;
                    case 2: t3.setText("Habitat");
                            t4.setText(animal.getHabitat());
                            break;
                    case 3: t3.setText("Alimentação");
                            t4.setText(animal.getAlimentacao());
                            break;
                    case 4: t3.setText("Reprodução");
                            t4.setText(animal.getReproducao());
                            break;
                    default:break;
                }
                String tipo = animal.getTipo();
                RelativeLayout fundo = (RelativeLayout)findViewById(R.id.fundo);
                switch (tipo){
                    case "mamifero":
                        fundo.setBackgroundResource(android.R.color.holo_green_dark);
                        break;
                    case "reptil":
                        fundo.setBackgroundResource(R.color.colorAccent);
                        break;
                    case "ave":
                        fundo.setBackgroundResource(android.R.color.holo_blue_dark);

                        break;
                    default:break;
                }
                String imagem = animal.getNomep();
                ImageView x = (ImageView)findViewById(R.id.imganimal);
                switch (imagem) {
                    case "avestruz":
                        x.setBackgroundResource(R.drawable.avestruz2);
                        break;
                    case "cateto":
                        x.setBackgroundResource(R.drawable.cateto2);
                        break;
                    case "cutia":
                        x.setBackgroundResource(R.drawable.cutia2);
                        break;
                    case "gato":
                        x.setBackgroundResource(R.drawable.gato2);
                        break;
                    case "guaxinim":
                        x.setBackgroundResource(R.drawable.guaxinim2);
                        break;
                    case "jabuti":
                        x.setBackgroundResource(R.drawable.jabuti2);
                        break;
                    case "jagua":
                        x.setBackgroundResource(R.drawable.jagua2);
                        break;
                    case "macaco":
                        x.setBackgroundResource(R.drawable.macaco2);
                        break;
                    case "quati":
                        x.setBackgroundResource(R.drawable.quati2);
                        break;
                    case "tartaruga":
                        x.setBackgroundResource(R.drawable.tartaruga);
                        break;
                    default:
                        break;
                }

                if(animal.getFav() == 0){
                    ImageButton jj = (ImageButton)findViewById(R.id.estrela);
                    jj.setVisibility(View.INVISIBLE);
                    ImageButton jj2 = (ImageButton)findViewById(R.id.estrela2);
                    jj2.setVisibility(View.VISIBLE);
                }else{
                    ImageButton jj = (ImageButton)findViewById(R.id.estrela);
                    jj.setVisibility(View.VISIBLE);
                    ImageButton jj2 = (ImageButton)findViewById(R.id.estrela2);
                    jj2.setVisibility(View.INVISIBLE);
                }
            }else{
            }

        }
    }

    public void Favo(View view) {
        BancoController bd = new BancoController(this);
        listaanimais = bd.buscar();
        for (Iterator iterator = listaanimais.iterator(); iterator.hasNext();) {
            Animal animal = (Animal) iterator.next();
            if(animal.getNomep().equals(ani)){
                if(animal.getFav() == 1){
                    animal.setFav(0);
                }else{
                    animal.setFav(1);
                }
                bd.atualizarAnimal(animal);
                onResume();
            }
        }


    }


    public void Alimentacao(View view){
        x = 3;
        onResume();
    }
    public void Caracteristicas(View view){
        x = 1;
        onResume();
    }
    public void Reproducao(View view){
        x = 4;
        onResume();
    }
    public void Habitat(View view){
        x = 2;
        onResume();
    }
    //Volta pro mapa ao clicar no botão de retorno
    public void startSecondActivity(View view) {
        if(voltar.equals("Favoritos")){
            Intent secondActivity = new Intent(this, Favoritos.class);
            startActivity(secondActivity);
        }else{
            Intent secondActivity = new Intent(this, MainActivity.class);
            startActivity(secondActivity);
        }

    }


}
