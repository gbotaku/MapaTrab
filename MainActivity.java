package com.example.feto.mapatrab;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.nearby.messages.EddystoneUid;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    GoogleMap mGoogleMap;
    // array de marcadores
    Marker[] animaistodos = new  Marker[10];
    int v = 0;
    int z=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BancoController bd = new BancoController(this);
        List<Animal> listaanimais = bd.buscar();
        if(listaanimais.size() == 0){
            bd.insertAnimal(new Animal(0,"avestruz","Calango","Calango","Calango","Calango","Calango","Calango",0,"ave"));
            bd.insertAnimal(new Animal(1,"cateto","Cateto","Cateto","Cateto","Cateto","Cateto","Cateto",0,"mamifero"));
            bd.insertAnimal(new Animal(2,"cutia","Calango","Calango","Calango","Calango","Calango","Calango",0,"mamifero"));
            bd.insertAnimal(new Animal(3,"gato","Cateto","Cateto","Cateto","Cateto","Cateto","Cateto",0,"mamifero"));
            bd.insertAnimal(new Animal(4,"guaxinim","Calango","Calango","Calango","Calango","Calango","Calango",0,"mamifero"));
            bd.insertAnimal(new Animal(5,"jabuti","Cateto","Cateto","Cateto","Cateto","Cateto","Cateto",0,"reptil"));
            bd.insertAnimal(new Animal(6,"jagua","Calango","Calango","Calango","Calango","Calango","Calango",0,"mamifero"));
            bd.insertAnimal(new Animal(7,"macaco","Cateto","Cateto","Cateto","Cateto","Cateto","Cateto",0,"mamifero"));
            bd.insertAnimal(new Animal(8,"quati","Calango","Calango","Calango","Calango","Calango","Calango",0,"mamifero"));
            bd.insertAnimal(new Animal(9,"tartaruga","Cateto","Cateto","Cateto","Cateto","Cateto","Cateto",0,"mamifero"));

        }else{

        }
        initMap();

    }
    private void initMap() {
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    //chamada do mapa e as funções de marcadores e movimento da tela
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        MarcAve();
        MarcVioleta();
        MarcReptil();
        goToLocationZoom(-3.811530,-38.532919, 18);

    }
    //função de movimento de tela
    private void goToLocationZoom(double i, double i1, int z) {
        LatLng ll = new LatLng(i,i1);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll,z);
        mGoogleMap.moveCamera(update);
    }

    public void visivelbusca(View view){
        if(v==0){
            EditText busca = (EditText) findViewById(R.id.editText);
            busca.setVisibility(View.VISIBLE);
            v++;
        }else{
            EditText busca = (EditText) findViewById(R.id.editText);
            busca.setVisibility(View.INVISIBLE);
            busca.setText("");
            v--;
        }

    }

    public void Fav(View view){
        Intent secondActivity = new Intent(this, Favoritos.class);
        startActivity(secondActivity);
    }

    public void busca(View view){
        EditText hue = (EditText)findViewById(R.id.editText);
        String busca = hue.getText().toString();
        if(busca.equals("")){

        }else {
            for(int i = 0; i<2; i++){
                if(animaistodos[i].getTitle().equals(busca)){
                    goToLocationZoom(animaistodos[i].getPosition().latitude,animaistodos[i].getPosition().longitude,20);
                    break;
                }
                else{
                    Toast.makeText(getApplicationContext(), busca+" não foi encontrado", Toast.LENGTH_SHORT).show();
                }
            }
       }
    }



    //funções dos marcadores do verde ao laranja
    public void MarcAve(){
        LatLng verde = new LatLng(-3.810816,-38.532859);
        animaistodos[0] = mGoogleMap.addMarker(new MarkerOptions().title("avestruz").position(verde).icon(BitmapDescriptorFactory.fromResource(R.drawable.avestruz)));
        mGoogleMap.setOnMarkerClickListener(this);
    }
    public void MarcReptil(){
        LatLng azul = new LatLng(-3.811290,-38.533057);
        animaistodos[1] = mGoogleMap.addMarker(new MarkerOptions().title("jabuti").position(azul).icon(BitmapDescriptorFactory.fromResource(R.drawable.jabuti)));
        azul = new LatLng(-3.811640,-38.533273);
        mGoogleMap.setOnMarkerClickListener(this);
        animaistodos[2] = mGoogleMap.addMarker(new MarkerOptions().title("tartaruga").position(azul).icon(BitmapDescriptorFactory.fromResource(R.drawable.jabuti)));
        mGoogleMap.setOnMarkerClickListener(this);
    }
    public void MarcVioleta(){
        LatLng violeta = new LatLng(-3.811236,-38.533052);
        animaistodos[3] = mGoogleMap.addMarker(new MarkerOptions().title("cateto").position(violeta).icon(BitmapDescriptorFactory.fromResource(R.drawable.cateto)));
        mGoogleMap.setOnMarkerClickListener(this);
        violeta = new LatLng(-3.811391,-38.533082);
        animaistodos[4] = mGoogleMap.addMarker(new MarkerOptions().title("cutia").position(violeta).icon(BitmapDescriptorFactory.fromResource(R.drawable.cutia)));
        mGoogleMap.setOnMarkerClickListener(this);
        violeta = new LatLng(-3.811273,-38.532792);
        animaistodos[5] = mGoogleMap.addMarker(new MarkerOptions().title("macaco").position(violeta).icon(BitmapDescriptorFactory.fromResource(R.drawable.macaco)));
        mGoogleMap.setOnMarkerClickListener(this);
        violeta = new LatLng(-3.811865,-38.532846);
        animaistodos[6] = mGoogleMap.addMarker(new MarkerOptions().title("quati").position(violeta).icon(BitmapDescriptorFactory.fromResource(R.drawable.quati)));
        mGoogleMap.setOnMarkerClickListener(this);
        violeta = new LatLng(-3.812043,-38.532868);
        animaistodos[7] = mGoogleMap.addMarker(new MarkerOptions().title("jagua").position(violeta).icon(BitmapDescriptorFactory.fromResource(R.drawable.jagua)));
        mGoogleMap.setOnMarkerClickListener(this);
        violeta = new LatLng(-3.812237,-38.532781);
        animaistodos[8] = mGoogleMap.addMarker(new MarkerOptions().title("guaxinim").position(violeta).icon(BitmapDescriptorFactory.fromResource(R.drawable.guaxinim)));
        mGoogleMap.setOnMarkerClickListener(this);
        violeta = new LatLng(-3.812394,-38.532890);
        animaistodos[9] = mGoogleMap.addMarker(new MarkerOptions().title("gato").position(violeta).icon(BitmapDescriptorFactory.fromResource(R.drawable.gato)));
        mGoogleMap.setOnMarkerClickListener(this);
    }

    //funções para esconder os outros marcadores e aparecer apenas o do botão selecionado
    public void Visivel(View view) {
        int x=0;
        int y=0;

        int tipo = view.getId();

        if(tipo == 2131624119){
            x=1;
            y=2;
        }else if(tipo == 2131624117){
            x=3;
            y=9;
        }else if(tipo == 2131624118){
            x=0;
            y=0;
        }

        for(int i = 0; i <10; i++){
            if(i>=x && i<=y){
                animaistodos[i].setVisible(true);
            }else{
                if(z!=-1){
                    animaistodos[i].setVisible(false);
                }else{
                    animaistodos[i].setVisible(true);
                }

            }
            if(i==9){
                z=z*(-1);
            }
        }

    }



    @Override
    //Ao clicar no marcador verde envia para a tela de informações de um exemplo de animal
    public boolean onMarkerClick(Marker marker) {
        Intent secondActivity = new Intent(this, Informacao.class);
        secondActivity.putExtra("animal", marker.getTitle());
        secondActivity.putExtra("voltar", "MainActivity");
        startActivity(secondActivity);
        return false;
    }
}
